package lineWell.demo03;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/10/29  0:11
 */
import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ImageQualityChecker02 {
    private File imageFile;
    private BufferedImage image;

    // 构造方法
    public ImageQualityChecker02(File imageFile) throws IOException {
        this.imageFile = imageFile;
        this.image = ImageIO.read(imageFile);
    }

    // 主要检测方法
    public void checkImageQuality() throws IOException, ImageReadException {
        System.out.println("图像文件: " + imageFile.getName());
        checkColorMode();
        checkResolution();
        checkImageFormat();
        checkCompressionQuality();
    }

    // 1. 色彩模式检测
    private void checkColorMode() {
        int colorType = image.getType();
        if (image.getType() == BufferedImage.TYPE_3BYTE_BGR || image.getType() == BufferedImage.TYPE_INT_RGB) {
            System.out.println("色彩模式: 符合要求（24 位真彩色）");
        } else {
            System.out.println("色彩模式: 不符合要求，需为 24 位真彩色");
        }
    }

    // 2. 分辨率检测
    private void checkResolution() {
        try {
            ImageInfo imageInfo = Imaging.getImageInfo(imageFile);
            int dpiX = imageInfo.getPhysicalWidthDpi();
            int dpiY = imageInfo.getPhysicalHeightDpi();

            System.out.println("图像DPI（X）：" + dpiX);
            System.out.println("图像DPI（y）：" + dpiY);



            // 特殊情况：检查是否为照片
            if (isPhoto(imageFile) && (dpiX < 600 || dpiY < 600)) {
                System.out.println("照片的分辨率不符合600dpi的最低要求。");
            }
        } catch (Exception e) {
            System.out.println("无法确定分辨率：" + e.getMessage());
        }
    }

    // 用于检查是否为照片的简单方法（根据文件命名或元数据等逻辑）
    private boolean isPhoto(File file) {
        // 可以使用文件命名或元数据判断是否为照片（这里以文件名为例）
        return file.getName().toLowerCase().contains("photo");
    }

    // 3. 图像格式检测
    private void checkImageFormat() throws IOException, ImageReadException {
        ImageInfo imageInfo = Imaging.getImageInfo(imageFile);
        // 检测图像格式是否为 TIFF、JPEG、或 JPEG2000
        String format = imageInfo.getFormat().getName();
        if ("TIFF".equalsIgnoreCase(format) || "JPEG".equalsIgnoreCase(format) || "JPEG2000".equalsIgnoreCase(format)) {
            System.out.println("格式: 符合要求（TIFF、JPEG 或 JPEG2000）");
        } else {
            System.out.println("格式: 不符合要求，需为 TIFF、JPEG 或 JPEG2000 格式");
        }
    }

    // 4. JPEG 压缩质量检测
    private void checkCompressionQuality() {
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

    public static void main(String[] args) {
        try {
            String imagePath = "D:\\myfile\\photo\\photo\\e749a41fbafa2217da30ec11d39f33c.jpg";
            File imageFile = new File(imagePath);
            ImageQualityChecker02 checker = new ImageQualityChecker02(imageFile);
            checker.checkImageQuality();
        } catch (IOException | ImageReadException e) {
            System.err.println("加载图像时出错：" + e.getMessage());
        }
    }
}
