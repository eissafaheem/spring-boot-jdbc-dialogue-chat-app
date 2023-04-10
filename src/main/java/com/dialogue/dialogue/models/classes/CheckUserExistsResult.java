package com.dialogue.dialogue.models.classes;

public class CheckUserExistsResult extends Result{
    boolean userExists;

    public CheckUserExistsResult(int errorCode, String errorMessage, boolean userExists) {
        super(errorCode, errorMessage);
        this.userExists = userExists;
    }

    public boolean isUserExists() {
        return userExists;
    }

    public void setUserExists(boolean userExists) {
        this.userExists = userExists;
    }
}
