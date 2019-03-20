/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：8:07 PM 2019/3/20
 */
package com.mhc.utils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mhc.utils.bean.SftpBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;


/**
 * sftp connection tool
 *
 * @author ：tigermeng.
 * @desc ：
 * @date ：8:07 PM 2019/3/20
 */
@Slf4j
public class SftpUtil {

    private static final String CHANNEL_TYPE = "sftp";

    public static ChannelSftp connect(SftpBean bean){
        ChannelSftp sftp = null;
        try {
            Assert.notNull(bean,"sftp bean is not allow null!");
            log.debug("sftp bean {}",bean);
            JSch jSch = new JSch();
            Session session = jSch.getSession(bean.getUserName(), bean.getRemoteAddress(), bean.getPort());
            log.info("sftp session created.");

            session.setPassword(bean.getPassWord());
            session.setConfig(bean.getConfig());
            session.connect();
            log.info("session connected");

            Channel channel = session.openChannel(CHANNEL_TYPE);
            channel.connect();
            log.info("sftp channel connected");
            sftp = (ChannelSftp) channel;

            sftp.cd(bean.getDirectory());

        } catch (Exception e){
            log.error("connect sftp error!",e);
        }
        return sftp;
    }


    /**
     * download
     * @param dir
     * @param downFile
     * @param saveFile
     * @param sftp
     * @return
     */
    public static boolean downLoad(String dir,String downFile,String saveFile,ChannelSftp sftp){
        try {
            Assert.notNull(sftp, "sftp is not allowed null");
            sftp.cd(dir);
            sftp.get(downFile,new FileOutputStream(new File(saveFile)));
            return true;
        }catch (Exception e){
            log.error("sftp download error",e);
            return false;
        }
    }


    /**
     * upload
     * @param channel
     * @param fileName
     */
    public static void upload(String channel,String fileName){
        ChannelSftp sftp = null;
        try{
          log.info("文件上传 begin");
            SftpBean bean = new SftpBean();

            //连接操作
            //TODO
            //上传
        } catch (Exception e){

        }
    }


    public static void main(String[] args) {

    }
}
