package lineWell.demo07;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/12/23  10:17
 */
public class pathtest {

    public static void main(String[] args) {


        Long unid=12L;
        String archiveCode="123456";
        String packFormat="ofd";
        String endpoint="http://192.168.206.183:19000";


        // 使用占位符拼接完整的 URL
        String url = String.format(endpoint+"/%s/%d/%s.%s",
                "govservice", unid, archiveCode, packFormat.toLowerCase());
        System.out.println(url);

    }
}
