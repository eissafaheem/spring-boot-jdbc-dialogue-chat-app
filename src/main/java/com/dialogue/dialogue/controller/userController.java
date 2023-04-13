package com.dialogue.dialogue.controller;

import com.dialogue.dialogue.models.classes.UserClasses.AddUserResult;
import com.dialogue.dialogue.models.classes.CheckIfExistsResult;
import com.dialogue.dialogue.models.classes.UserClasses.GetUserResult;
import com.dialogue.dialogue.models.classes.UserClasses.User;
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
    public AddUserResult addUser(@RequestBody User newUser){
        AddUserResult addUserResult = new AddUserResult(1, "Failure", false);
        CheckIfExistsResult checkUserExistsResult = new CheckIfExistsResult(1, "Failure", false);
        try{
            checkUserExistsResult = userService.checkIfUserExists(newUser.getUserId());
            if(checkUserExistsResult.getErrorCode() == 0 && !checkUserExistsResult.isExists()){
                addUserResult = userService.addUser(newUser);
            }
            else if(checkUserExistsResult.getErrorCode() == 0 && checkUserExistsResult.isExists()){
                addUserResult.setErrorCode(0);
                addUserResult.setErrorMessage("User already exists");
            }
        }
        catch(Exception e){
            return addUserResult;
        }
        return addUserResult;
    }

    @GetMapping("/user/exists/{userId}")
    public CheckIfExistsResult checkIfUserExists(@PathVariable String userId){
        CheckIfExistsResult checkUserExistsResult = new CheckIfExistsResult(1, "Failure", false);
        try{
            return userService.checkIfUserExists(userId);
        }
        catch(Exception e){
            return checkUserExistsResult;
        }
    }

    @GetMapping("/user/{userId}")
    public GetUserResult getUser(@PathVariable String userId){

        GetUserResult getUserResult = new GetUserResult(1,"Failure", new User());
        CheckIfExistsResult checkUserExistsResult = new CheckIfExistsResult(1, "Failure", false);
        try{
            checkUserExistsResult = userService.checkIfUserExists(userId);
            if(checkUserExistsResult.getErrorCode()==0 &&  checkUserExistsResult.isExists()){
                getUserResult = userService.getUser(userId);
            }
            else if(checkUserExistsResult.getErrorCode()==0 && !checkUserExistsResult.isExists()){
                getUserResult.setErrorCode(0);
                getUserResult.setErrorMessage("User does not exists");
            }

        }
        catch(Exception e){
            return getUserResult;
        }

        return getUserResult;
    }
}
