package lineWell.demo02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/10/13  17:21
 */
public class test {



    public static void main(String[] args) {

        String filePath = "归档登记表.docx";  // 输出文件路径

        //InputStream templateStream = WordTemplateFiller.class.getClassLoader().getResourceAsStream("templateFileName/归档登记表.docx");


        // 准备填充数据
        Map<String, String> data = new HashMap<>();
        data.put("{workname}", "某某公司");
        data.put("{time}", "2024年10月12日");
        data.put("{check}", "通过");
        data.put("{onlineCheck}", "☑");  // 勾选在线归档
        data.put("{offlineCheck}", "☐"); // 离线归档不打勾
        // 可以继续添加更多键值对

        try {
            String path = WordTemplateFiller.fillWordTemplate( filePath, data);
            System.out.println("文档填充完成，生成文件：" + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
