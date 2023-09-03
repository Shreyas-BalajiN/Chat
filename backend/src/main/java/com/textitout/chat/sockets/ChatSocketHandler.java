package com.textitout.chat.sockets;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ChatSocketHandler implements WebSocketHandler {

    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>(); // store all websocket sessions
    private final Map<String, String> sessionChatMap = new ConcurrentHashMap<>(); // make session id equal to chat names,

    // keep track which chat each session is part of
    private String extractChatNameFromUri(URI uri) {
        // parse the query parameters in the WebSocket URI to find the chatName parameter
        if(uri == null){
            return null;
        }
        String query = uri.getQuery();

        if (query != null) {
            String[] queryParams = query.split("&");
            for (String param : queryParams) {
                String[] keyValue = param.split("=");
                if (keyValue.length == 2 && "chatName".equals(keyValue[0])) {
                    return keyValue[1];
                }
            }
        }
        return null; // ChatName parameter not found in the URL
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Retrieve the chatName from the session attributes
        String chatName = extractChatNameFromUri(session.getUri());
        //  if the chatName is present on the websocket URI
        if (chatName != null) {
            // Store the WebSocket session in the sessions map
            sessions.put(session.getId(), session);
            // Associate the chatName with this session
            sessionChatMap.put(session.getId(), chatName);

        } else { // if the chatName is not present on the connection URL
            System.err.println("WebSocket connection established without chatName parameter.");
            // close the WebSocket connection.
            session.close(CloseStatus.POLICY_VIOLATION.withReason("Missing chatName parameter"));
        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        // Handle incoming messages here and send responses to specific chat sessions.
        String payload = message.getPayload().toString();
        String chatName = sessionChatMap.get(session.getId());

        System.out.println(payload);

        // For example, broadcast the message to all sessions with the same chatName
        for (WebSocketSession targetSession : sessions.values()) {
            String targetChatName = sessionChatMap.get(targetSession.getId());
            if (targetChatName != null && targetChatName.equals(chatName)) {
                try {
                    targetSession.sendMessage(new TextMessage("Chat [" + chatName + "]: " + payload));
                } catch (IOException e) {
                    // Handle exception (e.g., client disconnected)
                }
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // Remove the WebSocket session and associated chatName
        sessions.remove(session.getId());
        sessionChatMap.remove(session.getId());
    }
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}
