package lineWell.demo06;

import java.net.URI;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/11/14  17:53
 */
public class transformHuaweiObsPathTest {

    public static String transformHuaweiObsPath(String dataPath, String bucketName) {
        try {
            // 使用 URI 解析原始 URL
            URI uri = new URI(dataPath);
            // 在路径前添加桶名
            String newPath = "/" + bucketName + uri.getPath();
            // 构建新的 URI
            URI customizedUri = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), newPath, uri.getQuery(), uri.getFragment());

            return customizedUri.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return dataPath; // 出现异常则返回原始路径
        }
    }

    public static void main(String[] args) {


        String dataPath="http://sdsjzx02.obsv3.hnxc-region-1.int.hw.zwww:80/430001/ceshishixiang0925-2022-D10-00000018/testtt27.pdf";
        String bucketName="sdsjzx02";
        System.out.println(transformHuaweiObsPath(dataPath, bucketName));
    }

}
