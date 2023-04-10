package com.dialogue.dialogue.services;

import com.dialogue.dialogue.dao.UserDao;
import com.dialogue.dialogue.models.classes.CheckUserExistsResult;
import com.dialogue.dialogue.models.classes.Result;
import com.dialogue.dialogue.models.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Result addUser(User newUser){
        return userDao.addUser(newUser);
    }

    public CheckUserExistsResult checkIfUserExists(String userId){
        return userDao.checkIfUserExists(userId);
    }

}
