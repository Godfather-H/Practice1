package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9999);
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        socket.receive(packet);
        byte[] data = packet.getData();
        String msg = new String(data, 0, packet.getLength());
        String ip = packet.getAddress().getHostAddress();
        System.out.println(ip + msg);
        socket.close();
    }
}
