package demo03.gatherDemo;

import java.util.HashMap;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/3  18:39
 */
public class MapDemo {

    public static void main(String[] args) {
        // 创建 HashMap 对象
        HashMap<String, Integer> map = new HashMap<>();

        // 将键值对存储到 HashMap 中
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        // 根据键获取对应的值
        Integer value = map.get("apple");
        System.out.println("Value for 'apple': " + value);

        // 判断 HashMap 是否包含指定的键
        boolean containsKey = map.containsKey("banana");
        System.out.println("Contains key 'banana': " + containsKey);

        // 判断 HashMap 是否包含指定的值
        boolean containsValue = map.containsValue(20);
        System.out.println("Contains value 20: " + containsValue);

        // 移除 HashMap 中指定键对应的键值对
        map.remove("apple");

        // 返回 HashMap 中键值对的数量
        int size = map.size();
        System.out.println("Size of map: " + size);

        // 判断 HashMap 是否为空
        boolean isEmpty = map.isEmpty();
        System.out.println("Is map empty: " + isEmpty);

        // 清空 HashMap 中的所有键值对
        map.clear();
    }
}
