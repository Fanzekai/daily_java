package demo05.IO;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/6/8  22:22
 */

//：使用FileWriter（字符流）向指定文件中写入数据
public class TestFileWriter {
    public static void main(String[] args) {


        FileWriter fw = null;
        try{
            /*使用FileWriter（字符流）向指定文件中写入数据写入数据时以1个字符为单位进行写入*/
            fw = new FileWriter("D:\\workspace\\IDEA\\mianshi\\IO\\src\\main\\java\\com\\fzk\\demo1\\gushi");
            for(int c=0;c<=60000;c++){
                fw.write((char)c);

            }

            int b = 0;
            long num = 0;
            FileReader fr = null;
            /*使用FileReader(字符流)读取指定文件里面的内容读取内容时是以一个字符为单位进行读取的*/
            fr = new FileReader("D:\\workspace\\IDEA\\mianshi\\IO\\src\\main\\java\\com\\fzk\\demo1\\copy");
            while((b = fr.read())!= -1){
                System.out.print((char) b);
                num++;
            }
            System.out.println();
            System.out.println("总共读取了"+num+"个字符");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


