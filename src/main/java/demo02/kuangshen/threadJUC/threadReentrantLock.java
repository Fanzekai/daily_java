package demo02.kuangshen.threadJUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  10:34
 */
public class threadReentrantLock {




    public static void main(String[] args) {
        Data2 data2 = new Data2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data2.increment();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data2.increment();
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data2.decrement();
            }
        },"B").start();
    }
}
class Data2{//数字 资源类
    private int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    //    condition.await()等待 condition.signalAll()唤醒全部
    public void increment()  {
        lock.lock();
        try {
            //业务代码
            while (num != 0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+">="+num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            //业务代码
            while (num == 0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+">="+num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
