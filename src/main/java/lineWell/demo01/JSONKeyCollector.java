package lineWell.demo01;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import java.util.Set;

public class JSONKeyCollector {

    public static void main(String[] args) {


        // JSON 文件路径
        String filePath = "D:\\workspace\\IDEA\\Git\\大杂烩\\java\\接收参数.json";
        // 读取文件内容
        String jsonString = readJsonFile(filePath);


        // 尝试解析为 JSONObject
        Object json = JSONObject.parse(jsonString);

        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        Set<String> keys = new HashSet<>();
        extractKeys(jsonObject, keys);

        keys.forEach(System.out::println);
    }

    private static void extractKeys(JSONObject jsonObject, Set<String> keySet) {
        for (String key : jsonObject.keySet()) {
            keySet.add(key);
            Object value = jsonObject.get(key);
            if (value instanceof JSONObject) {
                // 如果值是一个对象，递归调用
                extractKeys((JSONObject) value, keySet);
            }
        }
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
