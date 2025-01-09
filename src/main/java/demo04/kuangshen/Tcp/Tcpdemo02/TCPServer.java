package demo04.kuangshen.Tcp.Tcpdemo02;

/**
 * @author fzk
 * @version 1.0
 * @date 2025/1/6  15:40
 */
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            // 1. 创建一个服务器端 Socket，监听端口 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("服务器启动，等待客户端连接...");

            // 2. 接受客户端连接
            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端已连接：" + clientSocket.getInetAddress());

            // 3. 获取输入输出流，用于读取客户端请求和发送响应
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // 4. 读取客户端发送的数据
            String clientMessage = in.readLine();
            System.out.println("收到客户端消息: " + clientMessage);

            // 5. 发送响应给客户端
            out.println("HTTP/1.1 200 OK\nContent-Type: text/plain\n\nHello from the server!");

            // 6. 关闭连接
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("服务器关闭连接.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
