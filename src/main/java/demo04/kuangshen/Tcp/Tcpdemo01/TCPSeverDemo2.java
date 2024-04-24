package demo04.kuangshen.Tcp.Tcpdemo01;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/24  23:27
 */


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
服务端
 */
public class TCPSeverDemo2 {

    public static void main(String[] args) {
        ByteArrayOutputStream bos = null;
        InputStream inputStream  =null;
        Socket socket = null;
        ServerSocket serverSocket  = null;
        try {
            //1.我的有一个地址
            serverSocket = new ServerSocket(9999);
            while(true) {
                //2.等待客户端连接进来
                socket = serverSocket.accept();
                //3.读取客户端的消息
                inputStream = socket.getInputStream();

                /*在传输的过程中，可能会出现问题
                byte[] bytes = new byte[1024];
                int len;
                while((len = inputStream.read(bytes)) != -1){
                String s = new String(bytes,0,len);
                System.out.println(s);
                }*/

                //管道流
                bos = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                System.out.println(bos.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if (bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket!= null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

