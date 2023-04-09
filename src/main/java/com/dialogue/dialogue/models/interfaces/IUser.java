package com.dialogue.dialogue.models.interfaces;

public interface IUser {
    public String getUserId();

    public void setUserId(String userId);

    public String getUserName();

    public void setUserName(String userName);

    public String getPasswordHash();

    public void setPasswordHash(String passwordHash);
}
