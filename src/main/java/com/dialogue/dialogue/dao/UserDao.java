package com.dialogue.dialogue.dao;

import com.dialogue.dialogue.models.classes.CheckUserExistsResult;
import com.dialogue.dialogue.models.classes.Result;
import com.dialogue.dialogue.models.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createUserTable(){
        String query = "CREATE TABLE IF NOT EXISTS USER( USERID VARCHAR(255) PRIMARY KEY, USERNAME VARCHAR(255), PASSWORDHASH VARCHAR(255));";
        int rowsAffected = jdbcTemplate.update(query);

        return rowsAffected;
    }

    public CheckUserExistsResult checkIfUserExists(String userId){
        CheckUserExistsResult checkUserExistsResult = new CheckUserExistsResult(1, "Failure", false);

        try{
            String query = "SELECT COUNT(*) FROM USER WHERE USERID = ?";
            int result = jdbcTemplate.queryForObject(query, Integer.class, userId);
            checkUserExistsResult.setErrorCode(0);
            checkUserExistsResult.setErrorMessage("Success");
            if(result>0){
                checkUserExistsResult.setUserExists(true);
            }
            else{
                checkUserExistsResult.setUserExists(false);
            }
        }
        catch(Exception e){
            return checkUserExistsResult;
        }

        return checkUserExistsResult;
    }

    public Result addUser(User newUser){

        Result result = new Result(1, "Failure");
        int userTableCreation = this.createUserTable();
        try{
            CheckUserExistsResult userExists = this.checkIfUserExists((newUser.getUserId()));

            int rowsAffected = 0;
            if(!userExists.isUserExists()){
                String query = "INSERT INTO USER VALUES('"+newUser.getUserId()+"', '"+newUser.getUserName()+"', '"+newUser.getPasswordHash()+"')";
                rowsAffected = jdbcTemplate.update(query);
                if(rowsAffected!=0){
                    result.setErrorCode(0);
                    result.setErrorMessage("Success");
                }
            }
        }
        catch(Exception e){
            return result;
        }

        return result;
    }
}
