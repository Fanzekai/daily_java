package lineWell.demo04;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/10/31  14:07
 */
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.cos.COSName;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFImageDetector01 {

    public static void main(String[] args) throws IOException {
        File directory = new File("D:\\myfile\\租房"); // 替换为实际的目录路径

        if (!directory.isDirectory()) {
            System.out.println("提供的路径不是一个有效的目录！");
            return;
        }

        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".pdf")) {
                try (PDDocument document = PDDocument.load(file)) {
                    boolean hasImage = false;

                    // 遍历PDF的每一页
                    for (int i = 0; i < document.getNumberOfPages(); i++) {
                        PDPage page = document.getPage(i);
                        for (COSName cosName : page.getResources().getXObjectNames()) {
                            PDXObject xObject = page.getResources().getXObject(cosName);
                            if (xObject instanceof PDImageXObject) {
                                hasImage = true; // 检测到图像
                                break;
                            }
                        }
                        if (hasImage) break;
                    }

                    if (hasImage) {
                        System.out.println("检测文件: " + file.getName());
                        detectImageInfo(document); // 调用检测图像信息的方法
                    } else {
                        System.out.println("该 PDF 文件可能是纯文本，跳过检测：" + file.getName());
                    }
                } catch (IOException e) {
                    System.err.println("无法读取文件：" + file.getName());
                }
            }
        }
    }

    // 仅当 PDF 包含图像时调用此方法
    private static void detectImageInfo(PDDocument document) throws IOException {
        for (int i = 0; i < document.getNumberOfPages(); i++) {
            PDPage page = document.getPage(i);
            for (COSName cosName : page.getResources().getXObjectNames()) {
                PDXObject xObject = page.getResources().getXObject(cosName);
                if (xObject instanceof PDImageXObject) {
                    PDImageXObject image = (PDImageXObject) xObject;
                    int dpi = image.getWidth() * 72 / image.getHeight();
                    String colorMode = image.getBitsPerComponent() == 8 ? "24 位真彩色" : "未知";
                    String format = detectImageFormat(image);

                    System.out.println("  页码: " + (i + 1));
                    System.out.println("    检测到的DPI: " + dpi);
                    if (dpi < 300) {
                        System.out.println("    警告: DPI 小于 300，图像质量可能较差。");
                    }
                    System.out.println("    检测到的颜色模式: " + colorMode);
                    System.out.println("    检测到的扫描格式: " + format);
                }
            }
        }
    }

    // 检测图像格式
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
            return "未知格式： "+filters;
        }
    }
}
