package com.dialogue.dialogue.dao;

import com.dialogue.dialogue.models.classes.UserClasses.AddUserResult;
import com.dialogue.dialogue.models.classes.CheckIfExistsResult;
import com.dialogue.dialogue.models.classes.UserClasses.GetUserResult;
import com.dialogue.dialogue.models.classes.UserClasses.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createUserTable(){
        String query = "CREATE TABLE IF NOT EXISTS USER( USERID VARCHAR(255) PRIMARY KEY, USERNAME VARCHAR(255), PASSWORDHASH VARCHAR(255));";
        int rowsAffected = jdbcTemplate.update(query);

        return rowsAffected;
    }

    public CheckIfExistsResult checkIfUserExists(String userId){
        CheckIfExistsResult checkUserExistsResult = new CheckIfExistsResult(1, "Failure", false);

        try{
            String query = "SELECT COUNT(*) FROM USER WHERE USERID = ?";
            int result = jdbcTemplate.queryForObject(query, Integer.class, userId);
            checkUserExistsResult.setErrorCode(0);
            checkUserExistsResult.setErrorMessage("Success");
            if(result>0){
                checkUserExistsResult.setExists(true);
            }
            else{
                checkUserExistsResult.setExists(false);
            }
        }
        catch(Exception e){
            return checkUserExistsResult;
        }

        return checkUserExistsResult;
    }

    public AddUserResult addUser(User newUser){

        AddUserResult addUserResult = new AddUserResult(1, "Failure", false);
        int userTableCreation = this.createUserTable();
        try{
            int rowsAffected = 0;
            String query = "INSERT INTO USER VALUES('"+newUser.getUserId()+"', '"+newUser.getUserName()+"', '"+newUser.getPasswordHash()+"')";
            rowsAffected = jdbcTemplate.update(query);
            if(rowsAffected!=0){
                addUserResult.setErrorCode(0);
                addUserResult.setErrorMessage("Success");
                addUserResult.setUserAdded(true);
            }
        }
        catch(Exception e){
            return addUserResult;
        }

        return addUserResult;
    }

    public GetUserResult getUser(String userId){
        GetUserResult getUserResult = new GetUserResult(1, "Failure", new User());
        String query = "SELECT * FROM USER WHERE USERID = '"+userId+"'";
        try{
            List<User> users = jdbcTemplate.query(query, new BeanPropertyRowMapper<User>(User.class));
            getUserResult.setErrorCode(0);
            getUserResult.setErrorMessage("Success");
            getUserResult.setUser(users.get(0));
        }
        catch(Exception e){
            return getUserResult;
        }

        return getUserResult;
    }
}
