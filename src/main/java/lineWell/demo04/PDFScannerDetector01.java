package lineWell.demo04;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/10/31  10:13
 */
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.PDFRenderer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.*;


public class PDFScannerDetector01 {



        public static void main(String[] args) {
            File file = new File("D:\\myfile\\租房\\房屋租赁合同.pdf"); // 替换为 PDF 文件的路径

            try (PDDocument document = PDDocument.load(file)) {
                PDFRenderer pdfRenderer = new PDFRenderer(document);

                // 遍历 PDF 页面
                for (int i = 0; i < document.getNumberOfPages(); i++) {
                    PDPage page = document.getPage(i);
                    List<Object> pageImages = StreamSupport.stream(page.getResources().getXObjectNames().spliterator(), false)
                            .map(name -> {
                                try {
                                    return page.getResources().getXObject(name);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            })
                            .collect(Collectors.toList());

                    // 检查每个图像的色深和 DPI
                    for (Object obj : pageImages) {
                        if (obj instanceof PDImageXObject) {
                            PDImageXObject image = (PDImageXObject) obj;

                            // 获取色深
                            int colorDepth = image.getBitsPerComponent();
                            System.out.println("色深: " + colorDepth + " 位");

                            // 计算 DPI
                            float dpiX = 72 * image.getWidth() / page.getMediaBox().getWidth();
                            float dpiY = 72 * image.getHeight() / page.getMediaBox().getHeight();
                            System.out.println("DPI (X方向): " + dpiX);
                            System.out.println("DPI (Y方向): " + dpiY);

                            // 检查是否符合要求
                            if (colorDepth >= 24) {
                                System.out.println("色深满足要求：24 位或更高");
                            } else {
                                System.out.println("色深不满足要求");
                            }

                            if (dpiX >= 300 && dpiY >= 300) {
                                System.out.println("DPI 满足要求：300 dpi 或更高");
                            } else {
                                System.out.println("DPI 不满足要求");
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





