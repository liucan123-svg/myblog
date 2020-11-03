package com.xsh.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "t_qquser")
public class QQInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String logintime;
    private String openid;
    private String nickname;
    private String gender;
    private String year;
    private String cip;
    private String cid;
    private String cname;
    private String avatar;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "QQInfo{" +
                "id=" + id +
                ", logintime='" + logintime + '\'' +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", year='" + year + '\'' +
                ", cip='" + cip + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
