package test;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class SubmitFileTask implements Runnable {
    private Socket socket;
    public SubmitFileTask(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        //3.获取传输数据的流对象
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            //4.读取上传的文件名
            String filename = br.readLine();
            //5.回写客户端消息(可以上传字节了)
            bw.write("OK");
            bw.newLine();
            bw.flush();
            File file = new File("D:\\音频", UUID.randomUUID().toString() + filename);
            //6.读取客户端上传的文件(字节)
            FileOutputStream fos = new FileOutputStream(file);
            byte[] bys = new byte[1024];
            int len;
            while ((len = is.read(bys)) != -1) {
                fos.write(bys, 0, len);
            }
            fos.close();
            //7.会写给客户端消息
            bw.write("上传成功");
            bw.newLine();
            bw.flush();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
