package com.example.commonweb.Post;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommmentRepository extends JpaRepository<Comment, Long> {

//    @EntityGraph(value = "Comment.post")
    @EntityGraph(attributePaths = "post")
    Comment getById(Long id);

     List<CommentSummary> findByPost_Id(Long id);
}
