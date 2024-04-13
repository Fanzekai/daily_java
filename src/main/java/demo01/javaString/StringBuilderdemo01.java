package demo01.javaString;



import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  10:41
 */
@Slf4j
public class StringBuilderdemo01 {


    public static void main(String[] args) {


        Logger logger = LoggerFactory.getLogger(StringBuilderdemo01.class);

        StringBuilder sb1 = new StringBuilder();
        sb1.append(8).append("乘以").append(6.6).append('=').append(true);
        sb1.append(new StringBuilder("!!!"));
        System.out.println(sb1); // 输出结果为：8乘以6.6=true!!!


        StringBuilder sb2= new StringBuilder("猪头大一来过上海");
        sb2.reverse();
        System.out.println(sb2); // 输出结果为：海上过来一大头猪



        StringBuilder sb3 = new StringBuilder("春眠不觉晓，处处闻啼鸟。");
        sb3.replace(8, 11, "蚊子咬");
        System.out.println(sb3); // 输出结果为：春眠不觉晓，处处蚊子咬。


        StringBuilder sb4 = new StringBuilder("爸爸的脸蛋有很多褶皱");
        sb4.delete(3, 4);
        System.out.println(sb4); // 输出结果为：爸爸的蛋有很多褶皱


        StringBuilder sb5 = new StringBuilder("《摔跤吧！爸爸》");
        sb5.insert(3, "了");
        System.out.println(sb5); // 输出结果为：《摔跤了吧！爸爸》



        StringBuilder sb6 = new StringBuilder(6);
        sb6.append("执子之手，方知子丑。");
        System.out.println(sb6.capacity()); // 转出结果为：26
        System.out.println(sb6.length()); // 转出结果为：10


        // 链式创建
        StringBuilder sb7 = new StringBuilder("Hello").append("World").append("Java");
        // 调用方法
        String str = sb7.toString();
        System.out.println(str); // HelloWorldJava


        logger.info("==========================");

        //创建对象
        StringBuilder builder = new StringBuilder();
        //public StringBuilder append(任意类型)
        StringBuilder builder2 = builder.append("hello");
        //对比一下
        System.out.println("builder:"+builder);//builder:hello
        System.out.println("builder2:"+builder2);//builder2:hello
        System.out.println(builder == builder2); //true
        // 可以添加 任何类型
        builder.append("hello");
        builder.append("world");
        builder.append(true);
        builder.append(100);
        // 在我们开发中，会遇到调用一个方法后，返回一个对象的情况，然后使用返回的对象继续调用方法。
        // 这种时候，我们就可以把代码现在一起，如append方法一样，代码如下：
        //链式编程
        builder.append("hello").append("world").append(true).append(100);
        System.out.println("builder:"+builder);
        //builder:hellohelloworldtrue100helloworldtrue100
    }

    }



