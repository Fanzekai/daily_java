package demo05;

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
            int read = in.read();
            System.out.println((char) read);
            int read2 = in.read();
            System.out.println(read2);
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
