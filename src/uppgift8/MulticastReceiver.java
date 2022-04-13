package uppgift8;

import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;

public class MulticastReceiver {
    MulticastSocket socket;

    public MulticastReceiver() throws SocketException, IOException {
        int port = 55555;
        String ip = "234.235.236.237";
        InetAddress iadr = InetAddress.getByName(ip);

        InetSocketAddress group = new InetSocketAddress(iadr, port);
        NetworkInterface netIf = NetworkInterface.getByName("en0");
        this.socket = new MulticastSocket(port);
        socket.joinGroup(group, netIf);

    }
    public String multicastReceiv() throws IOException {
        byte[] data = new byte[256];
        while (true) {
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            System.out.println("Meddelande från " + packet.getAddress().getHostAddress() + " " + LocalDateTime.now());
            String message = new String(packet.getData(), 0, packet.getLength());
            return message;
        }
    }
}
