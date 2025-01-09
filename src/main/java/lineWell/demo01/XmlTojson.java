package lineWell.demo01;

import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 元数据缺项检测
 * 解析xml文件内容
 *
 * @author fzk
 * @since 2024-09-30
 */

public class XmlTojson {



    /**
     * 电子文件解析
     * 获取xml文件元数据
     */
    public static Map<String, List<String>> getMetaDataFromXml(File xmlFile) {

        Map<String, List<String>> metaDataMap = new HashMap<>();
        List<String> lists = new ArrayList<>();

        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            org.jdom2.Document document = saxBuilder.build(xmlFile);

            // 获取根元素 <kzx>
            Element rootElement = document.getRootElement();
            List<Element> childElements = new ArrayList<>();
            findDescriptions(rootElement, childElements);

            // 遍历所有子元素
            for (Element description : childElements) {
                String name = description.getName();
                String title = description.getAttributeValue("title");

                // 判断是否为 <kzx> 标签
                if ("kzx".equals(name)) {
                    // 处理 <kzx> 标签的逻辑
                    metaDataMap.put("extend",new ArrayList<>());
                    prasekzx(description, metaDataMap.get("extend"));
                } else {
                    // 根据 title 进行不同信息的处理
                    if (title != null) {
                        switch (title) {
                            case "归档配置信息":
                                metaDataMap.computeIfAbsent("config", k -> new ArrayList<>());
                                prasedescription(description, metaDataMap.get("config"));
                                break;
                            case "办件基本信息":
                                metaDataMap.computeIfAbsent("basic", k -> new ArrayList<>());
                                prasedescription(description, metaDataMap.get("basic"));
                                break;
                            case "办理流程信息":
                                metaDataMap.computeIfAbsent("flow", k -> new ArrayList<>());
                                prasedescription(description, metaDataMap.get("flow"));
                                break;
                            default:
                                // 处理未匹配的 title
                                break;
                        }
                    }
                }
            }
            // 将 Map 中的所有列表合并到 lists
            metaDataMap.values().forEach(lists::addAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return metaDataMap;
    }

    private static void findDescriptions(Element element, List<Element> descriptions) {
        if ("kzx".equals(element.getName()) || "description".equals(element.getName())) {
            descriptions.add(element);
        }
        // 递归处理子元素
        List<Element> children = element.getChildren();
        for (Element child : children) {
            findDescriptions(child, descriptions);
        }
    }

    private static void prasekzx(Element element, List<String> ids) {
        // 递归遍历子元素
        List<Element> children = element.getChildren();
        for (Element child : children) {
            // 如果子元素有 id 属性，提取 id 并添加到列表
            if (child.getAttribute("id") != null ) {
                ids.add(child.getAttributeValue("id"));
            }
            // 递归处理子元素
            prasekzx(child, ids);
        }
    }


    private static void prasedescription(Element element, List<String> ids) {
        // 递归遍历子元素
        List<Element> children = element.getChildren();
        for (Element child : children) {
            // 如果子元素有 id 属性，提取 id 并添加到列表
            if (child.getAttribute("title") != null) {
                ids.add(child.getName());
            }
            // 递归处理子元素
            prasedescription(child, ids);
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("D:\\workspace\\IDEA\\Git\\大杂烩\\java\\行政审批元数据.xml");

        Map<String, List<String>> metaDataFromXml = getMetaDataFromXml(xmlFile);

        for (Map.Entry<String, List<String>> entry : metaDataFromXml.entrySet()) {
            List<String> distinctList = entry.getValue().stream().distinct().collect(Collectors.toList());
            entry.setValue(distinctList); // 更新去重后的列表
        }

        for (String string : metaDataFromXml.keySet()) {
            if (string.equals("config")){
                List<String> configToRemove = Arrays.asList(
                        "MaterialCatalog", "ArchiveFiles", "FileDirectory", "FileDirectoryName", "ArchiveFileInformation"
                );
                metaDataFromXml.get(string).removeAll(configToRemove);
            }
            if (string.equals("flow")){
                List<String> flowToRemove = Arrays.asList("Process");
                metaDataFromXml.get(string).removeAll(flowToRemove);
            }
            for (int i = 0; i < metaDataFromXml.get(string).size(); i++) {
                System.out.println(metaDataFromXml.get(string).get(i));

            }

        }

        int totalCount = 0;
        for (List<String> value : metaDataFromXml.values()) {
            totalCount += value.size(); // 累加每个 List 的大小
        }
        System.out.println(totalCount);
    }
}
