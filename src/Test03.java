import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lc on 2017/8/19.
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        //创建URL实例
        URL url= new URL("http://www.baidu.com");
        InputStream is = url.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(is,"utf-8 ");
        BufferedReader br = new BufferedReader(inputStreamReader);
        String data = br.readLine();
        while (data!=null){
            System.out.println(data);
            data = br.readLine();
        }
        br.close();
        inputStreamReader.close();
        is.close();
    }
}
