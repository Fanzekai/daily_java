package demo11;

import java.util.Scanner;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/23  12:37
 */
public class hasNextInt {



        public static void main(String[] args) {
            //Scanner in = new Scanner(System.in);
            //// 注意 hasNext 和 hasNextLine 的区别
            //boolean b1 = in.hasNextLine();
            ////System.out.println(b1);
            //if (b1) { // 注意 while 处理多个 case
            //    int a = in.nextInt();
            //    int b = in.nextInt();
            //    System.out.println(a + b);
            //}



            Scanner in1 = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in1.hasNextInt()) { // 注意 while 处理多个 case
                int a = in1.nextInt();
                int b = in1.nextInt();
                System.out.println(a + b);
            }
        }
    }

