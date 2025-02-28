package tcp_practice1;

import java.io.*;
import java.net.Socket;

public class ServerReaderThread extends Thread {

    private Socket socket;

    ServerReaderThread(Socket socket) {
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
                    sendMsgToAll(socket,s);
                } catch (IOException e) {
                    Server.sockets.remove(socket);
                    System.out.println("有人下线了: " + socket.getRemoteSocketAddress());
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMsgToAll(Socket soc,String s) throws IOException {
        for (Socket onlineSocket : Server.sockets.keySet()) {
            if (onlineSocket.getRemoteSocketAddress().equals(soc.getRemoteSocketAddress())) {
                continue;
            }
            OutputStream outputStream = onlineSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(Server.sockets.get(soc) + ": " + s);
            dataOutputStream.flush();
        }
    }
}
