package lineWell.demo07;

import com.alibaba.fastjson.JSONObject;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class JsonToXmlWithFile {

    /**
     * 根据 JSON 和模型生成根元素
     *
     * @param json  压缩的 JSON 数据
     * @param model 映射模型
     * @return XML 根元素
     */
    public static Element generateXmlElement(String json, Map<String, String> model) {
        // 将压缩 JSON 字符串解析为 JSONObject
        JSONObject jsonObject = JSONObject.parseObject(json);

        // 创建根元素 writ
        Element root = new Element("writ");
        root.setAttribute("sect_code", jsonObject.getString("sectCode"));
        root.setAttribute("user_id", jsonObject.getString("userId"));

        // 遍历 JSONObject 数据生成 XML 的子元素
        for (String key : jsonObject.keySet()) {
            String value = jsonObject.getString(key);

            // 创建 <element> 元素
            Element element = new Element("element");
            element.setText(value);

            // 如果在 model 中存在映射，为 name 属性赋值
            if (model.containsKey(key)) {
                element.setAttribute("name", model.get(key));
            }

            // 添加到根元素
            root.addContent(element);
        }
        return root;
    }

    /**
     * XML生成文件
     *
     * @param element  根元素
     * @param filePath 文件路径
     * @return 是否生成成功
     */
    public static boolean xmlToFile(Element element, String filePath) {
        File file = new File(filePath);
        Document document = new Document(element);
        XMLOutputter xmlOut = new XMLOutputter();
        Format format = Format.getPrettyFormat();
        format.setExpandEmptyElements(true);
        xmlOut.setFormat(format);

        try (FileOutputStream filefos = new FileOutputStream(file)) {
            xmlOut.output(document, filefos);
        } catch (IOException e) {
            throw new RuntimeException("生成XML文件失败", e);
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        // 示例压缩 JSON 数据
        String json = "{\"sectCode\":\"全宗号\",\"userId\":\"警号或者登录账户\",\"writOldId\":\"原系统记录id\",\"writYwlb\":\"专业类别\",\"writName\":\"题名\",\"writYear\":\"年度\",\"writDuty\":\"责任者\",\"writKeepTime\":\"保管期限\",\"writPageNum\":\"页数(默认值为 1)\",\"writCopyNum\":\"份数(默认值为 1)\",\"writDoneDate\":\"文件日期\",\"writLevel\":\"密级\",\"writCode\":\"文号\",\"writXm\":\"姓名\",\"writSfzh\":\"身份证号\",\"writBdxm\":\"变动项目\",\"writBdyy\":\"变动原因\",\"writZzd\":\"暂住地\",\"writYjs\":\"原籍派出所\",\"writHjd\":\"户籍所在地\",\"writSpjg\":\"审批机构\",\"writThry\":\"同户人员\",\"writCmzh\":\"船民证号\",\"writCzbh\":\"船只编号\"}";

        // 示例模型数据
        Map<String, String> model = null;

        // 生成 XML 根元素
        Element rootElement = generateXmlElement(json, model);

        // 写入文件
        String filePath = "output.xml";
        boolean result = xmlToFile(rootElement, filePath);

        System.out.println("XML 文件生成成功: " + result + "，路径：" + filePath);
    }
}
