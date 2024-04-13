package demo01.logDemo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/13  11:04
 */
@Slf4j
public class logoutdemo {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(logoutdemo.class);

        // 记录debug级别的信息
            logoutdemo.log.debug(">>This is debug message");
            // 记录info级别的信息
            logoutdemo.log.info(">>This is info message");
            // 记录error级别的信息
            logoutdemo.log.error(">>This is error message");
            // 记录warn级别的信息
            logoutdemo.log.warn(">>This is warn message");
            // 记录trace级别的信息
            logoutdemo.log.trace(">>This is trace message");

    }
}
