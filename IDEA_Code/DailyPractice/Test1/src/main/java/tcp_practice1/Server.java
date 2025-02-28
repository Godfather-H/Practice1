package tcp_practice1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

    public static HashMap<Socket, String> sockets = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.out.println("服务器已上线!");
        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {
            Socket socket = serverSocket.accept();

            //设置默认用户名
            String hostAddress = socket.getInetAddress().getHostAddress();
            int port = socket.getPort();
            String name = "用户" + hostAddress + ":" + port;
            //获取该线程的用户名
            /*try(InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream)){
                if(!"".equals(dataInputStream.readUTF())){
                    name = dataInputStream.readUTF();
                }
            }*/

            sockets.put(socket, name);
            System.out.println("有人上线了: " + socket.getRemoteSocketAddress());
            new ServerReaderThread(socket).start();
        }
    }
}
