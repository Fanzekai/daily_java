package lineWell.demo03;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/10/30  15:41
 */
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.Directory;

import com.drew.metadata.exif.ExifIFD0Directory;
import java.io.File;


public class ImageResolutionChecker {
    public static void main(String[] args) {
        String imagePath = "D:\\myfile\\photo\\photo\\e749a41fbafa2217da30ec11d39f33c.jpg";

        File imageFile = new File(imagePath); // 修改为你的图像路径
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(imageFile);

            boolean resolutionFound = false;
            float xResolution = 0;
            float yResolution = 0;

            // 检查 ExifIFD0Directory 来找到分辨率信息
            for (Directory directory : metadata.getDirectories()) {
                if (directory instanceof ExifIFD0Directory) {
                    ExifIFD0Directory exifDirectory = (ExifIFD0Directory) directory;
                    if (exifDirectory.containsTag(ExifIFD0Directory.TAG_X_RESOLUTION) &&
                            exifDirectory.containsTag(ExifIFD0Directory.TAG_Y_RESOLUTION)) {
                        xResolution = exifDirectory.getFloat(ExifIFD0Directory.TAG_X_RESOLUTION);
                        yResolution = exifDirectory.getFloat(ExifIFD0Directory.TAG_Y_RESOLUTION);
                        resolutionFound = true;
                        break;
                    }
                }
            }

            if (resolutionFound) {
                System.out.println("X Resolution: " + xResolution + " DPI");
                System.out.println("Y Resolution: " + yResolution + " DPI");

                // 检查分辨率
                if (xResolution >= 300 && yResolution >= 300) {
                    System.out.println("非纸质照片档案符合要求");
                } else if (xResolution >= 600 && yResolution >= 600) {
                    System.out.println("纸质照片档案符合要求");
                } else {
                    System.out.println("分辨率不符合要求");
                }
            } else {
                System.out.println("图像文件不包含分辨率信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
