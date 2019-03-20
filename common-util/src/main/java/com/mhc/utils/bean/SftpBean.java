/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：7:58 PM 2019/3/20
 */
package com.mhc.utils.bean;

import lombok.ToString;

import java.util.Properties;

/**
 * SFTP params
 *
 * @author ：tigermeng.
 * @desc ：
 * @date ：7:58 PM 2019/3/20
 */
@ToString
public class SftpBean {

    /**
     * userName
     */
    private String userName;

    /**
     * password
     */
    private String passWord;

    /**
     * remoteAddress
     */
    private String remoteAddress;

    /**
     * port
     */
    private int port;

    /**
     * directory
     */
    private String directory;

    /**
     * localDirectory
     */
    private String localDirctory;

    /**
     * secret file path
     */
    private String keyFile;

    /**
     * timeout
     */
    private String timeOut;

    /**
     * config
     */
    private Properties config;

    public SftpBean(){
        this.config = new Properties();
        this.config.put("StrictHostKeyChecking", "no");
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getLocalDirctory() {
        return localDirctory;
    }

    public void setLocalDirctory(String localDirctory) {
        this.localDirctory = localDirctory;
    }

    public String getKeyFile() {
        return keyFile;
    }

    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }
}
