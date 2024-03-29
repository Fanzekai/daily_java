package demo08.Json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo08.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/16  10:03
 */
public class JsonSerialize {
    public static void main(String[] args) throws IOException {
        new JsonSerialize().start();

    }


    public void start() throws IOException, JsonProcessingException {

        List<User> friends = new ArrayList<>();
        User u = new User();
        u.setUserName("张三");
        u.setPassword("123456");
        u.setUserInfo("张三是一个很牛逼的人");
        u.setFriends(friends);
        User f1 = new User();
        f1.setUserName("李四");
        f1.setPassword("123456");
        f1.setUserInfo("李四是一个很牛逼的人");

        User f2 = new User();
        f2.setUserName("王五");
        f2.setPassword("123456");
        f2.setUserInfo("王五是一个很牛逼的人");

        friends.add(f1);
        friends.add(f2);

        //序列化
        ObjectMapper mapper = new ObjectMapper();
        Long t1 = System.currentTimeMillis();
        byte[] writeValueAsBytes = null;
        for (int i = 0; i < 10; i++) {
            writeValueAsBytes = mapper.writeValueAsBytes(u);
        }
        System.out.println("json serialize: " + (System.currentTimeMillis() - t1) + "ms; 总大小：" + writeValueAsBytes.length);
        //反序列化
        Long t2 = System.currentTimeMillis();
        User user = mapper.readValue(writeValueAsBytes, User.class);
        System.out.println("json deserialize: " + (System.currentTimeMillis() - t2) + "ms; User: " + user);

    }
}
