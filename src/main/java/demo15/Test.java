package demo15;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/25  15:57
 */
public class Test {




    public String text;

    public void test01(){
        String test1 = "This is a test";
        String test2 = "This is a test";
        System.out.println(test1 == test2);
        Test t1 = new Test();
        t1.text = "This is a test";
        Test t2 = new Test();
        t2.text = "This is a test";
        System.out.println(t1 == t2);

        //test1和test2都是String类型的对象，它们的值都是"This is a test"，
        // 由于Java中的字符串常量池特性，相同的字符串常量在内存中只会有一个实例，
        // 因此test1和test2都指向字符串常量池中的同一块地址，所以test1 == test2会返回true
    }

    public static void test02() {

    //    for (int i = 0; i < 3; i++) {
    //        System.out.print(i);
    //    }
    //    System.out.print(i);
    //}
    }


    public static void test03() {

        String s="fzk";

        char c=s.charAt(0);
        System.out.println(c);
    }

    public static void main(String[] arguments) {

        test03();
    }
}
