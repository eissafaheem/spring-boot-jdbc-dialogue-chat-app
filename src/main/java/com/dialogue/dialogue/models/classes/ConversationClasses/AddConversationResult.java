package com.dialogue.dialogue.models.classes.ConversationClasses;

import com.dialogue.dialogue.models.classes.Result;

public class AddConversationResult extends Result {
    boolean isConversationAdded;

    public AddConversationResult(int errorCode, String errorMessage, boolean isConversationAdded) {
        super(errorCode, errorMessage);
        this.isConversationAdded = isConversationAdded;
    }

    public boolean isConversationAdded() {
        return isConversationAdded;
    }

    public void setConversationAdded(boolean conversationAdded) {
        isConversationAdded = conversationAdded;
    }
}
