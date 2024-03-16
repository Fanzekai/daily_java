package demo09;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/16  19:02
 */
interface Genericsinterface<T> {
    void add(T item);  // 向容器中添加元素
    T get();           // 从容器中获取元素
}

// 实现泛型接口的类
class Box<T> implements Genericsinterface<T> {
    private T item;

    @Override
    public void add(T item) {
        this.item = item;
    }

    @Override
    public T get() {
        return item;
    }
}

//public class Main {
//    public static void main(String[] args) {
//        // 创建一个整数类型的容器
//        Genericsinterface<Integer> integerBox = new Box<>();
//
//        // 向容器中添加整数
//        integerBox.add(123);
//
//        // 从容器中获取整数
//        int value = integerBox.get();
//        System.out.println("Value: " + value);
//
//        // 创建一个字符串类型的容器
//        Genericsinterface<String> stringBox = new Box<>();
//
//        // 向容器中添加字符串
//        stringBox.add("Hello, world!");
//
//        // 从容器中获取字符串
//        String message = stringBox.get();
//        System.out.println("Message: " + message);
//    }
//
//}
