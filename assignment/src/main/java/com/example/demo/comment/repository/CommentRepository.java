package com.example.demo.comment.repository;

import com.example.demo.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    int countByPostId(Long postId);
}
