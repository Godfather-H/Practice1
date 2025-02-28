package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(3333);
        System.out.println("聊天室开启...");
        while (true) {
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            socket.receive(packet);
            byte[] data = packet.getData();
            String ip = packet.getAddress().getHostAddress();
            String msg = new String(data,0,packet.getLength());
            System.out.println(ip + msg);
        }
    }
}
