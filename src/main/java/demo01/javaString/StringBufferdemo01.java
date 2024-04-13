package demo01.javaString;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  10:53
 */
public class StringBufferdemo01 {


        public String toString() {//重写Object类中toString()方法
            return getClass().getName();
        }

    public static void main(String[] args) {


        Logger log = LoggerFactory.getLogger(StringBufferdemo01.class);

        StringBuffer s1=new StringBuffer("abcd1234!?,;");
        StringBuffer s2=new StringBuffer("987654321987654");
        StringBuffer s3=new StringBuffer("987654321");

        log.info("↓↓↓StringBuffer类的一些常用方法如下↓↓↓");
        log.info("-----------------------------------------------------");
        log.info("字符串s1的长度为：" + s1.length());//返回字符串的实际长度
        log.info("-----------------------------------------------------");
        log.info("字符串s1所占容器的大小为：" + s1.capacity());//返回字符串所占容器的总大小
        log.info("-----------------------------------------------------");
        log.info("获取字符串s1中第2个位置的字符：" + s1.charAt(2));
        log.info("-----------------------------------------------------");
        log.info("子字符串'654'第一次出现在字符串s2中的索引为：" + s2.indexOf("654"));
        log.info("从指定的索引6开始搜索，返回子字符串'654'第一次出现在字符串s2中的索引：" + s2.indexOf("654",6));
        log.info("-----------------------------------------------------");
        log.info("子字符串'987'最后一次出现在字符串s2中的索引为：" + s2.lastIndexOf("987"));
        log.info("从指定的索引5开始反向搜索，返回字符串'87'在字符串s2中最后一次出现的索引：" + s2.lastIndexOf("87",5));
        log.info("-----------------------------------------------------");
        s1.append('x');//在字符串s1的末尾添加字符'c'
        s1.append("Java");//在字符串s1的末尾添加字符串"Java"
        log.info("修改后的字符串s1为：" + s1);
        log.info("-----------------------------------------------------");
        s1.insert(4,"abcd");//在第4个位置插入字符串"abcd"
        log.info("修改后的字符串s1为：" + s1);
        log.info("-----------------------------------------------------");
        s1.deleteCharAt(1);//删除字符串s1中第一个位置的字符
        s1.delete(2,5);//删除字符串s1中第2到第4个位置的字符
        log.info("修改后的字符串s1为：" + s1);
        log.info("-----------------------------------------------------");
        s1.replace(4,8,"5678");//将字符串s1中第4到第7个位置的字符串修改为"5678"
        log.info("修改后的字符串s1为：" + s1);
        log.info("-----------------------------------------------------");
        s1.setCharAt(1,'b');//将字符串s1中第一个位置的字符修改为'b'
        log.info("修改后的字符串s1为：" + s1);
        log.info("-----------------------------------------------------");
        s2.reverse();//将字符串s2反转
        log.info("修改后的字符串s2为：" + s2);
        log.info("-----------------------------------------------------");
        log.info("截取字符串s1从第4个位置开始到结尾：" + s1.substring(4));
        log.info("-----------------------------------------------------");
        log.info("截取字符串s1从第4个位置开始到第7个位置结尾：" + s1.substring(4,8));
        log.info("-----------------------------------------------------");
        log.info("获取s1的变量类型：" + s1.getClass().getName());
        log.info("将对象信息转化为字符串：" + s2.toString());
    }



}

