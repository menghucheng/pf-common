/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：10:31 AM 2019/1/11
 */
package com.pf.extention;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：10:31 AM 2019/1/11
 *
 */
public class ExtensionBean {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ExtensionBean.class);

    /**
     * point
     */
    private String point;

    /**
     * content
     */
    private Element content;

    /**
     * defaultExtension
     */
    private DefaultExtension defaultExtension;


    public void init(){
    }



    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public Element getContent() {
        return content;
    }

    public void setContent(Element content) {
        this.content = content;
    }

    public DefaultExtension getDefaultExtension() {
        return defaultExtension;
    }

    public void setDefaultExtension(DefaultExtension defaultExtension) {
        this.defaultExtension = defaultExtension;
    }
}
