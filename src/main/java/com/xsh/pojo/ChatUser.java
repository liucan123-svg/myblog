package com.xsh.pojo;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "t_chat_user")
public class ChatUser {
    @Id
    @GeneratedValue
    private Long id;
    private String socketId;
    private String nickname;//昵称
    private String username;//登录用户名
    private String password;//QQ和github登录时，此项为空
    private int sex;
    private String avatar;

    private String openId;//当为QQ登陆时，此处保存QQ的唯一标识;
    private String nodeId;//当为github登陆时，此处保存github的唯一标识;

    /**
     * 用户类别
     * 0为房主，1为注册用户，2为QQ登录用户，3为github用户,4为匿名用户(匿名用户发送的信息不会保存数据库)
     */
    private Integer user_type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date firstLoginTime;//首次登入时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;//最后登入时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocketId() {
        return socketId;
    }

    public void setSocketId(String socketId) {
        this.socketId = socketId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public Date getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(Date firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
