package demo04.kuangshen.Tcp.uploadFiledemo02;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/24  23:31
 */


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPSeverDemo2 {
    public static void main(String[] args) {
        OutputStream outputStream = null;
        FileOutputStream fileOutputStream = null;
        ServerSocket serverSocket = null;
        InputStream inputStream = null;
        Socket socket = null;
        try {
            //1.创建服务
            serverSocket = new ServerSocket(9000);
            //2.监听客户端的连接
            socket = serverSocket.accept();//阻塞时监听，会一直等待客户端连接
            //3.获取输入流
            inputStream = socket.getInputStream();
            //4.文件输出
            fileOutputStream  = new FileOutputStream(new File("receive.jpg"));
            byte[] bytes = new byte[1024];
            int len;
            while((len = inputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }

            //通知客户端接收完毕
            outputStream = socket.getOutputStream();
            outputStream.write("接收完毕".getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                fileOutputStream.close();
                inputStream.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

