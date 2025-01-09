package lineWell.demo01;


import com.alibaba.fastjson.JSONObject;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 生成xml文件扩展信息项
 *
 * @author fzk
 * @since 2024-09-30
 */


public class XMLGenerator {


    public static void main(String[] args) throws Exception {

        String filePath = "D:\\workspace\\IDEA\\Git\\大杂烩\\java\\data.json";
        String jsonString = readJsonFile(filePath);

        Object json = JSONObject.parse(jsonString);



        Map metadataMap = getMetadataMap();
        Element kzx = jsonToXml((JSONObject) json, metadataMap, "kzx");

        Document document = new Document(kzx);
        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.setFormat(Format.getPrettyFormat());
        System.out.println(xmlOutputter.outputString(document));


    }

    public static Element jsonToXml(JSONObject rootJson, Map<String, Metadata> model, String rootEleCode) {
        Element rootEle = new Element(rootEleCode);
        processElement(rootEle,rootJson,model);
        return rootEle;
    }

    // 通用递归处理方法，根据类型递归处理 class, autorow, row, item
    private static void processElement(Element parent, Map<String, Object> jsonMap,Map<String, Metadata> model) {
        jsonMap.forEach((key, value) -> {

            String id = model.get(key) != null ? model.get(key).getMetadataCode() : key;
            String title = model.get(key) != null ? model.get(key).getMetadataName() : key;

            if (value instanceof Map) {
                Element classElement = new Element("class"); // 创建 class 元素
                classElement.setAttribute("id", id);
                classElement.setAttribute("item",title);
                parent.addContent(classElement);
                processAutorowOrRow(classElement, (Map<String, Object>) value,model);
            } else {
                Element itemElement = new Element("item"); // 创建 item 元素
                itemElement.setAttribute("id", id);
                itemElement.setAttribute("title", title);
                itemElement.setText(value.toString());
                parent.addContent(itemElement);
            }
        });
    }

    // 处理 autorow 或 row
    private static void processAutorowOrRow(Element parent, Map<String, Object> jsonMap,Map<String, Metadata> model) {
        jsonMap.forEach((key, value) -> {

            String id = model.get(key) != null ? model.get(key).getMetadataCode() : key;
            String title = model.get(key) != null ? model.get(key).getMetadataName() : key;

            if (value instanceof Map) {
                Element autorowElement = new Element("autorow"); // 创建 autorow 元素
                autorowElement.setAttribute("id", id);
                autorowElement.setAttribute("title", title);
                parent.addContent(autorowElement);
                processRowOrItem(autorowElement, (Map<String, Object>) value,model);
            } else {
                Element itemElement = new Element("item"); // 创建 item 元素
                itemElement.setAttribute("id", id);
                itemElement.setAttribute("title", title);
                itemElement.setText(value.toString());
                parent.addContent(itemElement);
            }
        });
    }

    // 处理 row 或 item
    private static void processRowOrItem(Element parent, Map<String, Object> jsonMap,Map<String, Metadata> model) {
        jsonMap.forEach((key, value) -> {

            String id = model.get(key) != null ? model.get(key).getMetadataCode() : key;
            String title = model.get(key) != null ? model.get(key).getMetadataName() : key;

            if (value instanceof Map) {
                Element rowElement = new Element("row"); // 创建 row 元素
                rowElement.setAttribute("id", id);
                rowElement.setAttribute("title", title); // 可自定义 title
                parent.addContent(rowElement);
                processElement(rowElement, (Map<String, Object>) value,model);
            } else {
                Element itemElement = new Element("item"); // 创建 item 元素
                itemElement.setAttribute("id", id);
                itemElement.setAttribute("title", title);
                if (value instanceof Date){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String date = sdf.format((Date) value);
                    itemElement.setText(date);
                }else {
                    itemElement.setText(value.toString());
                }
                parent.addContent(itemElement);
            }
        });
    }

    public static Map<String, Metadata> getMetadataMap(){

        // Metadata map (example data)
        Map<String, Metadata> metadataMap = new HashMap<>();
        metadataMap.put("projectInformationSheet", new Metadata("项目信息表","ProjectInformationSheet","projectInformationSheet"));
        metadataMap.put("projectName", new Metadata("项目名称","ProjectName","projectName"));
        metadataMap.put("projectCode", new Metadata("项目编码","ProjectCode","projectCode"));
        metadataMap.put("employeeInformation", new Metadata("员工信息","EmployeeInformation","employeeInformation"));
        metadataMap.put("projectDepartment", new Metadata("项目部","ProjectDepartment","projectDepartment"));
        metadataMap.put("name", new Metadata("姓名","Name","name"));
        metadataMap.put("role", new Metadata("职位","Role","role"));
        metadataMap.put("enterpriseQualification", new Metadata("企业资质","EnterpriseQualification","enterpriseQualification"));
        metadataMap.put("constructionQualifications", new Metadata("施工资质","ConstructionQualifications","constructionQualifications"));
        metadataMap.put("designQualifications", new Metadata("设计资质","DesignQualifications","designQualifications"));
        metadataMap.put("consultingQualifications", new Metadata("咨询资质","ConsultingQualifications","consultingQualifications"));

        return metadataMap;

    }

    // 读取 JSON 文件的内容并返回为字符串
    public static String readJsonFile(String filePath) {
        StringBuilder jsonContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonContent.toString();
    }

}


class Metadata {
    private String metadataName;

    private String metadatacode;

    private String metadataparam;

    public Metadata(String metadataName, String metadatacode, String metadataparam) {
        this.metadataName = metadataName;
        this.metadatacode = metadatacode;
        this.metadataparam = metadataparam;
    }

    public String getMetadataparam() {
        return metadataparam;
    }

    public void setMetadataparam(String metadataparam) {
        this.metadataparam = metadataparam;
    }



    public String getMetadataCode() {
        return metadatacode;
    }

    public void setMetadataCode(String metadatacode) {
        this.metadatacode = metadatacode;
    }

    public String getMetadataName() {
        return metadataName;
    }

    public void setMetadataName(String metadataName) {
        this.metadataName = metadataName;
    }
}
