package demo04.kuangshen;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/24  23:24
 */


import java.net.InetAddress;
import java.net.InetSocketAddress;

/*
测试port
 */
public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("localhost",8080);
        System.out.println(inetSocketAddress);
        System.out.println(inetSocketAddress1);

        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getHostName());//返回地址
        System.out.println(inetSocketAddress.getHostString());
        System.out.println(inetSocketAddress.getPort());//返回端口号

    }
}

