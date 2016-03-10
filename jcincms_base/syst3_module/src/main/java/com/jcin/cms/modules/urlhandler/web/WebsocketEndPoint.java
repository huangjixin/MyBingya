package com.jcin.cms.modules.urlhandler.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebsocketEndPoint extends TextWebSocketHandler {
	private static  AtomicInteger connectionIds = new AtomicInteger(0);
	private static  ArrayList<WebSocketSession> connections = new ArrayList<WebSocketSession>();
	private WebSocketSession session;

	public WebsocketEndPoint() {
		super();
	}

	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		WebsocketEndPoint.broadcast(message);
		/*TextMessage returnMessage = new TextMessage(message.getPayload()
				+ " received at server");
		session.sendMessage(returnMessage);*/
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		super.afterConnectionEstablished(session);
		this.session = session;
		connections.add(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		super.afterConnectionClosed(session, closeStatus);
		connections.remove(this);
	}
	
	
	public static void broadcast(TextMessage msg) {
        for (WebSocketSession session : connections) {
            try {
                synchronized (session) {
                    session.sendMessage(msg);
                }
            } catch (IOException e) {
                connections.remove(session);
                try {
                    session.close();
                } catch (IOException e1) {
                    // Ignore
                }
            }
        }
    }
}