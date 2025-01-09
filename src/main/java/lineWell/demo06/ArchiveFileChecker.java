package lineWell.demo06;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/11/15  9:09
 */
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ArchiveFileChecker {

    public static void main(String[] args) {
        //String zipFilePath = "path/to/archive.zip";
        String destDir = "D:\\linewell\\CloudCeArchive\\ofd\\document\\tmp\\11";

        // Step 1: Unzip the archive
        //unzip(zipFilePath, destDir);

        // Step 2: Check files for corruption and collect results
        List<String> corruptFiles = new ArrayList<>();
        File folder = new File(destDir);
        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                try {
                    System.out.println("检测文件: " + file.getName());
                    checkFile(file);
                } catch (IOException e) {
                    corruptFiles.add(file.getName());
                }
            }
        }

        // Summary of corrupt files
        if (!corruptFiles.isEmpty()) {
            System.out.println("\n文件已损坏:");
            for (String fileName : corruptFiles) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("All files are valid and readable.");
        }
    }

    public static void unzip(String zipFilePath, String destDir) {
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zipIn.getNextEntry()) != null) {
                File file = new File(destDir, entry.getName());
                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    new File(file.getParent()).mkdirs();
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        int length;
                        while ((length = zipIn.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                }
                zipIn.closeEntry();
            }
        } catch (IOException e) {
            System.err.println("解压缩文件失败: " + e.getMessage());
        }
    }

    public static void checkFile(File file) throws IOException {
        String fileName = file.getName().toLowerCase();

        if (fileName.endsWith(".pdf")) {
            // Attempt to open PDF
            try (PDDocument doc = PDDocument.load(file)) {
                // Successfully opened PDF
            } catch (IOException e) {
                throw new IOException("PDF文件已损坏");
            }
        } else if (fileName.endsWith(".docx")) {
            // Check for valid DOCX file
            if (isOfficeFile(file)) {
                try (FileInputStream fis = new FileInputStream(file);
                     XWPFDocument doc = new XWPFDocument(fis)) {
                    // Successfully opened DOCX
                } catch (IOException e) {
                    throw new IOException("DOCX文件已损坏");
                }
            } else {
                throw new IOException("不是有效的OOXML文件（需要DOCX）");
            }
        } else {
            System.out.println("不支持的文件类型或没有损坏检查：" + file.getName());
        }
    }

    public static boolean isOfficeFile(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] header = new byte[4];
            if (fis.read(header) != 4) {
                return false;
            }
            // DOCX/XLSX/PPTX files start with: PK (hex: 50 4B)
            return header[0] == (byte) 0x50 && header[1] == (byte) 0x4B;
        } catch (IOException e) {
            return false;
        }
    }
}
