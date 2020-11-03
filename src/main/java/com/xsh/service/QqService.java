package com.xsh.service;

import com.xsh.pojo.QQInfo;


public interface QqService {

    QQInfo save(QQInfo qqInfo);
    QQInfo findQQuser(String openid);
    void updateAvatar(String avatar,Long id);
}
