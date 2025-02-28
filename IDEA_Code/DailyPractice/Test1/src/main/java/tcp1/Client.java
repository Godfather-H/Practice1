package tcp1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",8888);
        Scanner sc = new Scanner(System.in);

        try(OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream)){

            while (true) {
                System.out.println("请输入您要发送的信息:");
                String s = sc.nextLine();

                if("exit".equals(s)){
                    System.out.println("对话结束,下次再见!");
                    socket.close();
                    break;
                }

                dataOutputStream.writeUTF(s);
                dataOutputStream.flush();
                System.out.println("发送信息成功!");
            }
        }
    }
}
