/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：12:07 AM 2019/3/18
 */

import com.mhc.communication.HttpClientFactory;
import com.mhc.communication.MethodParamFactory;
import org.apache.http.Header;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;

import java.io.IOException;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：12:07 AM 2019/3/18
 *
 */
public class TestHttp {

    @Test
    public void testPost() throws IOException {
        String url = "http://www.baidu.com";


        CloseableHttpClient httpClients = HttpClientFactory.getHttpClients();
        HttpPost httpPost = new HttpPost(url);

        MethodParamFactory.setParam(httpPost,null);

        CloseableHttpResponse response = httpClients.execute(httpPost);

        StatusLine statusLine = response.getStatusLine();
//        if(302==statusLine.getStatusCode()){
//            //重定向
//            Header header = response.getFirstHeader("location");
//            String newUrl = header.getValue();
//            HttpPost newHttpPost = new HttpPost(newUrl);
//            response = httpClients.execute(newHttpPost);
//            statusLine = response.getStatusLine();
//        }

        if(200 == statusLine.getStatusCode()){
            System.out.println("哈哈哈哈哈哈哈哈哈哈");
        }

        System.out.println(response.getStatusLine());

        System.out.println(EntityUtils.toString(response.getEntity()));

    }
}
