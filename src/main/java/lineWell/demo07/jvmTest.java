package lineWell.demo07;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/12/27  15:39
 */
public class jvmTest {

    byte[] data = new byte[1024*100];
    public static void main(String[] args) throws InterruptedException {
        List<jvmTest> list = new ArrayList<>();
        while (true) {
            list.add(new jvmTest());
            TimeUnit.SECONDS.sleep(1);
            System.out.println(list.size());
        }
    }
}
