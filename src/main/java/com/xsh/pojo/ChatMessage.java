package com.xsh.pojo;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "t_chat_message")
public class ChatMessage {
    @Id
    @GeneratedValue
    private Long id;
    private String launchId;//发起人id 为0是系统发送  客户端提交socketId->通过socketId查询用户的id，将他存入数据库
    private String launchUser;//发起人信息

    private String receiveId;//接收人id
    private String receiveUser;// 接收人信息
    private String content;//内容
    /**
     * 消息类型
     * 0系统消息(登入登出)、1文本消息、2图片消息
     */
    private int type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;//发送时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLaunchId() {
        return launchId;
    }

    public void setLaunchId(String launchId) {
        this.launchId = launchId;
    }

    public String getLaunchUser() {
        return launchUser;
    }

    public void setLaunchUser(String launchUser) {
        this.launchUser = launchUser;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(String receiveUser) {
        this.receiveUser = receiveUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
