package demo01.javaString;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  11:17
 */
public class Stringdemo2 {

    public static void main(String[] args) {

        //通过字面量的方法:此时的s1和s2是声明在方法区中的字符串常量池中，保存在字符串常量池中，栈中存放形参变量
        String s1 = "JavaEE";
        String s2 = "JavaEE";

        //通过new + 构造器的方法: 字符串在堆空间中开辟空间后，此时的s3和s4保存的是地址值，即保存在堆空间中
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");

        System.out.println(s1.equals(s2));   //输出 true，比较的是本身值的大小
        System.out.println(s3.equals(s4));   //输出 true，比较的是本身值的大小
        System.out.println(s3 == s4);        //输出 false，比较的是地址值

    }
}
