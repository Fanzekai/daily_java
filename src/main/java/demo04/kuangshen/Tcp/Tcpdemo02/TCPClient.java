package demo04.kuangshen.Tcp.Tcpdemo02;

/**
 * @author fzk
 * @version 1.0
 * @date 2025/1/6  15:40
 */
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {

            //三次握手建立连接
            // 1. 创建客户端 Socket，连接到服务器 127.0.0.1:12345
            Socket socket = new Socket("localhost", 12345);
            System.out.println("已连接到服务器");

            // 2. 获取输入输出流，用于发送请求和接收响应
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 3. 发送 HTTP 请求
            out.println("GET / HTTP/1.1");

            // 4. 接收并打印服务器响应
            String serverResponse;
            while ((serverResponse = in.readLine()) != null) {
                System.out.println("服务器响应: " + serverResponse);
            }

            // 5. 关闭连接
            in.close();
            out.close();

            //四次挥手关闭连接
            socket.close();
            System.out.println("客户端关闭连接.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
