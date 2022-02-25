package com.example.commonweb.Post;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {

//    @EntityGraph(value = "Comment.post")
    @EntityGraph(attributePaths = "post")
    Comment getById(Long id);

    <T> List<T> findByPostId(Long id, Class<T> type);
}
