package lineWell.demo01;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/9/12  15:25
 */


public class JSONValidator {



    private static final String formaterror = "政务事项扩展信息格式错误";
    private static final String valueerror = "政务事项扩展信息值不能为空";
    public static void main(String[] args) {


        // JSON 文件路径
        String filePath = "D:\\workspace\\IDEA\\Git\\大杂烩\\java\\data.json";
        // 读取文件内容
        String jsonString = readJsonFile(filePath);

        // 尝试解析为 JSONObject
        JSONObject jsonObject = JSONObject.parseObject(jsonString);

        StringBuilder errorKey = new StringBuilder();

        boolean isValid = validateJson(jsonObject, errorKey);
        if (isValid) {
            System.out.println("JSON 格式正确！");
        } else {
            System.err.println("JSON 格式错误，错误的 key: " + errorKey.toString());
        }
    }



    // 第一步：检测最外层是否为对象，并且每个值为对象
    public static boolean  validateJson(JSONObject jsonObject,StringBuilder  errorKey) {
        if (jsonObject == null || jsonObject.isEmpty()) {
            errorKey.append(formaterror);
            return false;
        }

        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            Object value = entry.getValue();
            if (!(value instanceof JSONObject)) {
                errorKey.append(formaterror);
                return false;
            }
            if (!validateObject((JSONObject) value, errorKey)){
                return false;
            }
        }
        return true;
    }

    // 第二步：检测对象层级，确保每个键的值为对象或字符串类型
    private static boolean  validateObject(JSONObject jsonObject,StringBuilder  errorKey) {
        if (jsonObject == null || jsonObject.isEmpty()) {
            errorKey.append(formaterror);
            return false;
        }

        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof JSONObject) {
                if (!validateNestedObject((JSONObject) value, errorKey)) {
               return false;
            }}
            else if (value instanceof String) {
                // 值为字符串，格式正确
                if (((String) value).isEmpty()) {
                    errorKey.append(valueerror);
                    return false;
                }
            }else {
                errorKey.append(formaterror);
                return false;
            }
        }
        return true;
    }

    // 第三步：递归检测嵌套对象
    private static boolean  validateNestedObject(JSONObject jsonObject,StringBuilder errorKey) {

        if (jsonObject == null || jsonObject.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            Object value = entry.getValue();
            if (!(value instanceof JSONObject)) {
                errorKey.append(formaterror);
                return false;
            }
            if(!validateString((JSONObject) value, errorKey)){
                return false;
            }
        }
        return true;
    }


    // 第四步：检测嵌套对象内字符串
    private static boolean  validateString(JSONObject jsonObject,StringBuilder errorKey) {

        if (jsonObject == null || jsonObject.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            Object value = entry.getValue();
            if (!(value instanceof String)) {
                errorKey.append(formaterror);
                return false;
            }
            if (((String) value).isEmpty()) {
                errorKey.append(valueerror);
                return false;
            }
        }
        return true;
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
