package demo05.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/6/23  23:50
 */
public class TestFileInputStream02  {
    public static void main(String args[]) {
        int b = 0;// 使用变量b来装调用read()方法时返回的整数
        FileInputStream in = null;

        try {
            in = new FileInputStream("D:\\workspace\\IDEA\\Git\\大杂烩\\java\\src\\main\\java\\demo05\\txt\\read");
        } catch (FileNotFoundException e) {
            System.out.println("系统找不到指定文件！");
            System.exit(-1);// 系统非正常退出
        }
        long num = 0;// 使用变量num来记录读取到的字符数

        try {
            while ((b = in.read()) != -1) {
                System.out.print((char) b);

                num++;
            }
            in.close();// 关闭输入流
            System.out.println();
            System.out.println("总共读取了" + num + "个字节的文件");
        } catch (IOException e1) {
            System.out.println("文件读取错误！");
        }
    }
}
