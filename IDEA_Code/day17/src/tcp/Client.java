package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1",8899);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        os.write("你好".getBytes());
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String msg = new String(bys,0,len);
        System.out.println(msg);
        socket.close();
    }
}
