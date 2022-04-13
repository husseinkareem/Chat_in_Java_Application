package uppgift8;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MulticastReceiver mr = new MulticastReceiver();
        MulticastSender ms = new MulticastSender();
        ms.MulticastSend("hej");
        System.out.println(mr.multicastReceiv());

        Gui g = new Gui();
    }
}
