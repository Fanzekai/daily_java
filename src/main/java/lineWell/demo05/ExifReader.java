package lineWell.demo05;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/11/1  9:19
 */
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;

public class ExifReader {



        public static void main(String[] args) {
            // 替换为你的目录路径
            String directoryPath = "D:\\myfile\\租房";
            File directory = new File(directoryPath);

            if (directory.exists() && directory.isDirectory()) {
                listJpgFiles(directory);
            } else {
                System.out.println("提供的路径不是有效的目录。");
            }
        }

        public static void listJpgFiles(File dir) {
            // 获取目录下的所有文件和子目录
            File[] files = dir.listFiles();
            if (files == null) return;

            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归遍历子目录
                    listJpgFiles(file);
                } else if (file.isFile() && file.getName().toLowerCase().endsWith(".jpg")) {
                    // 处理 JPG 文件
                    printCameraInfo(file);
                }
            }
        }

        public static void printCameraInfo(File jpgFile) {
            try {
                Metadata metadata = ImageMetadataReader.readMetadata(jpgFile);
                ExifIFD0Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);

                if (directory != null) {
                    String cameraMake = directory.getString(ExifIFD0Directory.TAG_MAKE);
                    String cameraModel = directory.getString(ExifIFD0Directory.TAG_MODEL);
                    System.out.println("文件名: " + jpgFile.getName());
                    System.out.println("相机品牌: " + (cameraMake != null ? cameraMake : "未知"));
                    System.out.println("相机型号: " + (cameraModel != null ? cameraModel : "未知"));
                    System.out.println("------------------------------------");
                } else {
                    System.out.println("文件名: " + jpgFile.getName() + " - 没有相机信息");
                    System.out.println("------------------------------------");
                }
            } catch (IOException e) {
                System.out.println("读取文件失败: " + jpgFile.getName());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("无法解析文件: " + jpgFile.getName());
                e.printStackTrace();
            }
        }
    }




