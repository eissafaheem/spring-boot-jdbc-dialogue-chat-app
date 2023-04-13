package com.dialogue.dialogue.services;

import com.dialogue.dialogue.dao.UserDao;
import com.dialogue.dialogue.models.classes.UserClasses.AddUserResult;
import com.dialogue.dialogue.models.classes.CheckIfExistsResult;
import com.dialogue.dialogue.models.classes.UserClasses.GetUserResult;
import com.dialogue.dialogue.models.classes.UserClasses.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public AddUserResult addUser(User newUser){
        return userDao.addUser(newUser);
    }

    public CheckIfExistsResult checkIfUserExists(String userId){
        return userDao.checkIfUserExists(userId);
    }

    public GetUserResult getUser(String userId){
        return userDao.getUser(userId);
    }
}
