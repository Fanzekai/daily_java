package lineWell.demo05;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/11/5  9:19
 */
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class PdfFileInfo {
    public static void main(String[] args) {
        //String filePath = "path/to/your/pdf/file.pdf"; // 替换为你的PDF文件路径
        String pdfFilePath = "C:\\Users\\fzk\\Desktop\\11410100005252709W3000109036000-2022-D10-00000050\\结果\\行政许可申请表.pdf";
        File file = new File(pdfFilePath);

        PDDocument document = null;
        if (file.exists() && file.isFile()) {
            try {
                BasicFileAttributes attrs = Files.readAttributes(Paths.get(pdfFilePath), BasicFileAttributes.class);
                System.out.println("文件名: " + file.getName());
                System.out.println("文件大小: " + attrs.size() + " bytes");
                System.out.println("创建时间: " + attrs.creationTime());
                System.out.println("上次修改时间: " + attrs.lastModifiedTime());
                System.out.println("上次访问时间: " + attrs.lastAccessTime());
                document = PDDocument.load(new File(pdfFilePath));
                PDDocumentInformation docInfo = document.getDocumentInformation();
                // 获取页面数量
                int numberOfPages = document.getNumberOfPages();
                System.out.println("页面数量: " + numberOfPages);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist or is not a file.");
        }
    }
}
