package demo05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/6/24  16:31
 */
public class TestInputStreamReader {

    public static void main(String args[]){
        try{

//System.in这里的in是一个标准的输入流，用来接收从键盘输入的数据,buffer只支持字符参数，应先用InputStreamReader类转换
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = null;
            s = br.readLine();//使用readLine()方法把读取到的一行字符串保存到字符串变量s中去
            while(s != null){
                System.out.println(s.toUpperCase());//把保存在内存s中的字符串打印出来
                        s = br.readLine();//在循环体内继续接收从键盘的输入
                if(s.equalsIgnoreCase("exit")){
            //只要输入exit循环就结束，就会退出
                break;
            }
        }
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
