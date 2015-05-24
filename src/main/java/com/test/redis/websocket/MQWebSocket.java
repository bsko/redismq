package com.test.redis.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by Пользователь on 24.05.2015.
 */
@ServerEndpoint("/wsocket/mq")
public class MQWebSocket {

    private Session session;

    @OnOpen
    public void open(Session session) {
        System.out.println("open");
        this.session = session;
    }

    @OnClose
    public void close() {
        System.out.println("close");
        this.session = null;
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println(message);
//        session.getBasicRemote().sendText();
    }

    @OnError
    public void error(Throwable e) {
        e.printStackTrace();
    }
}
