package com.dialogue.dialogue.models.classes.ConversationClasses;

import com.dialogue.dialogue.models.classes.Result;

public class DeleteConversationResult extends Result {
    boolean isUserDeleted;

    public DeleteConversationResult(int errorCode, String errorMessage, boolean isUserDeleted) {
        super(errorCode, errorMessage);
        this.isUserDeleted = isUserDeleted;
    }

    public boolean isUserDeleted() {
        return isUserDeleted;
    }

    public void setUserDeleted(boolean userDeleted) {
        isUserDeleted = userDeleted;
    }
}
