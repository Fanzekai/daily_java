package demo05.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/6/24  16:19
 */
public class TestBufferStream02{
    public static void main(String args[]){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("src\\main\\java\\com\\fzk\\demo1\\copy"));
//在节点流FileWriter的外面再套一层处理流BufferedWriter
                    String s = null;
            for(int i=0;i<10;i++){
                s = String.valueOf(Math.random());//“Math.random()”将会生成一
                bw.write(s);//把随机数字符串写入到指定文件中
                bw.newLine();//调用newLine()方法使得每写入一个随机数就换行显示
            }
            bw.flush();//调用flush()方法清空缓冲区
            BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\com\\fzk\\demo1\\copy"));
//在节点流FileReader的外面再套一层处理流BufferedReader
            while((s = br.readLine())!=null){
//使用BufferedReader处理流里面提供String readLine()方法读取文件中的数据时是一行一行读取的
//循环结束的条件就是使用readLine()方法读取数据返回的字符串为空值后则表示已经读取到文件的末尾了。
                System.out.println(s);
            }
            bw.close();
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
