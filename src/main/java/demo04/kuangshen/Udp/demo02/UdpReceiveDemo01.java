package demo04.kuangshen.Udp.demo02;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/24  23:36
 */


import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveDemo01 {
    public static void main(String[] args) throws Exception{
        // 开放端口
        DatagramSocket socket = new DatagramSocket(6666);
        while (true) {
            // 准备接收包裹
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet);
            byte[] data = packet.getData();
            String receiveData = new String(data,0,packet.getLength());
            System.out.println(receiveData);
            if (receiveData.equals("bye")) {
                break;
            }
        }
        // 关闭socket
        socket.close();
    }
}
