package org.petrowich.chat.handlers;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collection;
import java.util.HashSet;

public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final Collection<WebSocketSession> webSocketSessionList = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        webSocketSessionList.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        for (WebSocketSession webSocketSession : webSocketSessionList) {
            webSocketSession.sendMessage(message);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        webSocketSessionList.remove(session);
    }
}
