package com.dialogue.dialogue.models.classes.UserClasses;

import com.dialogue.dialogue.models.classes.Result;

public class AddUserResult extends Result {
    boolean isUserAdded;

    public AddUserResult(int errorCode, String errorMessage, boolean isUserAdded) {
        super(errorCode, errorMessage);
        this.isUserAdded = isUserAdded;
    }

    public boolean isUserAdded() {
        return isUserAdded;
    }

    public void setUserAdded(boolean userAdded) {
        isUserAdded = userAdded;
    }
}
