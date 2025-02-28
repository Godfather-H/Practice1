package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8899);
        System.out.println("服务端已开启...");
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String msg = new String(bys,0,len);
        String ip = socket.getInetAddress().getHostName();
        System.out.println(ip + msg);
        os.write("你也好".getBytes());
        socket.close();
        server.close();
    }
}
