package tcp_practice1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 9999);
             OutputStream outputStream = socket.getOutputStream();
             DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
             Scanner scanner = new Scanner(System.in)){

            System.out.println("欢迎来到聊天室!");
            System.out.print("请输入您的昵称:");
            String name = scanner.nextLine();
            dataOutputStream.writeUTF(name);
            dataOutputStream.flush();
            System.out.println("--------开始聊天---------");

            new ClientReaderThread(socket).start();

            while (true){
                String s = scanner.nextLine();
                if("exit".equals(s)){
                    System.out.println("聊天即将结束,下次再见!");
                    break;
                }
                dataOutputStream.writeUTF(s);
                dataOutputStream.flush();
            }
        }
    }
}
