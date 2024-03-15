package demo05;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/6/24  16:27
 */
public class TestOutputStreamWriter {
    public static void main(String[] args) {

        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src\\main\\java\\com\\fzk\\demo1\\copy"));
            osw.write("hello,world");// 把字符串写入到指定的文件中去
            System.out.println(osw.getEncoding());// 使用getEncoding()方法取得当前系统的默认字符编码
            osw.close();
            osw = new OutputStreamWriter(new FileOutputStream("src\\main\\java\\com\\fzk\\demo1\\copy", true), "ISO8859_1");
// 如果在调用FileOutputStream的构造方法时没有加入true，那么新加入的字符串就会替换掉原来写入的字符串，在调用构造方法时指定了字符的编码
            osw.write("MircosoftsunIBMOracleApplet");// 再次向指定的文件写入字符串，新写入的字符串加入到原来字符串的后面
            System.out.println(osw.getEncoding());
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


