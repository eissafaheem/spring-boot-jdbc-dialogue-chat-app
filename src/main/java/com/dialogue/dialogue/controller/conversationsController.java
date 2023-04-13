package com.dialogue.dialogue.controller;

import com.dialogue.dialogue.models.classes.CheckIfExistsResult;
import com.dialogue.dialogue.models.classes.ConversationClasses.AddConversationResult;
import com.dialogue.dialogue.models.classes.ConversationClasses.Conversation;
import com.dialogue.dialogue.models.classes.ConversationClasses.DeleteConversationResult;
import com.dialogue.dialogue.models.classes.ConversationClasses.GetConversationsResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class conversationsController {

    @PutMapping("/conversation")
    public AddConversationResult addConversation(@RequestBody Conversation newConversation){
        AddConversationResult addConversationResult = new AddConversationResult(1,"Failure", false);
        try{
            addConversationResult = null;
        }
        catch (Exception e){
            return addConversationResult;
        }

        return addConversationResult;
    }

    @GetMapping("/conversation/exists/{conversationId}")
    public CheckIfExistsResult checkIfConversationExists(@PathVariable String conversationId){
        CheckIfExistsResult checkIfExistsResult = new CheckIfExistsResult(1,"Failure", false);
        try{
            checkIfExistsResult = null;
        }
        catch (Exception e){
            return checkIfExistsResult;
        }

        return checkIfExistsResult;
    }

    @GetMapping("/conversation/{userId}")
    public GetConversationsResult getConversations(@PathVariable String userId){
        GetConversationsResult getConversationsResult = new GetConversationsResult(1, "Failure", new Conversation[]{});
        try{
            getConversationsResult = null;
        }
        catch (Exception e){
            return getConversationsResult;
        }

        return getConversationsResult;
    }

    @DeleteMapping("/conversation/{conversationId}")
    public DeleteConversationResult deleteConversation(@PathVariable String conversationId){
        DeleteConversationResult deleteConversationResult = new DeleteConversationResult(1, "Failure", false);
        try{
            deleteConversationResult = null;
        }
        catch (Exception e){
            return deleteConversationResult;
        }

        return deleteConversationResult;
    }
}
