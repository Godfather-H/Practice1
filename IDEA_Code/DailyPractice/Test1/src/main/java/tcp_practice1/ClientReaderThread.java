package tcp_practice1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientReaderThread extends Thread{
    private Socket socket;

    ClientReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             DataInputStream dataInputStream = new DataInputStream(inputStream)){
            while (true) {
                try {
                    String s = dataInputStream.readUTF();
                    System.out.println(s);

                } catch (IOException e) {
                    Server.sockets.remove(socket);
                    System.out.println("自己下线了: " + socket.getRemoteSocketAddress());
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
