package lineWell.demo03;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/10/29  14:22
 */
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageInfo;



import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ImageQualityChecker03 {

    // 主要检测方法：检查图像的质量
    public static void checkImageQuality(File imageFile) throws IOException, ImageReadException {
        System.out.println(">>>>>>>>>>>>>>>>>>>" + imageFile.getName()+">>>>>>>>>>>>>>>>>>>");

        // 加载图像
        BufferedImage image = ImageIO.read(imageFile);

        if (image == null) {
            System.out.println("无法读取图像内容。");
            return;
        }


        //checkColorMode(image);
        checkResolution(imageFile);
      //  checkImageFormat(imageFile);
        //checkCompressionQuality(imageFile);
    }

    // 1. 色彩模式检测
    private static void checkColorMode(BufferedImage image) {
        int colorType = image.getType();
        if (colorType == BufferedImage.TYPE_3BYTE_BGR || colorType == BufferedImage.TYPE_INT_RGB) {
            System.out.println("色彩模式: 符合要求（24 位真彩色）");
        } else {
            System.out.println("色彩模式: 不符合要求，需为 24 位真彩色");
        }
    }

    // 2. 分辨率检测
    private static void checkResolution(File imageFile) {
        try {
            ImageInfo imageInfo = Imaging.getImageInfo(imageFile);
            int dpiX = imageInfo.getPhysicalWidthDpi();
            int dpiY = imageInfo.getPhysicalHeightDpi();

            System.out.println("图像DPI（X）：" + dpiX);
            System.out.println("图像DPI（Y）：" + dpiY);

            if (isPhoto(imageFile) && (dpiX < 600 || dpiY < 600)) {
                System.out.println("照片的分辨率不符合600dpi的最低要求。");
            }
        } catch (Exception e) {
            System.out.println("无法确定分辨率：" + e.getMessage());
        }
    }

    // 判断文件是否为照片的简单方法
    private static boolean isPhoto(File file) {
        return file.getName().toLowerCase().contains("photo");
    }

    // 3. 图像格式检测
    private static void checkImageFormat(File imageFile) throws IOException, ImageReadException {
        ImageInfo imageInfo = Imaging.getImageInfo(imageFile);
        String format = imageInfo.getFormat().getName();
        if ("TIFF".equalsIgnoreCase(format) || "JPEG".equalsIgnoreCase(format) || "JPEG2000".equalsIgnoreCase(format) || "WEBP".equalsIgnoreCase(format)) {
            System.out.println("格式: 符合要求（TIFF、JPEG 或 JPEG2000）："+format);
        } else {
            System.out.println("格式: 不符合要求，需为 TIFF、JPEG 或 JPEG2000 格式 ："+format);
        }
    }

    // 4. JPEG 压缩质量检测
    private static void checkCompressionQuality(File imageFile) {
        String fileName = imageFile.getName().toLowerCase();
        if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg")) {
            return; // 非 JPEG 文件跳过压缩比检测
        }

        try {
            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpeg");
            if (writers.hasNext()) {
                ImageWriter writer = writers.next();
                ImageWriteParam param = writer.getDefaultWriteParam();

                if (param.canWriteCompressed()) {
                    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                    param.setCompressionQuality(0.85f); // 示例设置压缩质量为 85%
                    System.out.println("JPEG压缩质量设置为85%用于演示。");
                } else {
                    System.out.println("此写入程序无法调整JPEG压缩质量。");
                }
            }
        } catch (Exception e) {
            System.out.println("无法检查压缩质量：" + e.getMessage());
        }
    }

    // 递归遍历目录并对每个图像文件进行质量检测
    public static void checkImagesInDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                checkImagesInDirectory(file); // 递归处理子目录
            } else if (isImageFile(file))
            {
                try {
                    checkImageQuality(file);  // 调用图像质量检测方法
                } catch (IOException | ImageReadException e) {
                    System.err.println("处理图像文件时出错：" + file.getName() + " - " + e.getMessage());
                }
            }
        }
    }

    // 判断文件是否为图像文件
    private static boolean isImageFile(File file) {

        String[] imageExtensions = {"jpg", "jpeg", "png", "tif", "tiff","webp"};
        String fileName = file.getName().toLowerCase();
        for (String ext : imageExtensions) {
            if (fileName.endsWith("." + ext)) {
                return true;
            }
        }
        return false;
    }

    // 主方法，用于测试
    public static void main(String[] args) {
        String directoryPath = "D:\\linewell\\CloudCeArchive\\ofd\\photo"; // 要检测的目录路径
        File dir = new File(directoryPath);
        if (dir.exists() && dir.isDirectory()) {
            checkImagesInDirectory(dir);
        } else {
            System.out.println("目录不存在或不是一个有效目录: " + directoryPath);
        }
    }
}

