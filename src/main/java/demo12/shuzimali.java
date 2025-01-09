package demo12;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  10:02
 */
public class shuzimali {

public static void tesw() {

    String fzk = "/user/**,/account/**,/dict/**,/model/**,/index/**,/gateway/**,/logs/**,/operateLogs/**,/orgs/**,/news/**,/newsTemplate/**,/checkModel/**,/checkElement/**,/archiveConfig/**,/archiveConfig/**,/storage/**,/apiLogs/**";

    Map<String, String> args = new LinkedHashMap();

    String[] paths = fzk.split(",");
    System.out.println(paths.toString());

    for (int i = 0; i < paths.length; i++) {
        args.put("_genkey_" + i, paths[i]);
    }

    for (Map.Entry<String, String> stringStringEntry : args.entrySet()) {

        System.out.println(stringStringEntry.getKey()+">>>>"+stringStringEntry.getValue());

    }
}

    public static void main(String[] args) {
        tesw();
    }
}
