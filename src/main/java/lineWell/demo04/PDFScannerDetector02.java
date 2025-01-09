package lineWell.demo04;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.cos.COSName;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Iterator;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/10/31  11:39
 */
public class PDFScannerDetector02 {



        // 定义扫描参数
        private static final int MIN_DPI = 300;
        private static final int HIGH_QUALITY_DPI = 600;

        public static void main(String[] args) {
            File directory = new File("D:\\myfile\\租房"); // 替换为实际的目录路径
            scanDirectory(directory);
        }

        public static void scanDirectory(File directory) {
            if (!directory.isDirectory()) {
                System.out.println("提供的路径不是一个有效的目录！");
                return;
            }

            File[] files = directory.listFiles();
            if (files == null || files.length == 0) {
                System.out.println("目录中没有文件！");
                return;
            }

            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".pdf")) {
                    System.out.println("检测文件: " + file.getName());
                    try {
                        scanPDF(file);
                    } catch (IOException e) {
                        System.out.println("文件处理失败: " + file.getName() + "，错误: " + e.getMessage());
                    }
                }
            }
        }

        public static void scanPDF(File pdfFile) throws IOException {
            try (PDDocument document = PDDocument.load(pdfFile)) {
                int pageIndex = 0;
                for (PDPage page : document.getPages()) {
                    pageIndex++;
                    System.out.println("  页码: " + pageIndex);
                    Iterator<COSName> xObjectNames = page.getResources().getXObjectNames().iterator();
                    while (xObjectNames.hasNext()) {
                        COSName cosName = xObjectNames.next();
                        if (page.getResources().isImageXObject(cosName)) {
                            PDImageXObject imageObject = (PDImageXObject) page.getResources().getXObject(cosName);
                            analyzeImage(imageObject);
                        }
                    }
                }
            }
        }

        public static void analyzeImage(PDImageXObject imageObject) throws IOException {
            BufferedImage image = imageObject.getImage();

            // 检测分辨率
            int dpi = imageObject.getWidth() * 72 / image.getWidth();  // 估算DPI
            System.out.println("   检测到的DPI: " + dpi);

            if (dpi < MIN_DPI) {
                System.out.println("    警告: DPI "+dpi+" 小于 " + MIN_DPI + "，图像质量可能较差。");
            } else if (dpi >= HIGH_QUALITY_DPI) {
                System.out.println("    图像质量符合高要求。");
            }

            // 检测颜色模式
            int colorType = image.getColorModel().getColorSpace().getType();
            String colorMode;
            if (colorType == BufferedImage.TYPE_BYTE_BINARY || colorType == BufferedImage.TYPE_BYTE_GRAY) {
                colorMode = "灰度";
            } else if (colorType == BufferedImage.TYPE_3BYTE_BGR || colorType == BufferedImage.TYPE_4BYTE_ABGR) {
                colorMode = "24 位真彩色";
            } else {
                colorMode = "未知颜色模式";
            }
            System.out.println("    检测到的颜色模式: " + colorMode);
        }
    }

