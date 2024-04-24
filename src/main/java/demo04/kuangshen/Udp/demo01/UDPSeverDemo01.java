package demo04.kuangshen.Udp.demo01;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/24  23:33
 */


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//接受消息
//还是要等待客户端的连接
public class UDPSeverDemo01 {
    public static void main(String[] args) throws IOException {
        //开放端接口
        DatagramSocket socket = new DatagramSocket(9090);
        //接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);//接收

        socket.receive(datagramPacket);//阻塞接收
        System.out.println(datagramPacket.getAddress().getHostAddress());
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));

        socket.close();

    }
}

