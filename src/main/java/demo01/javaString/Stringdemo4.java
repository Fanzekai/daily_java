package demo01.javaString;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/18  15:33
 */

// 演示String的相关方法，索引从0开始
public class Stringdemo4 {


    public static void main(String[] args) {


        String str1 = "Hello, World!";
        String subStr1 = str1.substring(7);  // 从索引7开始截取
        System.out.println(subStr1);


        String str2 = "Hello, World!";
        String subStr2 = str2.substring(7, 12);  // 从索引7开始，到索引12（不包括12）
        System.out.println(subStr2);  // 输出: "World"


        String str3 = "apple,banana,orange";
        String[] fruits3 = str3.split(",");  // 使用逗号作为分隔符
        for (String fruit : fruits3) {
            System.out.println(fruit);
        }

        String str4 = "apple,banana,orange";
        String[] fruits4 = str4.split(",", 2);  // 使用逗号作为分隔符，限制分割为2部分
        for (String fruit : fruits4) {
            System.out.println(fruit);
        }

        String str5 = "Hello, World!";
        char ch = str5.charAt(7);  // 获取索引7处的字符
        System.out.println(ch);  // 输出: 'W'


        String str6 = "Hello, World!";
        int index6 = str6.indexOf("World");  // 获取子字符串 "World" 的起始索引
        System.out.println(index6);  // 输出: 7

        String str = "Hello, World!";
        String lowerStr = str.toLowerCase();
        String upperStr = str.toUpperCase();
        System.out.println(lowerStr);  // 输出: "hello, world!"
        System.out.println(upperStr);  // 输出: "HELLO, WORLD!"
    }
}
