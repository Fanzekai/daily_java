package demo05.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/6/8  22:08
 */
public class TestFileOutputStream {
public static void main(String args[]) {
        int b = 0;
        FileInputStream in = null;
        FileOutputStream out = null;

        try
        {
            in = new FileInputStream("D:\\workspace\\IDEA\\Git\\大杂烩\\java\\src\\main\\java\\demo05\\txt\\read");
            out = new FileOutputStream("D:\\workspace\\IDEA\\Git\\大杂烩\\java\\src\\main\\java\\demo05\\txt\\writer");
            while ((b = in.read()) != -1) {
            out.write((int) b);
        }
        in.close();
        out.close();
        }
        catch (FileNotFoundException e) {
                System.out.println("文件读取失败");
                System.exit(-1);// 非正常退出
        }
        catch (IOException e1) {
                System.out.println("文件复制失败！");
                System.exit(-1);
        }
        System.out.println("写入成功！");
}
}
