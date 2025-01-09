package lineWell.demo04;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.cos.COSName;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/10/31  11:51
 */
public class PDFScannerDetector03 {

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
                    try {
                        scanPDF(file);
                    } catch (IOException e) {
                        System.out.println("文件处理失败: " + file.getName() + "，错误: " + e.getMessage());
                    }
                }
            }
        }

    public static void scanPDF(File pdfFile) throws IOException {

        System.out.println("检测文件: " + pdfFile.getName());
        try (PDDocument document = PDDocument.load(pdfFile)) {
            boolean containsImages = false;
            int pageIndex = 0;


            for (PDPage page : document.getPages()) {
                pageIndex++;
                Iterator<COSName> xObjectNames = page.getResources().getXObjectNames().iterator();

                boolean pageHasImage = false; // 标记该页是否包含图像

                while (xObjectNames.hasNext()) {
                    COSName cosName = xObjectNames.next();
                    if (page.getResources().isImageXObject(cosName)) {
                        containsImages = true;
                        pageHasImage = true; // 该页包含图像

                        PDImageXObject imageObject = (PDImageXObject) page.getResources().getXObject(cosName);
                        System.out.println("  页码: " + pageIndex);
                        analyzeImage(imageObject,page);

                        break; // 只检测每页的第一个图像，跳出循环
                    }
                }

                // 如果该页没有图像且文件中包含图像，则不输出
                if (!pageHasImage && containsImages) {
                    System.out.println("  页码: " + pageIndex + " 没有检测到图像。");
                }
            }

            // 如果整个 PDF 都没有图像，直接输出文件跳过信息
            if (!containsImages) {
                System.out.println("该 PDF 文件可能是纯文本，跳过检测：" + pdfFile.getName());
            }
        }
    }

    //分析图像
    public static void analyzeImage(PDImageXObject imageObject,PDPage page) throws IOException {
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
        //System.out.println("    检测到的宽度 DPI: " + dpiX);
        //System.out.println("    检测到的高度 DPI: " + dpiY);

        // 判断 DPI 是否合规
        //if (dpiX < 300 || dpiY < 300) {
        //    System.out.println("    警告: DPI 小于 300，图像质量可能较差。");
        //} else {
        //    System.out.println("    DPI 合格。");
        //}
        if (dpi < MIN_DPI) {
            System.out.println("    警告: DPI "+dpi+" 小于 " + MIN_DPI + "，图像质量可能较差。");
        } else if (dpi >= HIGH_QUALITY_DPI) {
            System.out.println("    DPI "+dpi+"图像质量符合高要求");
        }

            // 检测颜色模式
        int colorType = image.getColorModel().getColorSpace().getType();
        String colorTypeName = getColorTypeName(colorType);

        System.out.println("    检测到的颜色模式: " + colorTypeName);

        // 检测图像的格式
        String format = detectImageFormat(imageObject);
        System.out.println("    检测到的图像格式: " + format);

        // 检测压缩比率
        detectCompressionRatio(imageObject);
        }

        //检测图像格式
    public static String detectImageFormat(PDImageXObject image) {
        //COSName suffix = image.getCOSObject().getCOSName(COSName.SUBTYPE);
        COSBase filters = image.getCOSObject().getFilters();


        if (COSName.DCT_DECODE.equals(filters)) {
            return "JPEG";
        } else if (COSName.JPX_DECODE.equals(filters)) {
            return "JPEG2000";
        } else if (COSName.CCITTFAX_DECODE.equals(filters)) {
            return "TIFF";
        } else {
            return "未知扫描格式";
        }
    }

    //检测压缩比
    public static void detectCompressionRatio(PDImageXObject imageObject) throws IOException {
        // 获取压缩后图像数据的大小（以字节为单位）
        long compressedSize = imageObject.getStream().getLength();

        // 计算未压缩的图像大小
        int bitsPerComponent = imageObject.getBitsPerComponent();
        int colorComponents = imageObject.getColorSpace().getNumberOfComponents();
        long uncompressedSize = (long) imageObject.getWidth() * imageObject.getHeight() * bitsPerComponent * colorComponents / 8;

        // 计算压缩比率
        double compressionRatio = (double) uncompressedSize / compressedSize;
        System.out.printf("    压缩比率: %.2f\n", compressionRatio);
    }

    // 获取图像色彩类型
    public static String getColorTypeName(int colorType) {
        switch (colorType) {
            case BufferedImage.TYPE_INT_RGB:
                return "TYPE_INT_RGB (8-bit RGB)";
            case BufferedImage.TYPE_INT_ARGB:
                return "TYPE_INT_ARGB (8-bit RGBA)";
            case BufferedImage.TYPE_INT_ARGB_PRE:
                return "TYPE_INT_ARGB_PRE (8-bit RGBA, premultiplied)";
            case BufferedImage.TYPE_INT_BGR:
                return "TYPE_INT_BGR (8-bit BGR)";
            case BufferedImage.TYPE_3BYTE_BGR:
                return "TYPE_3BYTE_BGR (3-byte BGR)";
            case BufferedImage.TYPE_4BYTE_ABGR:
                return "TYPE_4BYTE_ABGR (4-byte ABGR)";
            case BufferedImage.TYPE_4BYTE_ABGR_PRE:
                return "TYPE_4BYTE_ABGR_PRE (4-byte ABGR, premultiplied)";
            case BufferedImage.TYPE_BYTE_GRAY:
                return "TYPE_BYTE_GRAY (8-bit Grayscale)";
            case BufferedImage.TYPE_USHORT_GRAY:
                return "TYPE_USHORT_GRAY (16-bit Grayscale)";
            case BufferedImage.TYPE_BYTE_BINARY:
                return "TYPE_BYTE_BINARY (Binary Image)";
            case BufferedImage.TYPE_BYTE_INDEXED:
                return "TYPE_BYTE_INDEXED (Indexed Color)";
            default:
                return "Unknown Image Type";
        }
    }
    }
