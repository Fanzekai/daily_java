package demo01.javaString;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  11:15
 */
public class Stringdemo1 {

    public static void main(String[] args) {



        String s1 = "JavaEE";
        String s2 = "hadoop";


        String s3 = "JavaEEhadoop";
        String s4 = "JavaEE" + "hadoop";   //相当于字面量的连接，在常量池中
        String s5 = s1 + "hadoop";    //有变量 s1 的参与，需要在堆空间中参与

        String s6 = "JavaEE" + s2;    //有变量 s2 的参与，需要在堆空间中参与
        String s7 = s1 + s2;    //有变量的参与，需要在堆空间中参与

        System.out.println("s4 = "+s4+", "+"s5 = "+s5+", "+"s6 = "+s6+", "+"s7 = "+s7);
        System.out.println(s3 == s4);   //输出 true，相当于比较两个字符串的值
        System.out.println(s3 == s5);   //输出 false，比较地址
        System.out.println(s3 == s6);   //输出 false
        System.out.println(s3 == s7);  //输出 false
        System.out.println(s5 == s6);  //输出 false
        System.out.println(s6 == s7);  //输出 false

    }
}
