package lineWell.demo05;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/11/3  1:43
 */
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import java.io.File;
import java.io.IOException;

public class FilePropertiesDetector {

    // 检测 PDF 文件属性
    public void printPdfProperties(String pdfFilePath) {
        try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
            PDDocumentInformation info = document.getDocumentInformation();
            System.out.println("PDF属性:");
            System.out.println("标题: " + info.getTitle());
            System.out.println("作者: " + info.getAuthor());
            System.out.println("主题：: " + info.getSubject());
            System.out.println("关键词: " + info.getKeywords());
            System.out.println("创建日期: " + info.getCreationDate());
            System.out.println("修改日期: " + info.getModificationDate());
        } catch (IOException e) {
            System.err.println("读取PDF文件时出错: " + e.getMessage());
        }
    }

    // 检测 OFD 文件属性
    //public void printOFDProperties(String ofdFilePath) {
    //    try {
    //        OFDDocument ofdDocument = new OFDDocument(new File(ofdFilePath));
    //        OFD ofd = ofdDocument.getOFD();
    //        System.out.println("OFD Properties:");
    //        System.out.println("Document Title: " + ofd.getDocumentTitle());
    //        System.out.println("Author: " + ofd.getAuthor());
    //        System.out.println("Creation Date: " + ofd.getCreationDate());
    //        // 可以添加更多的 OFD 属性输出
    //    } catch (IOException e) {
    //        System.err.println("Error reading OFD file: " + e.getMessage());
    //    }
    //}

    // 主方法示例
    public static void main(String[] args) {
        FilePropertiesDetector detector = new FilePropertiesDetector();

        // 修改为您的 PDF 和 OFD 文件路径
        String pdfFilePath = "D:\\myfile\\简历\\个人简历.pdf";
        String ofdFilePath = "path/to/your/file.ofd";

        detector.printPdfProperties(pdfFilePath);
        //detector.printOFDProperties(ofdFilePath);
    }
}
