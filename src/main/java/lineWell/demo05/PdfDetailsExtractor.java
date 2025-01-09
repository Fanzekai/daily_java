package lineWell.demo05;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/11/5  9:24
 */
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfDetailsExtractor {

    public static void main(String[] args) {
        //String filePath = "path/to/your/pdf/file.pdf"; // 替换为你的PDF文件路径
        String filePath = "C:\\Users\\fzk\\Desktop\\11410100005252709W3000109036000-2022-D10-00000050\\结果\\行政许可申请表.pdf";

        PDDocument document = null;

        try {
            document = PDDocument.load(new File(filePath));
            PDDocumentInformation docInfo = document.getDocumentInformation();

            // 输出文件信息
            System.out.println("文件名称: " + docInfo.getTitle());
            System.out.println("作者: " + docInfo.getAuthor());
            System.out.println("主题: " + docInfo.getSubject());
            System.out.println("创建者: " + docInfo.getCreator());
            System.out.println("生产者: " + docInfo.getProducer());
            //System.out.println("创建日期: " + docInfo.getCreationDate());
            //System.out.println("修改日期: " + docInfo.getModificationDate());

            // 获取页面数量
            int numberOfPages = document.getNumberOfPages();
            System.out.println("页面数量: " + numberOfPages);

            // 遍历每一页，获取页面尺寸
            for (int i = 0; i < numberOfPages; i++) {
                PDPage page = document.getPage(i);
                System.out.println("第 " + (i + 1) + " 页尺寸: " + page.getMediaBox().getWidth() + " x " + page.getMediaBox().getHeight());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
