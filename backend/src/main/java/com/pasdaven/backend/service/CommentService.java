package com.pasdaven.backend.service;

import com.pasdaven.backend.model.CommentEntity;
import com.pasdaven.backend.model.PostEntity;
import com.pasdaven.backend.repo.CommentRepo;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {

    private final CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public CommentEntity saveComment(CommentEntity comment) {
        return commentRepo.save(comment);
    }

    public CommentEntity getCommentById(Integer commentId) {
        return commentRepo.findById(commentId).get();
    }
    
    public List<CommentEntity> getCommentsByPost(PostEntity post) {
        return commentRepo.findAllByPost(post);
    }

    public void deleteAllComments() {
        commentRepo.deleteAll();
    }

    public void deleteAllByPost(PostEntity post) {
        commentRepo.deleteAllByPost(post);
    }
}
