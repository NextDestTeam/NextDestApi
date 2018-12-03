package com.happy.Controllers;

import com.happy.DTO.PersonActivityCommentDTO;
import com.happy.Models.PersonActivityComment;
import com.happy.Services.PersonActivityCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonActivityCommentController {
    @Autowired
    private PersonActivityCommentService commentService;

    @GetMapping("/comments")
    public List<PersonActivityComment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/comment/{id}")
    public PersonActivityComment getComment(@PathVariable Integer id){
        return commentService.getCommentById(id);
    }

    @PostMapping("/comments")
    public PersonActivityComment newComment(@RequestBody PersonActivityCommentDTO comment){
        return commentService.addNewComment(comment);
    }

    @PutMapping("/comment/{id}")
    public PersonActivityComment addOrReplaceComent(@RequestBody PersonActivityCommentDTO comment, @PathVariable Integer id){
        return commentService.addOrReplaceComment(comment, id);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
    }
}
