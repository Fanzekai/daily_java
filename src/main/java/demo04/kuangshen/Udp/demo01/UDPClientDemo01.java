package demo04.kuangshen.Udp.demo01;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/24  23:33
 */
//发送消息
//不需要连接服务器

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPClientDemo01 {
    public static void main(String[] args) throws IOException {
        //1.建立一个Socket
        DatagramSocket socket = new DatagramSocket();
        //2.建个包
        //发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        String msg = "你好啊，服务器";
        //参数：数据，数据起始位置，数据的结束位置，发送给谁
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(StandardCharsets.UTF_8),0,msg.getBytes(StandardCharsets.UTF_8).length,localhost,port);
        //3.发送包
        socket.send(datagramPacket);
        //4.关闭流
        socket.close();

    }
}

