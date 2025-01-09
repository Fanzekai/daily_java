package lineWell.demo01;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * @author fzk
 * @version 1.0
 * @date 2024/9/25  16:21
 */


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * 解析Json串
 *
 * @author fzk
 * @since 2024-09-30
 */

public class getKeyFromJson {

    public static void main(String[] args) throws JSONException, IOException {


        String filePath = "D:\\workspace\\IDEA\\Git\\大杂烩\\java\\接收参数.json";

        // 2. 读取文件内容为字符串
        String jsonStr = new String(Files.readAllBytes(Paths.get(filePath)));

        // 3. 将字符串转换为 JSONObject
        JSONObject jsonObject = new JSONObject(jsonStr);
        extractKeys(jsonObject, "");
    }

    // 递归方法提取 key
    public static void extractKeys(JSONObject jsonObject, String parentKey) throws JSONException {
        Iterator<String> keys = jsonObject.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            String fullKey = parentKey.isEmpty() ? key : parentKey + "." + key;

            Object value = jsonObject.get(key);

            if (value instanceof JSONObject) {
                extractKeys((JSONObject) value, fullKey);  // 递归处理 JSONObject
            } else if (value instanceof JSONArray) {
                extractKeysFromArray((JSONArray) value, fullKey);  // 处理 JSONArray
            } else {
                System.out.println(fullKey);
            }
        }
    }

    // 处理 JSONArray
    public static void extractKeysFromArray(JSONArray array, String parentKey) throws JSONException {
        for (int i = 0; i < array.length(); i++) {
            Object element = array.get(i);
            String newParentKey = parentKey + "[" + i + "]";

            if (element instanceof JSONObject) {
                extractKeys((JSONObject) element, newParentKey);  // 递归处理 JSONArray 里的 JSONObject
            } else if (element instanceof JSONArray) {
                extractKeysFromArray((JSONArray) element, newParentKey);  // 递归处理 JSONArray 里的 JSONArray
            } else {
                System.out.println(newParentKey);
            }
        }
    }
}
