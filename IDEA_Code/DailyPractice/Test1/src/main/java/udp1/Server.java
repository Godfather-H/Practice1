package udp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建socket对象和packet对象
        DatagramSocket socket = new DatagramSocket(6666);
        byte[] buf = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buf, 1024 * 64);

        while (true) {
            //接收数据并转换为字符串
            socket.receive(packet);
            int length = packet.getLength();
            String s = new String(packet.getData(), 0, length);

            /*//如果客户端发送为exit则结束
            if("exit".equals(s)){
                socket.close();
                break;
            }*/

            //获取客户端ip和端口
            String hostAddress = packet.getAddress().getHostAddress();
            int port = packet.getPort();

            //输出数据
            System.out.println("ip为:" + hostAddress + ", 端口为:" + port + " 发送了:");
            System.out.println(s);
        }
    }
}
