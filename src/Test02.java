import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lc on 2017/8/19.
 */
public class Test02 {

    public static void main(String[] args) throws MalformedURLException {
        //创建一个URL的实例
        URL imooc = new URL("http://www.imooc.com");
        URL url = new URL(imooc,"/index.html?username=tom#test"); //#标示锚点，相对路径
        //如果未指定端口号，则使用默认端口号
        System.out.println("协议："+url.getProtocol()+" 主机："+url.getHost()+" 端口号："+url.getPort());
    }
}
