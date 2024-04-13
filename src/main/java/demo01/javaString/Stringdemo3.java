package demo01.javaString;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  11:17
 */
public class Stringdemo3 {


    public static void main(String[] args) {


        test1();
        test2();
        test3();

    }


    public  static void test1() {
        String s1 = "   Hello,   World!   ";
        System.out.println("字符串的长度是：" + s1.length());   //输出 21
        System.out.println("字符串中第四个字符是：" + s1.charAt(4));  //输出 e
        System.out.println("字符串是否为空？" + s1.isEmpty());  //输出 false
        System.out.println("将字符串中所有大写字母转换为小写为：" + s1.toLowerCase());
        System.out.println("将字符串中所有小写字母转换为大写为：" + s1.toUpperCase());
        System.out.println("返回删去字符串中前后空格后新的字符串：" + s1.trim());//中间空格不会消失
    }


    public static void test2() {
        String s2 = "helloWorld";
        String s3 = "HelloWorlD";
        System.out.println(s2.equals(s3));   //输出 false
        System.out.println(s2.equalsIgnoreCase(s3));   //输出 true，忽略大小写

        String s4="abc";
        String s5=s4.concat("def");    //字符串的拼接,
        System.out.println(s5);  //输出 abcdef
    }


    public static void test3() {
        String s1 = "helloWorld";
        System.out.println(s1.substring(5));   //输出 World 从第5个索引开始截取字符串，直到末尾
        System.out.println(s1.substring(1,6)); //输出 elloW
        /*字符串的第一个字母的索引是从 0 开始*/
    }



}
