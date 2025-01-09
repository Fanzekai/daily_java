package lineWell.demo05;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/11/4  18:03
 */
public class fileUrlChange {


    public static String replaceFilePath(String originalFilePath, String newIp, String newPort) {
        // 检查原始路径是否包含IP和端口
        if (originalFilePath.contains("http://") && originalFilePath.contains(":") && originalFilePath.contains("/")) {
            // 找到IP和端口结束的位置
            int ipEndIndex = originalFilePath.indexOf(":");
            int portEndIndex = originalFilePath.indexOf("/", ipEndIndex + 3); // +3 是因为 "http://" 后面紧跟着 IP

            // 构建新的路径
            String newFilePath = "http://" + newIp + ":" + newPort + originalFilePath.substring(portEndIndex);
            return newFilePath;
        } else {
            // 如果原始路径不符合预期格式，返回原始路径
            return originalFilePath;
        }
    }

    public static String transformUrl(String url, String newIp, String newPort, String oldIp, String oldPort) {
        try {
            // 使用 URI 类解析 URL
            java.net.URI uri = new java.net.URI(url);

            // 获取原始的 IP 和端口
            String host = uri.getHost();
            int port = uri.getPort();
            String portStr = port == -1 ? "" : String.valueOf(port); // 如果未指定端口，则默认为空字符串

            // 检查 IP 和端口是否匹配
            if (host.equals(oldIp) && portStr.equals(oldPort)) {
                // 替换为新的 IP 和端口
                String newUrl = url.replace(host, newIp).replace(":" + portStr, ":" + newPort);
                return newUrl;
            } else {
                // 不匹配，返回原始 URL
                return url;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return url; // 出现异常，返回原始 URL
        }
    }

    public static String transformUrls(String url, String newIp, String oldIp) {
        try {
            // 使用 URI 类解析 URL
            java.net.URI uri = new java.net.URI(url);

            // 获取原始的 IP
            String host = uri.getHost();

            // 检查 IP 是否匹配
            if (host.equals(oldIp)) {
                // 替换为新的 IP，保留原始端口
                String newUrl = url.replace(host, newIp);
                return newUrl;
            } else {
                // 不匹配，返回原始 URL
                return url;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return url; // 出现异常，返回原始 URL
        }
    }



    public static void main(String[] args) {

        String originalFilePath="http://141.4.10.15:9000/govservice/10000000101/43510411-ZYZW-2024-D10-001-0018.ofd";
        // 定义新的 IP 和端口
        String newIp = "127.0.0.1";
        String newPort = "8000";
        //String string = replaceFilePath(originalFilePath, newIp, newPort);
        //System.out.println(string);
        String oldIp="141.4.10.15";
        String oldPort = "90001";
        //String string = transformUrl(originalFilePath, newIp, newPort, oldIp, oldPort);
        //System.out.println(string);


        String string1 = transformUrls(originalFilePath, newIp, oldIp);
        System.out.println(string1);
    }
}
