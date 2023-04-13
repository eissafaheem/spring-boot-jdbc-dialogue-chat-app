package com.dialogue.dialogue.models.classes.UserClasses;

import com.dialogue.dialogue.models.classes.Result;

public class GetUserResult extends Result {
    User user;

    public GetUserResult(int errorCode, String errorMessage, User user) {
        super(errorCode, errorMessage);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
