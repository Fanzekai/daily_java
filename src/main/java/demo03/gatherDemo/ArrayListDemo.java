package demo03.gatherDemo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/3  10:45
 */
/*
* ArrayList：实际上是创建了一个默认大小为10的数组
* 每次扩容会创建一个原容量的 1.5 倍大小的新数组
* */
public class ArrayListDemo {


        public static void main(String[] args) {
            // 创建 ArrayList 对象
            ArrayList<String> list = new ArrayList<>();

            // 向列表尾部添加元素
            list.add("apple");

            // 在指定位置插入元素
            list.add(1, "banana");

            // 获取指定位置的元素
            String fruit = list.get(0);
            System.out.println("First element: " + fruit);

            // 替换指定位置的元素
            list.set(1, "orange");

            // 移除指定位置的元素
            list.remove(0);

            // 移除指定的元素
            list.remove("banana");

            // 返回列表的大小
            int size = list.size();
            System.out.println("Size: " + size);

            // 判断列表是否为空
            boolean empty = list.isEmpty();
            System.out.println("Is empty: " + empty);

            // 判断列表是否包含指定元素
            boolean contains = list.contains("apple");
            System.out.println("Contains 'apple': " + contains);

            // 返回指定元素在列表中首次出现的位置
            int index = list.indexOf("orange");
            System.out.println("Index of 'orange': " + index);

            // 清空列表中的所有元素
       //     list.clear();

            // 将列表ArrayList<>()转换为数组[x]
            Object[] array = list.toArray();
            System.out.println(array[0]);


            list.add("apple");
            list.add("banana");
            list.add("orange");

            // 使用迭代器遍历 ArrayList
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String element = iterator.next();
                System.out.println(element);
            }
        }
        }

