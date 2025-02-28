package tcp_practice2;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String hostname = "localhost"; // 服务器主机名
        int port = 12345; // 服务器端口号

        try (Socket socket = new Socket(hostname, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            String userMessage;
            System.out.println("输入消息 (输入 'exit' 退出):");

            while ((userMessage = userInput.readLine()) != null) {
                out.println(userMessage); // 发送用户输入到服务器
                if ("exit".equalsIgnoreCase(userMessage)) {
                    break; // 退出循环
                }
                System.out.println("服务器响应: " + in.readLine()); // 接收服务器回复
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
