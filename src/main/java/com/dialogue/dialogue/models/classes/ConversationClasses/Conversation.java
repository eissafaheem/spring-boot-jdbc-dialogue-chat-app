package com.dialogue.dialogue.models.classes.ConversationClasses;

public class Conversation {
    String conversationId;
    String firstUserId;
    String secondUserId;
    String lastMessageId;

    public Conversation(String conversationId, String firstUserId, String secondUserId, String lastMessageId) {
        this.conversationId = conversationId;
        this.firstUserId = firstUserId;
        this.secondUserId = secondUserId;
        this.lastMessageId = lastMessageId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(String firstUserId) {
        this.firstUserId = firstUserId;
    }

    public String getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(String secondUserId) {
        this.secondUserId = secondUserId;
    }

    public String getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(String lastMessageId) {
        this.lastMessageId = lastMessageId;
    }
}
