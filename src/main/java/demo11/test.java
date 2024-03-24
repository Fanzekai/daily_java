package demo11;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/23  15:35
 */
public class test {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("hello world");

        Class<test> testClass = test.class;

        System.out.println(testClass);
        System.out.println(testClass.getDeclaredFields());
        System.out.println(testClass.getName());
        System.out.println(testClass.getMethod("main", String[].class));
        for (Field declaredField : testClass.getDeclaredFields()) {
            System.out.println(declaredField);

        }

        Class<?> aClass = Class.forName("java.lang.String");
        //System.out.println(aClass.getConstructor());
        //for (Field declaredField : aClass.getDeclaredFields()) {
        //    System.out.println(declaredField);
        //}
        for (Method method : aClass.getMethods()) {
            System.out.println(method);
        }

        Object o = aClass.newInstance();
        System.out.println(o.toString());


    }
}
