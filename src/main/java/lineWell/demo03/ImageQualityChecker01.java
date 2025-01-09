package lineWell.demo03;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/10/27  16:59
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import lombok.var;
import net.coobird.thumbnailator.Thumbnails;

public class ImageQualityChecker01 {




    // 检测图像属性
    public static void detectImageProperties(String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        BufferedImage image = ImageIO.read(imageFile);


        // 输出图像名称和文件名

        System.out.println("文件名: " + imageFile.getName());  // 输出图像文件名

        // 1. 色彩模式检测
        int colorType = image.getType();
        String colorMode = getColorMode(colorType);
        System.out.println("图像色彩模式: "  +colorMode);

        // 2. 分辨率检测
        int width = image.getWidth();
        int height = image.getHeight();
        System.out.println("分辨率: " + width + "x" + height);

        // 3. 文件格式检测
        String format = getFormatName(imageFile);
        System.out.println("格式: " + format);

        // 4. 文件大小（用于间接判断压缩情况）
        long fileSize = imageFile.length();
        System.out.println("文件大小（字节）: " + fileSize);

        // 计算压缩比率（粗略估计）
        double compressionRatio = (double) fileSize / (width * height);
        System.out.println("压缩比率: " + compressionRatio);
    }

    // 判断图像的色彩模式
    private static String getColorMode(int colorType) {
        switch (colorType) {
            case BufferedImage.TYPE_INT_RGB:
                return "RGB";
            case BufferedImage.TYPE_BYTE_GRAY:
                return "Grayscale";
            case BufferedImage.TYPE_INT_ARGB:
                return "ARGB";
            case BufferedImage.TYPE_3BYTE_BGR:
                return "BGR";
            default:
                return "Unknown";
        }
    }

    // 获取图像格式
    private static String getFormatName(File file) throws IOException {
        String formatName = null;
        try (var input = ImageIO.createImageInputStream(file)) {
            var readers = ImageIO.getImageReaders(input);
            if (readers.hasNext()) {
                var reader = readers.next();
                formatName = reader.getFormatName();
            }
        }
        return formatName;
    }

    // 调整图像色彩模式（转换为灰度）
    public static void convertToGrayscale(String imagePath, String outputPath) throws IOException {
        File imageFile = new File(imagePath);
        BufferedImage image = ImageIO.read(imageFile);

        // 创建灰度图像
        BufferedImage grayscaleImage = new BufferedImage(
                image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        // 绘制灰度图像
        grayscaleImage.getGraphics().drawImage(image, 0, 0, null);
        ImageIO.write(grayscaleImage, "jpg", new File(outputPath));
        System.out.println("已转换为灰度模式，并保存到: " + outputPath);
    }

    // 调整图像分辨率
    public static void resizeImage(String imagePath, String outputPath, int targetWidth, int targetHeight) throws IOException {
        Thumbnails.of(new File(imagePath))
                .size(targetWidth, targetHeight)
                .toFile(new File(outputPath));
        System.out.println("已调整分辨率，并保存到: " + outputPath);
    }

    // 转换图像格式
    public static void convertImageFormat(String imagePath, String outputPath, String targetFormat) throws IOException {
        BufferedImage image = ImageIO.read(new File(imagePath));
        ImageIO.write(image, targetFormat, new File(outputPath));
        System.out.println("已转换为格式: " + targetFormat + "，并保存到: " + outputPath);
    }

    // 示例调用
    public static void main(String[] args) throws IOException {
        String imagePath = "D:\\myfile\\photo\\photo\\e749a41fbafa2217da30ec11d39f33c.jpg";

        // 检测图像属性
        detectImageProperties(imagePath);

        // 转换色彩模式
     //   convertToGrayscale(imagePath, "D:\\myfile\\photo\\photo\\convert\\grayscale_image.jpg");

        // 调整分辨率
        //resizeImage(imagePath, "D:\\myfile\\photo\\photo\\convert\\resized_image.jpg", 800, 600);

        // 转换图像格式
      //  convertImageFormat(imagePath, "D:\\myfile\\photo\\photo\\convert\\converted_image.png", "png");
    }
}
