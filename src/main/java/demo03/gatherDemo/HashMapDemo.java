package demo03.gatherDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/5  11:16
 */
public class HashMapDemo {

    public static void main(String[] args) {
        // 创建一个HashMap存储学生的姓名和对应的分数
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 75);
        scores.put("Bob", 45);
        scores.put("Charlie", 90);
        scores.put("David", 55);

        // 使用迭代器遍历HashMap并删除分数低于60的学生
        Iterator<Map.Entry<String, Integer>> iterator = scores.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 60) {
                iterator.remove(); // 使用迭代器的remove方法删除元素
            }
        }

        //报错ConcurrentModificationException异常
        //for (String string : scores.keySet()) {
        //    if (scores.get(string)<60) {
        //        scores.remove(string);
        //    }
        //}

        // 打印剩余学生的姓名和分数
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }}
