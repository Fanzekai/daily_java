package demo03.EnumDemo;

import java.util.*;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/28  10:12
 */


public class TestReflection {


        public static void main(String[] args) {
            Map<Integer, String> map = new HashMap<>();
            map.put(2, "jay");
            map.put(1, "whx");
            map.put(3, "huaxiao");
            //把一个map的键转化为list
            List<Integer> keyList = new ArrayList<>(map.keySet());
            System.out.println(keyList);
            //把map的值转化为list
            List<String> valueList = new ArrayList<>(map.values());
            System.out.println(valueList);
            //把map的键值转化为list
            List entryList = new ArrayList(map.entrySet());
            System.out.println(entryList);


            for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {

                System.out.println(integerStringEntry.getKey() + " " + integerStringEntry.getValue());
            }

            Iterator itr = map.entrySet().iterator();
            while(itr.hasNext()) {
                Map.Entry entry = (Map.Entry) itr.next();
                // get key
                Integer key = (Integer) entry.getKey();
                // get value
                String value = (String) entry.getValue();

                System.out.println("key:"+key+",value:"+value);
            }


        }
}
