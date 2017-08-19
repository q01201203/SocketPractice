import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress类
 * Created by lc on 2017/8/19.
 */
public class Test01 {

    public static void main(String[] args) throws UnknownHostException {
        //获取本机的实例
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名："+address.getHostName() +" IP地址："+address.getHostAddress());
        byte[] bytes = address.getAddress();//获取字节数组的ip地址
        System.out.println("字节数组形式的IP："+Arrays.toString(bytes));
    }

}
