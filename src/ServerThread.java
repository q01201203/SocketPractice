import java.io.*;
import java.net.Socket;

/**
 * 服务器端线程处理类
 * Created by lc on 2017/8/19.
 */
public class ServerThread extends Thread {

    //和本线程相关的socket
    Socket socket = null;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    //线程执行的操作，响应客户端的请求
    public void run(){
        //3.获取输入流，并读取客户端信息
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine())!=null){
                System.out.println("我是服务器，客户端说："+info);
            }
            socket.shutdownInput();//关闭输入流
            //4.获取输出流，响应客户端的请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎你");
            pw.flush();//调用flush刷新

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5关闭资源
            try {
                if (pw!=null){
                    pw.close();
                }
                if (os!=null)
                    os.close();
                if (br!=null)
                    br.close();
                if (isr!=null)
                    isr.close();
                if (is!=null)
                    is.close();
                if (socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
