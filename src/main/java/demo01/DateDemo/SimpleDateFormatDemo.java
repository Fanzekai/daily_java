package demo01.DateDemo;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/22  14:53
 */
public class SimpleDateFormatDemo {



    public static void main(String[] args) {
        // 创建SimpleDateFormat对象，并指定日期时间的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 格式化当前时间
        String formattedDate = sdf.format(new Date());
        System.out.println("Formatted Date: " + formattedDate);

        try {
            // 解析字符串为日期时间对象
            Date parsedDate = sdf.parse("2022-04-20 15:30:00");
            System.out.println("Parsed Date: " + parsedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
