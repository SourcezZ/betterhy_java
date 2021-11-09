package com.betterhy.common.constant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 *
 * @author Hy
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "xml")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "ToUserName",
        "FromUserName",
        "CreateTime",
        "MsgType",
        "Content",
})
public class TextMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    // 用户Id
    private String ToUserName;
    // 用户名
    private String FromUserName;
    // 用户密码
    private long CreateTime;
    // 用户生日
    private String MsgType;
    // 用户钱包
    private String Content;

    public TextMessage() {
        super();
    }

    public TextMessage(String ToUserName, String FromUserName, int CreateTime, String MsgType,
                       String Content) {
        super();
        this.ToUserName = ToUserName;
        this.FromUserName = FromUserName;
        this.CreateTime = CreateTime;
        this.MsgType = MsgType;
        this.Content = Content;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}