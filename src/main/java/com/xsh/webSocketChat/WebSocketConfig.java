package com.xsh.webSocketChat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

 /*注册WebSocket配置类*/

@Configuration
public class WebSocketConfig {

    /**
     * 用于扫描和注册所有携带ServerEndPoint注解的实例。
     * <p>
     * 若部署到外部容器 则无需提供此类。
     */

    /*部署服务器时需要注释调，本地运行不用注释*/
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {

        return new ServerEndpointExporter();
    }
}
