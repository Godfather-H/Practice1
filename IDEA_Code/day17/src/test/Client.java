package test;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        //1.创建socket对象
        Socket socket = new Socket("127.0.0.1",9988);
        //2.创建传输数据的流对象
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        //3.写出文件名字
        File file = new File("C:\\Users\\ASUS\\Desktop\\7月14日 20点20分.m4a..mp3");
        bw.write(file.getName());
        bw.newLine();
        bw.flush();
        //4.读取服务端回写的消息
        String flag = br.readLine();
        if("OK".equals(flag)){
            //5.创建本地字节输入流，关联要上传的文件
            FileInputStream fis = new FileInputStream(file);
            //6.上传文件的字节
            byte[] bys = new byte[1024];
            int len;
            while((len = fis.read(bys)) != -1){
                os.write(bys, 0, len);
            }
            socket.shutdownOutput();
            fis.close();
        }
        //7.读取服务端的返回消息
        String result = br.readLine();
        System.out.println(result);
        socket.close();
    }
}
