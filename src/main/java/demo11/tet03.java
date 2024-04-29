package demo10;

import java.util.Scanner;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/17  11:51
 */
public class tet03 {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);

            //
            //Scanner scanner1 = new Scanner(System.in);
            //if (scanner1.hasNext()) {
            //    String a = scanner1.nextLine();
            //    String b = scanner1.nextLine();
            //    System.out.println(a+b);
            //}


        }

    }}
