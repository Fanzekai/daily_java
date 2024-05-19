package demo02.ThreeMethods.CallableDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/18  21:37
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("***子线程执行***");
        //执行线程处理方法
        int sun = 0;
        for (int i = 0; i < 5; i++) {
            sun+=i;
        }
        return sun;
    }

    public static void main(String[] args) {
        //主线程执行
        System.out.println("---主线程执行---");

        //创建子线程，不可以自己单独启动，必须借助FutureTask才可以，必须获取子线程执行结果
        MyCallable callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);

        //启动线程，只能借助Thread类
        Thread thread = new Thread(futureTask);
        thread.start();

        //获取子线程的执行结果(必须要子线程执行结束，才可以获取结果)
        try {
            Integer resultSun = futureTask.get(); //接收返回值
            System.out.println("五以内的数字之和："+resultSun);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---主线程结束---");

    }
}
