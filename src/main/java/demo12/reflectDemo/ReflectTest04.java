package demo12.reflectDemo;

import java.lang.reflect.Field;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/2  17:46
 */
/*
必须掌握：
    怎么通过反射机制访问一个java对象的属性？
        给属性赋值set
        获取属性的值get
 */
class ReflectTest04 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //不使用反射机制给属性赋值
        User student = new User();
        /**给属性赋值三要素：给s对象的no属性赋值1111
         * 要素1：对象s
         * 要素2：no属性
         * 要素3：1111
         */
        student.no = 1111;
        /**读属性值两个要素：获取s对象的no属性的值。
         * 要素1：对象s
         * 要素2：no属性
         */
        System.out.println(student.no);

        //使用反射机制给属性赋值
        Class studentClass = Class.forName("demo12.reflectDemo.User");
        Object obj = studentClass.newInstance();// obj就是Student对象。（底层调用无参数构造方法）

        // 获取no属性（根据属性的名称来获取Field）
        Field noField = studentClass.getDeclaredField("no");
        // 给obj对象(Student对象)的no属性赋值
        /*
            虽然使用了反射机制，但是三要素还是缺一不可：
                要素1：obj对象
                要素2：no属性
                要素3：22222值
            注意：反射机制让代码复杂了，但是为了一个“灵活”，这也是值得的。
         */
        noField.set(obj, 22222);

        // 读取属性的值
        // 两个要素：获取obj对象的no属性的值。
        System.out.println(noField.get(obj));
    }
}
