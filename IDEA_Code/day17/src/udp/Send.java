package udp;

import java.net.*;

public class Send {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);
        String msg = "天下万般兵刃，唯有过往伤人最深";
        byte[] bytes = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),9999);
        socket.send(packet);
        socket.close();
    }
}
