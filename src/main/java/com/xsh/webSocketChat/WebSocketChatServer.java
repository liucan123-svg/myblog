package com.xsh.webSocketChat;

import com.alibaba.fastjson.JSON;
import com.xsh.pojo.ChatUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Future;

  /*WebSocket 聊天服务端*/

@Component
@ServerEndpoint("/chat")
public class WebSocketChatServer {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    private static CopyOnWriteArraySet<WebSocketChatServer> webSockets = new CopyOnWriteArraySet<>();

    /**
     * 全部在线会话  PS: 基于场景考虑 这里使用线程安全的Map存储会话对象。
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();
    //private static Map<String, ChatUser> clientUser = new ConcurrentHashMap<>();

    // 记录空闲Session集合
    private static CopyOnWriteArraySet<Session> idle = new CopyOnWriteArraySet<Session>();
    // 记录正在使用中Session集合，value为Future，表示使用情况
    private static ConcurrentHashMap<Session, Future<Void>> busy = new ConcurrentHashMap<Session, Future<Void>>();
    /**
     * 当客户端打开连接：1.添加会话对象 2.更新在线人数
     */
    @OnOpen
    public void onOpen(Session session) {
        logger.info("=====有新的客户端连接了======: "+session.getId());

        onlineSessions.put(session.getId(), session);
        sendMessageToAll(ChatConstant.jsonStr(ChatConstant.ENTER, "", "", onlineSessions.size()));
    }

    /**
     * 当客户端发送消息：1.获取它的用户名和消息 2.发送消息给所有人
     * <p>
     * PS: 这里约定传递的消息为JSON字符串 方便传递更多参数！
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) {
        ChatConstant message = JSON.parseObject(jsonStr, ChatConstant.class);
        sendMessageToAll(ChatConstant.jsonStr(ChatConstant.SPEAK, message.getUsername(), message.getMsg(), onlineSessions.size()));
    }

    /**
     * 当关闭连接：1.移除会话对象 2.更新在线人数
     */
    @OnClose
    public void onClose(Session session) {
        onlineSessions.remove(session.getId());
        sendMessageToAll(ChatConstant.jsonStr(ChatConstant.QUIT, "", "", onlineSessions.size()));
    }

    /**
     * 当通信发生异常：打印错误日志
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 公共方法：发送信息给所有人
     */
    private static void sendMessageToAll(String msg) {

        for (Map.Entry<String, Session> sessionEntry : onlineSessions.entrySet()) {
            Session session = sessionEntry.getValue();
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendOneMessage(String id, String message) {
        System.out.println("【websocket消息】单点消息:" + message);
        Session session = onlineSessions.get(id);
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

