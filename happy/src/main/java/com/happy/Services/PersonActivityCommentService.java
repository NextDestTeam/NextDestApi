package com.happy.Services;

import com.happy.DTO.PersonActivityCommentDTO;
import com.happy.Exceptions.ActivityNotFoundException;
import com.happy.Exceptions.PersonActivityCommentNotFoundException;
import com.happy.Exceptions.PersonNotFoundException;
import com.happy.Models.Activity;
import com.happy.Models.Person;
import com.happy.Models.PersonActivityComment;
import com.happy.Repositories.ActivityRepository;
import com.happy.Repositories.PersonActivityCommentRepository;
import com.happy.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonActivityCommentService {
    @Autowired
    private PersonActivityCommentRepository commentRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private PersonRepository personRepository;

    public List<PersonActivityComment> getAllComments() {
        return commentRepository.findAll();
    }

    public PersonActivityComment getCommentById(Integer id){
        return commentRepository.findById(id)
                .orElseThrow(() -> new PersonActivityCommentNotFoundException(id));
    }

    public PersonActivityComment addNewComment(PersonActivityCommentDTO newComment){
        return getPersonActivityComment(newComment);
    }

    public PersonActivityComment addOrReplaceComment(PersonActivityCommentDTO newComment, Integer id){
        return commentRepository.findById(id)
                .map(comment -> {
                    comment.setComment(newComment.getComment());
                    return commentRepository.save(comment);
                }).orElseGet(() -> {
                    return getPersonActivityComment(newComment);
                });
    }

    public void deleteComment(Integer id){
        commentRepository.deleteById(id);
    }

    private PersonActivityComment getPersonActivityComment(PersonActivityCommentDTO newComment) {
        PersonActivityComment comment = new PersonActivityComment();
        Activity activity = activityRepository.findById(newComment.getActivityId())
                .orElseThrow(() -> new ActivityNotFoundException(newComment.getActivityId()));
        Person person = personRepository.findById(newComment.getPersonId())
                .orElseThrow(() -> new PersonNotFoundException(newComment.getPersonId()));

        comment.setComment(newComment.getComment());
        comment.setActivityId(activity);
        comment.setPersonId(person);

        return commentRepository.save(comment);
    }
}
