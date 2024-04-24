package demo04.kuangshen.Tcp.uploadFiledemo02;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/24  23:30
 */

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class TCPClientDemo2 {
    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        Socket socket = null;
        try {
            //1.创建一个Socket连接
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
            //2.创建一个输出流
            outputStream = socket.getOutputStream();
            //3.文件流
            fileInputStream  = new FileInputStream(new File("123.jpg"));
            //4.写出文件
            byte[] bytes = new byte[1024];
            int len;
            while((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
            //通知服务我已经传输结束
            socket.shutdownOutput();//我已经输出完了

            //确定服务器接完毕，才能断开连接
            inputStream = socket.getInputStream();
            //管道流
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[1024];
            while(( len  = inputStream.read(bytes1))!= -1){
                byteArrayOutputStream.write(bytes1,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                byteArrayOutputStream.close();
                inputStream.close();
                fileInputStream.close();
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

