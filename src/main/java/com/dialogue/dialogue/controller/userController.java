package com.dialogue.dialogue.controller;

import com.dialogue.dialogue.models.classes.CheckUserExistsResult;
import com.dialogue.dialogue.models.classes.Result;
import com.dialogue.dialogue.models.classes.User;
import com.dialogue.dialogue.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {

    @Autowired
    UserService userService;

    @GetMapping("/health")
    public String health(){
        return "Application is running.";
    }

    @PutMapping("/user")
    public Result addUser(@RequestBody User newUser){
        Result result = new Result(1, "Failure");
        try{
            result = userService.addUser(newUser);
        }
        catch(Exception e){
            return result;
        }
        return result;
    }

    @GetMapping("/user/exists/{userId}")
    public CheckUserExistsResult checkIfUserExists(@PathVariable String userId){
        CheckUserExistsResult checkUserExistsResult = new CheckUserExistsResult(1, "Failure", false);
        try{
            return userService.checkIfUserExists(userId);
        }
        catch(Exception e){
            return checkUserExistsResult;
        }
    }
}
