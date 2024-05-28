package demo14.DesignPatterns.CreateDemo.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/23  19:55
 */
public class Product{


    List<String> parts = new ArrayList<String>();

    public void Add(String part){
        parts.add(part);
    }
        public void show() {
            System.out.print("产品的组成:"+"\n");

            for (String s : parts) {
                System.out.println(s);
            }

            System.out.println("\n");
        }}
