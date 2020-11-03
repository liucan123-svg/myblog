package com.xsh.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
public class webSocketChatController {

    /**
     * 登陆界面
     */
    @GetMapping("/chatLogin")
    public ModelAndView login() {
        return new ModelAndView("chatLogin");
    }

    /**
     * 聊天界面
     */
    @GetMapping("/chatIndex")
    public ModelAndView index(String username, String password, HttpServletRequest request) throws UnknownHostException {
        if (StringUtils.isEmpty(username)) {
            username = "匿名用户";
        }
        ModelAndView mav = new ModelAndView("chatRoom");
        mav.addObject("username", username);
        mav.addObject("webSocketUrl", "ws://"+ InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/chat");
        return mav;
    }
}
