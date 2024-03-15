package demo05;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/6/23  15:40
 */
public class TestFileInputStreamFinal {

            public static void main(String args[]) {

                FileInputStream in = null;
                try {
                    in = new FileInputStream("D:\\workspace\\IDEA\\Git\\大杂烩\\java\\src\\main\\java\\demo05\\txt\\read");

                } catch (FileNotFoundException e) {
                    System.out.println("系统找不到指定文件！");
                    System.exit(-1);// 系统非正常退出
                }

                try {
                    byte[] bytes=new byte[1024];
                    int readCount=0;
                    while((readCount=in.read(bytes))!= -1) {
                        //把byte数组转换成字符串，读到多少个就转换多少个
                        System.out.println(new String(bytes, 0, readCount));
                    }
                    in.close();// 关闭输入流

                } catch (IOException e1) {
                    System.out.println("文件读取错误！");
                }
            }}
