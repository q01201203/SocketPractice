import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP的socket通信
 * Created by lc on 2017/8/19.
 */
public class Server {

    public static void main(String[] args) {
        try {
            //1创建服务器端的socket 即ServerSocket，指定绑定的端口，并监听
            ServerSocket serverSocket = new ServerSocket(8888);
            //记录客户端的数量
            int count = 0;
            System.out.println("***服务器即将启动，等待客户连接");
            //2.调用accept方法侦听，等待客户端的连接
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                //创建一个新的线程
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();

                count++;//统计客户端的数量
                System.out.println("客户端数量："+count);

                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端的IP："+address.getHostAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
