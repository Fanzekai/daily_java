package lineWell.demo07;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/12/11  17:10
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonToXmlConverter01 {

    public static void main(String[] args) {
        // 定义 JSON 文件路径（根据实际情况修改）
        String jsonFilePath = "D:\\workspace\\IDEA\\Git\\大杂烩\\java\\src\\main\\resources\\json\\在线归档参数.json";
        // 定义输出 XML 文件路径
        String xmlFilePath = "D:\\workspace\\IDEA\\Git\\大杂烩\\java\\src\\main\\resources\\json\\output.xml";

        try {
            // 读取 JSON 数据
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new File(jsonFilePath);
            JsonNode rootNode = objectMapper.readTree(jsonFile);

            // 转换为 XML
            String xmlContent = convertJsonToXml(rootNode);
            // 将 XML 内容写入文件
            writeToFile(xmlContent, xmlFilePath);

            System.out.println("XML 文件已成功生成：" + xmlFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将 JSON 数据转换为指定格式的 XML 字符串
     *
     * @param rootNode JSON 根节点
     * @return XML 字符串
     */
    private static String convertJsonToXml(JsonNode rootNode) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

        // 开始构建 <writ> 节点，包含 sectCode 和 userId 作为属性
        xmlBuilder.append("<writ ")
                .append("sect_code=\"").append(rootNode.get("sectCode").asText()).append("\" ")
                .append("user_id=\"").append(rootNode.get("userId").asText()).append("\">\n");

        // 遍历 JSON 中的其他字段，生成 <element> 节点
        rootNode.fields().forEachRemaining(field -> {
            String fieldName = field.getKey();
            String fieldValue = field.getValue().asText();
            if (!"sectCode".equals(fieldName) && !"userId".equals(fieldName)) { // 过滤掉作为属性的字段


                xmlBuilder.append("    <element name=\"").append(fieldName).append("\">")
                        .append(fieldValue)
                        .append("</element>\n");
            }
        });

        // 结束 <writ> 节点
        xmlBuilder.append("</writ>");
        return xmlBuilder.toString();
    }

    /**
     * 将字符串内容写入文件
     *
     * @param content 内容字符串
     * @param filePath 文件路径
     */
    private static void writeToFile(String content, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(content);
        } catch (IOException e) {
            System.err.println("写入文件时发生错误：" + e.getMessage());
        }
    }
}
