package demo02.kuangshen.threadJUC;

import java.util.concurrent.*;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  10:29
 */
public class test {



        public static void main(String[] args) {

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));
            new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));



            //获取cpu的核数
            //cpu密集型，io密集型
            System.out.println(Runtime.getRuntime().availableProcessors());
        }


    }
