package demo02.kuangshen.list;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/6  14:40
 */
public class SetTest {
    public static void main(String[] args) {
        /**
         * 1. Set<String> set = Collections.synchronizedSet(new HashSet<>());
         * 2. Set<String> set = new CopyOnWriteArraySet<>();
         */
//        Set<String> set = new HashSet<>();
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,5));//从索引 0 开始到索引 5（不包括索引 5）的子字符串
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
