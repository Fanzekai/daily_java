package demo02.kuangshen.threadJUC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  17:01
 */
public class CASDemo {

    //CAS : compareAndSet 比较并交换
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

        //boolean compareAndSet(int expect, int update)
        //期望值、更新值
        //如果实际值 和 我的期望值相同，那么就更新
        //如果实际值 和 我的期望值不同，那么就不更新
        //参数：
        // 1.当前对象实例。
        //2.成员变量 state 在内存地址中的偏移量(内存中的实际值)。
        //3.预期值 0。
        //4.期望更改后的值 1。
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());


        //CAS 是CPU的并发原语
        atomicInteger.getAndIncrement(); //++操作

        //因为期望值是2020  实际值却变成了2021  所以会修改失败
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
    }
}
