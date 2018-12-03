package com.happy.Controllers;

import com.happy.DTO.ReactionDTO;
import com.happy.Models.Reaction;
import com.happy.Services.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReactionController {
    @Autowired
    private ReactionService reactionService;

    @GetMapping("/reactions")
    public List<Reaction> getAllReactions(){
        return reactionService.getAllReactions();
    }

    @GetMapping("/reaction/{id}")
    public Reaction getReactionById(@PathVariable Integer id){
        return reactionService.getReactionById(id);
    }

    @PostMapping("/reactions")
    public Reaction newReaction(@RequestBody ReactionDTO reaction){
        return reactionService.newReaction(reaction);
    }

    @PutMapping("/reaction/{id}")
    public Reaction addOrReplaceReaction(@RequestBody ReactionDTO reaction, @PathVariable Integer id){
        return reactionService.addOrReplaceReaction(reaction, id);
    }

    @DeleteMapping("/reaction/{id}")
    public void deleteReaction(@PathVariable Integer id){
        reactionService.deleteReactionById(id);
    }
}
