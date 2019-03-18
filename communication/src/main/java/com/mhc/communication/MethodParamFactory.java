/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:50 PM 2019/3/17
 */
package com.mhc.communication;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpMessage;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:50 PM 2019/3/17
 *
 */
@Slf4j
public class MethodParamFactory {

    public static void setParam(HttpPost httpPost, Map<String,String> params){

        if(!CollectionUtils.isEmpty(params)){
            List<NameValuePair> list = new ArrayList<NameValuePair>(params.size());
            for (String s : params.keySet()) {
                NameValuePair nameValuePair = new BasicNameValuePair(s,params.get(s));
                list.add(nameValuePair);
            }
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(list));
            } catch (UnsupportedEncodingException e) {
                log.error("http param encoding exception",e);
                throw new RuntimeException(e);
            }
        }
    }
}
