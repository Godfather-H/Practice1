package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        //1.创建ServerSocket对象
        ServerSocket server = new ServerSocket(9988);
        System.out.println("服务端开启,等待客户端链接...");
        while(true){
            //2.相应客户端发送的请求
            Socket socket = server.accept();
            //new Thread(new SubmitFileTask(socket)).start();
            pool.submit(new SubmitFileTask(socket));
        }
    }
}
