package lineWell.demo04;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.cos.COSName;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/10/31  17:36
 */
public class PDFScannerDetector04 {

    // 定义扫描参数
    private static final int MIN_DPI = 300;
    private static final int HIGH_QUALITY_DPI = 600;

    public static void main(String[] args)  {
        File directory = new File("D:\\myfile\\租房"); // 替换为实际的目录路径
        scanDirectorys(directory);
    }

    private static void scanDirectorys(File directory) {
        Queue<File> queue = new LinkedList<>();
        queue.add(directory);
        while (!queue.isEmpty()) {
            File current = queue.poll();
            if (current.isDirectory()) {
                Collections.addAll(queue, Objects.requireNonNull(current.listFiles()));
            } else if (current.isFile() && current.getName().toLowerCase().endsWith(".pdf")) {
                try {
                    if (isImageOnlyPDF(current)) {
                        scanPDF(current); // 仅当文件为纯图像时进行扫描
                    }
                    else {
                        System.out.println("跳过文件：" + current.getName() + "，包含非图像页。");
                    }
                } catch (IOException e) {
                    System.out.println("文件处理失败: " + current.getName() + "，错误: " + e.getMessage());
                }
            }
        }
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
            if (file.isDirectory()) {
                scanDirectory(file); // 递归处理子目录
            }else {
            if (file.isFile() && file.getName().toLowerCase().endsWith(".pdf")) {
                try {
                    if (isImageOnlyPDF(file)) {
                        scanPDF(file); // 仅当文件为纯图像时进行扫描
                    }
                    //else {
                    //    System.out.println("跳过文件：" + file.getName() + "，包含非图像页。");
                    //}
                } catch (IOException e) {
                    System.out.println("文件处理失败: " + file.getName() + "，错误: " + e.getMessage());
                }
            }}
        }
    }

    // 检查 PDF 是否为纯图像 PDF 文件
    public static boolean isImageOnlyPDF(File pdfFile) throws IOException {
        try (PDDocument document = PDDocument.load(pdfFile)) {
            for (PDPage page : document.getPages()) {
                Iterator<COSName> xObjectNames = page.getResources().getXObjectNames().iterator();
                boolean pageHasImage = false;

                while (xObjectNames.hasNext()) {
                    COSName cosName = xObjectNames.next();
                    if (page.getResources().isImageXObject(cosName)) {
                        pageHasImage = true;
                        break;
                    }
                }

                if (!pageHasImage) {
                    return false; // 如果存在没有图像的页，返回 false
                }
            }
            return true; // 所有页面均包含图像
        }
    }

    public static void scanPDF(File pdfFile) throws IOException {
        System.out.println("检测文件: " + pdfFile.getName());

        try (PDDocument document = PDDocument.load(pdfFile)) {
            int pageIndex = 0;

            for (PDPage page : document.getPages()) {
                pageIndex++;
                Iterator<COSName> xObjectNames = page.getResources().getXObjectNames().iterator();

                while (xObjectNames.hasNext()) {
                    COSName cosName = xObjectNames.next();
                    if (page.getResources().isImageXObject(cosName)) {
                        PDImageXObject imageObject = (PDImageXObject) page.getResources().getXObject(cosName);
                        System.out.println("  页码: " + pageIndex);
                        analyzeImage(imageObject, page);
                        break; // 只检测每页的第一个图像，跳出循环
                    }
                }
            }
        }
    }

    public static void analyzeImage(PDImageXObject imageObject, PDPage page) throws IOException {
        BufferedImage image = imageObject.getImage();
        // 检测分辨率
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        // 获取图像在页面上的实际宽高（以点为单位）
        float displayedWidth = page.getMediaBox().getWidth();
        float displayedHeight = page.getMediaBox().getHeight();

        // 计算 DPI
        float dpiX = (imageWidth / displayedWidth) * 72;
        float dpiY = (imageHeight / displayedHeight) * 72;
        int dpi = imageObject.getWidth() * 72 / image.getWidth();

        if (dpi < MIN_DPI) {
            System.out.println("    警告: DPI " + dpi + " 小于 " + MIN_DPI + "，图像质量可能较差。");
        } else if (dpi >= HIGH_QUALITY_DPI) {
            System.out.println("    DPI " + dpi + " 图像质量符合高要求");
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

        // 检测图像的格式
        String format = detectImageFormat(imageObject);
        System.out.println("    检测到的图像格式: " + format);

        // 检测压缩比率
        float compressionRatio = (float) (imageObject.getCOSObject().getLength() * 8) / (imageWidth * imageHeight);
        System.out.println("    压缩比率: " + String.format("%.2f", compressionRatio));
    }

    public static String detectImageFormat(PDImageXObject image) {
        COSBase filters = image.getCOSObject().getFilters();

        if (COSName.DCT_DECODE.equals(filters)) {
            return "JPEG";
        } else if (COSName.JPX_DECODE.equals(filters)) {
            return "JPEG2000";
        } else if (COSName.CCITTFAX_DECODE.equals(filters)) {
            return "TIFF";
        } else {
            return "未知格式：" + filters;
        }
    }
}
