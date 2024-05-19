package demo07.zookeeper;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/19  15:10
 */
public class test02 {

    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        TicketSeller ticketSeller = new TicketSeller();
        for (int i = 0; i < 10; i++) {
            ticketSeller.sellTicketWithLock();

        }
    }
}
