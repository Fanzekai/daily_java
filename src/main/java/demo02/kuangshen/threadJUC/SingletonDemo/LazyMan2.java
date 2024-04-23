package demo02.kuangshen.threadJUC.SingletonDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  16:46
 */
public class LazyMan2 {


    // 懒汉式单例
//理论上，第一个线程释放锁后，其他线程会进入同步块并直接返回已经创建的实例，但是在实际执行过程中，由于Java内存模型的一些特性，可能会出现实例未完全初始化的情况

        //私有化构造器
        private LazyMan2() {
            System.out.println(Thread.currentThread().getName()+">>"+"OK");
        }

        private volatile static LazyMan2 lazyMan;

        // 双重检测锁模式的 懒汉式单例 DCL懒汉式
        public static LazyMan2 getInstance() {

            if (lazyMan == null) {
                synchronized (LazyMan2.class) {
                    //第一个线程进入同步块，开始实例化对象，并进行了部分属性的初始化操作，但尚未完成整个实例对象的初始化。
                    // 此时第二个线程也进入了同步块，并直接返回尚未完全初始化的对象。这样可能会导致第二个线程在使用这个对象时出现问题，
                    // 因为对象的状态还不完整。因此，在双重检测锁中，第二次检查的作用是为了确保实例已经完全初始化。
                    //即使在第一个线程释放锁后，其他线程仍然需要再次检查实例是否已经创建，并确保实例已经完全初始化后才返回。
                    if (lazyMan == null) {
                        lazyMan = new LazyMan2();
                        //1、分配内存空间
                        //2、执行构造方法,初始化对象
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

