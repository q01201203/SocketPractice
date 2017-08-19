import java.io.*;
import java.net.Socket;

/**
 * Created by lc on 2017/8/19.
 */
public class Client {

    public static void main(String[] args) {
        try {
            //1.创建客户端socket,指定服务器地址和端口
            Socket socket = new Socket("localhost",8888);
            //2.向服务器端发送信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：admin;密码：123");
            pw.flush();
            socket.shutdownOutput();//关闭输出流

            //3.获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine())!=null){
                System.out.println("我是客户端，服务器端说："+info);
            }


            //4，关闭其他的相关资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
