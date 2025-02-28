package com.itheima.config;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;

public class GetHttpSessionConfig extends ServerEndpointConfig.Configurator {

    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {
        //获取HttpSession对象
        HttpSession httpSession = (HttpSession) request.getHttpSession();

        //将httpSession对象保存起来，存到ServerEndpointConfig对象中
        //在ChatEndpoint类的onOpen方法就能通过EndpointConfig对象获取在这里存入的数据
        config.getUserProperties().put(HttpSession.class.getName(), httpSession);
    }
}
