package com.xsh.service;

import com.xsh.pojo.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface MessageService {

    Message saveMessage(Message message);

    Page<Message> listMessage(Pageable pageable);

    void findParentMessage(Message message);

    void bindEmail(String email,String avatar,String nickname,String openid);
}
