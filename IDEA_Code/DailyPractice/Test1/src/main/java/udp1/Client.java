package udp1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] bytes = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入您要发送的信息:");
            String s = scanner.nextLine();
            bytes = s.getBytes();
            try {
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6666);
                socket.send(packet);
                if ("exit".equalsIgnoreCase(s)) {
                    System.out.println("聊天结束,下次再见!");
                    socket.close();
                    break;
                }
                System.out.println("客户端数据发送完毕!");
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
