package lineWell.demo07;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author czn
 * @version 1.0
 * @date 2024/12/12  14:12
 */
public class test {

    public static void main(String[] args) {

        String path="D:\\workspace\\IDEA\\Git\\大杂烩\\java\\src\\main\\resources\\json\\output.xml";
        File file = new File(path);
        //element.getChildren("element").forEach(e -> {
        //    System.out.println(e.getAttributeValue("name")+"="+e.getTextTrim());
        //}
        //);
        JSONObject jsonObject = parseWritXmlToJson(file);
        System.out.println(jsonObject);
    }

    private static Element parseRootElement(File file, String rootTagName) {
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document document = saxBuilder.build(file);
            Element rootElement = document.getRootElement();
            if (!rootTagName.equals(rootElement.getName())) {
                return null;
            }
            return rootElement;
        } catch (JDOMException | IOException e) {
            throw new RuntimeException("解析XML文件失败", e);
        }

    }



    public static JSONObject parseWritXmlToJson(File file) {
        // 解析 <writ> 节点
        Element rootElement = parseRootElement(file, "writ");

        if (rootElement == null) {
            throw new RuntimeException("未找到根节点 <writ>");
        }
        // 提取 <writ> 节点的属性
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sect_code", rootElement.getAttributeValue("sect_code"));
        jsonObject.put("user_id", rootElement.getAttributeValue("user_id"));

        // 校验并解析 <element> 子节点
        List<Element> elementList = rootElement.getChildren("element");
        elementList.forEach(element -> {
            System.out.println(element.getAttributeValue("name"));
        });
        //ParseXmlException xmlException = new ParseXmlException("XML元素在模型中未配置");
        for (Element element : elementList) {
            String name = element.getAttributeValue("name");
            String value = element.getTextTrim();

            // 检查模型映射
            //Metadata model = models.get(name);
            //if (ObjectUtil.isEmpty(model)) {
            //    xmlException.addParam(name);
            //    continue;
            //}
            // 根据模型配置处理数据
            jsonObject.put(name,value);
        }

        //if (!xmlException.isEmpty()) {
        //    throw xmlException;
        //}
        return jsonObject;
    }

}
