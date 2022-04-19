package uppgift8;

import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;

public class MulticastReceiver extends Thread{
    public MulticastSocket socket;
    int port = 55555;
    String ip = "234.235.236.237";
    InetAddress iadr = InetAddress.getByName(ip);
    public InetSocketAddress group = new InetSocketAddress(iadr, port);
    public NetworkInterface netIf = NetworkInterface.getByName("en0");

    public MulticastReceiver() throws SocketException, IOException {



        this.socket = new MulticastSocket(port);
        socket.joinGroup(group, netIf);
    }
    public String multicastReceiv() throws IOException {
            byte[] data = new byte[256];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            System.out.println("Meddelande från " + packet.getAddress().getHostAddress() + " " + LocalDateTime.now());
            String message = new String(packet.getData(), 0, packet.getLength());
            return message;
    }
    @Override
    public void run(){
        while (!Thread.interrupted()) {
            try {
                Gui.area.append(multicastReceiv() + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void disconnet(){
        try {
            socket.leaveGroup(group, netIf);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
