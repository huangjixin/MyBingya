package com.jcin.cms.modules.urlhandler.web;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebsocketEndPoint extends TextWebSocketHandler {
	private static  AtomicInteger connectionIds = new AtomicInteger(0);
	private static  Set<WebsocketEndPoint> connections = new CopyOnWriteArraySet<WebsocketEndPoint>();
	private WebSocketSession session;

	public WebsocketEndPoint() {
		super();
        connections.add(this);
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
		connections.add(this);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		super.afterConnectionClosed(session, closeStatus);
		connections.remove(this);
	}
	
	
	public static void broadcast(TextMessage msg) {
        for (WebsocketEndPoint client : connections) {
            try {
                synchronized (client) {
                    client.session.sendMessage(msg);
                }
            } catch (IOException e) {
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore
                }
            }
        }
    }
}