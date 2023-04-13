package com.dialogue.dialogue.models.classes.ConversationClasses;

import com.dialogue.dialogue.models.classes.Result;

public class GetConversationsResult extends Result {
    Conversation conversations[];

    public GetConversationsResult(int errorCode, String errorMessage, Conversation[] conversations) {
        super(errorCode, errorMessage);
        this.conversations = conversations;
    }

    public Conversation[] getConversations() {
        return conversations;
    }

    public void setConversations(Conversation[] conversations) {
        this.conversations = conversations;
    }
}
