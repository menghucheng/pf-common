/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:35 PM 2019/3/17
 */
package com.mhc.communication;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * httpClient工厂
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:35 PM 2019/3/17
 *
 */
public class HttpClientFactory {

    private static CloseableHttpClient httpClient;

    private HttpClientFactory() {

    }


    /**
     *  获取httpClient
     * @return httpClient
     */
    public static CloseableHttpClient getHttpClients(){
        if(httpClient == null){
            synchronized (HttpClientFactory.class){
                if(httpClient==null){
                    httpClient = HttpClients.createDefault();
                }
            }
        }
        return httpClient;
    }
}
