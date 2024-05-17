package demo13;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/15  19:26
 */
public class test {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个整数：");
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<List<Integer>> findnumber = findnumber(a, b);
            for (List<Integer> integers : findnumber) {

                System.out.println(integers.get(0)+" "+integers.get(1));
            }
            System.out.println( );
        }
        scanner.close();
}


    public static List<List<Integer>> findnumber(int n,int m){
        List<List<Integer>> list = new ArrayList<>();
        dfs(list,new ArrayList<>(),1,n,m);
        return  list;
    }

    private static void dfs(List<List<Integer>> result,List<Integer> temp,int start,int n,int remain){

        if(remain<0){
            return;
        }else if(remain==0){
            result.add(new ArrayList<>(temp));
            return;
        }else {
            for (int i = start; i < n; i++) {
                temp.add(i);
                dfs(result,temp,i+1,n,remain-i);

            temp.remove(temp.size()-1);
        }      }
    }

}

