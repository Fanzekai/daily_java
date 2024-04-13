package demo05.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/6/8  21:55
 */
//输入流
public class TestFileInputStream01 {
    public static void main(String args[]) {


        FileInputStream in = null;

        try {
            in = new FileInputStream("D:\\workspace\\IDEA\\Git\\大杂烩\\java\\src\\main\\java\\demo05\\txt\\read");

            byte[] bytes = new byte[1024];

            int read = in.read(bytes); // 将文件内容读取到字节数组中,记录一共读了多少字节
            if (in.read(bytes) == -1) { // 此时判断的是是否已经到达文件末尾
                System.out.println(new String(bytes, 0, read)); // 输出实际读取的内容
            }

            System.out.println("剩下几个字节没有读:"+in.available());
        } catch (FileNotFoundException e) {
            System.out.println("系统找不到指定文件！");
            System.exit(-1);// 系统非正常退出
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            in.close();// 关闭输入流

        } catch (IOException e1) {
            System.out.println("文件读取错误！");
        }
    }
}
