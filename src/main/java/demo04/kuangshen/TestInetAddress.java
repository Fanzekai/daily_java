package demo04.kuangshen;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/24  23:22
 */


import java.net.InetAddress;
import java.net.UnknownHostException;

/*
测试IP
 */
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //查询本机地址
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress1);
            InetAddress inetAddress3 = InetAddress.getByName("localhost");
            System.out.println(inetAddress3);
            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress4);

            //查询网站地址
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

            //常用方法
            System.out.println(inetAddress2.getAddress());//返回的为一个字节数组，返回此 InetAddress 对象的原始 IP 地址。结果按网络字节顺序：地址的高位字节位于 getAddress()[0] 中。
            System.out.println(inetAddress2.getCanonicalHostName()); //获取此 IP 地址的完全限定域名
            System.out.println(inetAddress2.getHostAddress());//返回 IP 地址字符串（以文本表现形式）。
            System.out.println(inetAddress2.getHostName()); //获取此 IP 地址的主机名。
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}

