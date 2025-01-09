package lineWell.demo01;


import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 *
 * 扩展信息请求参数格式校验
 * @author fzk
 * @version 1.0
 * @date 2024/9/12  17:07
 */

public class JSONValidators {

    public static void main(String[] args) {

        // JSON 文件路径
        String filePath = "D:\\workspace\\IDEA\\Git\\大杂烩\\java\\data.json";
        // 读取文件内容
        String jsonString = readJsonFile(filePath);

        // 尝试解析为 JSONObject
        JSONObject jsonObject = JSONObject.parseObject(jsonString);

        try {
            validateJson(jsonObject);
            System.out.println("JSON 格式正确！");
        } catch (IllegalArgumentException e) {
            System.err.println("JSON 格式错误: " + e.getMessage());
        }
    }

    // 第一步：检测最外层是否为对象，并且每个值为对象
    public static void validateJson(JSONObject jsonObject) {
        if (jsonObject == null || jsonObject.isEmpty()) {
            throw new IllegalArgumentException("政务事项扩展信息格式错误");
        }

        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            Object value = entry.getValue();
            if (!(value instanceof JSONObject)) {
                throw new IllegalArgumentException("最外层每个键的值必须是对象类型: " + entry.getKey());
            }
            validateObject((JSONObject) value);
        }
    }

    // 第二步：检测对象层级，确保每个键的值为对象或字符串类型
    private static void validateObject(JSONObject jsonObject) {
        if (jsonObject == null || jsonObject.isEmpty()) {
            throw new IllegalArgumentException("政务事项扩展信息格式错误");
        }

        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof JSONObject) {
                // 递归检测对象
                validateNestedObject((JSONObject) value);
            }
            else if (value instanceof String) {
                // 值为字符串，格式正确
                if (((String) value).isEmpty()) {
                    throw new IllegalArgumentException("字符串值不能为空: " + entry.getKey());
                }
            }
            else {
                throw new IllegalArgumentException("政务事项扩展信息格式错误: " + entry.getKey());

            }
        }
    }

    // 第三步：递归检测嵌套对象
    private static void validateNestedObject(JSONObject jsonObject) {
        if (jsonObject == null || jsonObject.isEmpty()) {
            throw new IllegalArgumentException("嵌套对象的键值对不能为空");
        }

        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            Object value = entry.getValue();
            if (!(value instanceof JSONObject)) {
                throw new IllegalArgumentException("政务事项扩展信息格式错误: " + entry.getKey());
            }
            else {
                validateString((JSONObject) value);
            }
        }
    }


    // 第四步：检测嵌套对象内字符串
    private static void  validateString(JSONObject jsonObject) {

        if (jsonObject == null || jsonObject.isEmpty()) {
            throw new IllegalArgumentException("政务事项扩展信息格式错误: " );

        }
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            Object value = entry.getValue();

            if(value instanceof String) {
                if (((String) value).isEmpty()) {
                    throw new IllegalArgumentException("字符串值不能为空: "+ entry.getKey());

                }
            }
            else {
                throw new IllegalArgumentException("政务事项扩展信息格式错误: " );

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
