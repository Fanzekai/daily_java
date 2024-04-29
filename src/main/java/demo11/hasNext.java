package demo11;

import java.util.Scanner;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/23  12:04
 */


public class hasNext {

    public static void main(String[] args) {


        //Scanner scan = new Scanner(System.in);
        //if(scan.hasNext()==false){
        //    System.out.println("hasNext和hasNextLine不会返回false");
        //}


        //一直不停敲回车键，第一次回车会直接输出true，而后面一直敲都会阻塞在hasNext语句上
        //System.out.println(scan.hasNextLine());
        //System.out.println(scan.hasNext());


        //hasNext 和 next组合，next不可以录入空格,读到空格前的内容
        Scanner scan2 = new Scanner(System.in);
        System.out.println("请输入字符串，并多混入空格回车尝试不同结果");
        if(scan2.hasNextInt() ) {
            int a = scan2.nextInt();
            System.out.println("第一次"+a);
            int b = scan2.nextInt();
            System.out.println("第二次"+b);
            System.out.println(a+b);
        }

        //hasNext 和 NextLine组合,nextLine可以录入空格,读到回车前的内容
        //Scanner scan3 = new Scanner(System.in);
        //System.out.println("请输入字符串，并多混入空格回车尝试不同结果");
        //if(scan3.hasNext() ) {
        //    System.out.println("第一次"+scan3.nextLine());
        //    System.out.println("第二次"+scan3.nextLine());
        //    System.out.println("第三次"+scan3.nextLine());
        //}

        //hasNextLine 和 next组合，
        //Scanner scan4 = new Scanner(System.in);
        //System.out.println("请输入字符串，并多混入空格回车尝试不同结果");
        //if(scan4.hasNextLine() ) {
        //    System.out.println("第一次"+scan4.next());
        //    System.out.println("第二次"+scan4.next());
        //    System.out.println("第三次"+scan4.next());
        //}

        //hasNextLine 和 nextLine组合
        //Scanner scan5 = new Scanner(System.in);
        //System.out.println("请输入字符串，并多混入空格回车尝试不同结果");
        //if(scan5.hasNextLine() ) {
        //    System.out.println("第一次"+scan5.nextLine());
        //    System.out.println("第二次"+scan5.nextLine());
        //    System.out.println("第三次"+scan5.nextLine());
        //}
    }
}


/**
 * hasNext()方法会判断接下来是否有非空字符.如果有,则返回true，没有则阻塞。例如一直敲回车相当于一直判断为空字符，但是不会返回false，而是一直阻塞在判断阶段，直到你输入了非空字符
 *  hasNextLine() 方法会根据行匹配模式去判断接下来是否有一行(包括空行),如果有,则返回true。这个没什么特别的，只要是你敲了回车那都是true并且不会阻塞
 *
 **/


