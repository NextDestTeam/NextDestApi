package com.happy.Services;

import com.happy.DTO.ReactionDTO;
import com.happy.Exceptions.ActivityNotFoundException;
import com.happy.Exceptions.PersonNotFoundException;
import com.happy.Exceptions.ReactionNotFoundException;
import com.happy.Models.Activity;
import com.happy.Models.Person;
import com.happy.Models.Reaction;
import com.happy.Repositories.ActivityRepository;
import com.happy.Repositories.PersonRepository;
import com.happy.Repositories.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReactionService {
    @Autowired
    private ReactionRepository reactionRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<Reaction> getAllReactions(){
        return reactionRepository.findAll();
    }

    public Reaction getReactionById(Integer id){
        return reactionRepository.findById(id)
                .orElseThrow(() -> new ReactionNotFoundException(id));
    }

    public Reaction newReaction(ReactionDTO newReaction){
        return getReaction(newReaction);
    }

    public Reaction addOrReplaceReaction(ReactionDTO newReaction, Integer id){
        return reactionRepository.findById(id)
                .map(reaction -> {
                    reaction.setReaction(newReaction.getReaction());
                    return reactionRepository.save(reaction);
                }).orElseGet(() -> {
                    return getReaction(newReaction);
                });
    }

    public void deleteReactionById(Integer id){
        reactionRepository.deleteById(id);
    }

    private Reaction getReaction(ReactionDTO newReaction) {
        Reaction reaction = new Reaction();
        Activity activity = activityRepository.findById(newReaction.getActivityReactionId())
                .orElseThrow(() -> new ActivityNotFoundException(newReaction.getActivityReactionId()));
        Person person = personRepository.findById(newReaction.getPersonReactionId())
                .orElseThrow(() -> new PersonNotFoundException(newReaction.getPersonReactionId()));

        reaction.setReaction(newReaction.getReaction());
        reaction.setActivityReactionId(activity);
        reaction.setPersonReactionId(person);

        return reactionRepository.save(reaction);
    }
}
