package demo04;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/1/18  9:55
 */
public class IOClient {


    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
