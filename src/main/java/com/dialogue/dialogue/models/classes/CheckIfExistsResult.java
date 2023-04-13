package com.dialogue.dialogue.models.classes;

public class CheckIfExistsResult extends Result {
    boolean isExists;

    public CheckIfExistsResult(int errorCode, String errorMessage, boolean isExists) {
        super(errorCode, errorMessage);
        this.isExists = isExists;
    }

    public boolean isExists() {
        return isExists;
    }

    public void setExists(boolean exists) {
        this.isExists = exists;
    }
}
