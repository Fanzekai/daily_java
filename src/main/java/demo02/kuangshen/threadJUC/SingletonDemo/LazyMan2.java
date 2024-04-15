package demo02.kuangshen.threadJUC.SingletonDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  16:46
 */
public class LazyMan2 {


    // 懒汉式单例
// 道高一尺，魔高一丈！

        //私有化构造器
        private LazyMan2() {
            System.out.println(Thread.currentThread().getName() + "OK");
        }

        private volatile static LazyMan2 lazyMan;

        // 双重检测锁模式的 懒汉式单例 DCL懒汉式
        public static LazyMan2 getInstance() {
            if (lazyMan == null) {
                synchronized (LazyMan2.class) {
                    if (lazyMan == null) {
                        lazyMan = new LazyMan2();
                        //1、分配内存空间
                        //2、执行构造方法,初始化对象本
                        //3、把这个对象指向这个空间
                        //会出现指令重排，可能会出现空指针 123--》132//此时lazyman还没有构造，对象指向的是虚拟空间
                        // 其他线程以为已经构造完成，会判断不为空,这时候需要给lazyhman加上volatile 关键字，禁止指令重排


                    }
                }
            }
            return lazyMan;
        }

        //多线程并发
        public static void main(String[] args) {
            for (int i = 0; i < 10; i++) {
                new Thread(() -> {
                    lazyMan.getInstance();
                }).start();
            }

        }
    }

