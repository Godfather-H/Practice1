package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入:");
            String msg = sc.nextLine();
            if("886".equals(msg)){
                break;
            } else {
                DatagramPacket packet = new DatagramPacket(msg.getBytes(),msg.getBytes().length, InetAddress.getByName("127.0.0.1"),3333);
                socket.send(packet);
            }
        }
        socket.close();
    }
}
