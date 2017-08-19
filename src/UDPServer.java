import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP服务器端
 * Created by lc on 2017/8/19.
 */
public class UDPServer {

    public static void main(String[] args) throws IOException {
        //1.创建服务器端DatagramSocket
        DatagramSocket socket = new DatagramSocket(8800);
        //2.创建数据报，用于接收客户端发送数据
        byte[] data = new byte[1024];//指定数据包的大小
        DatagramPacket packet = new DatagramPacket(data,data.length);
        System.out.println("***服务器端已经启动，等待客户端发送数据");
        //3接收客户端发送的数据
        socket.receive(packet);//此方法在接收到数据报之前会一直阻塞
        //4.读取
        String info = new String(data,0,packet.getLength());
        System.out.println("我是服务器，客户端说："+info);

        //向客户端响应数据
        //1.定义客户端的地址、端口号、数据
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = "欢迎你！".getBytes();
        //2.创建数据报，包含响应的数据信息
        DatagramPacket packet1 = new DatagramPacket(data2,data2.length,address,port);
        //3.响应客户端
        socket.send(packet1);
        //4.关闭资源
        socket.close();
    }
}
