package com.example.commonweb.Post;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment>, QueryByExampleExecutor<Comment> {

//    @EntityGraph(value = "Comment.post")
    @EntityGraph(attributePaths = "post")
    Comment getById(Long id);

    @Transactional(readOnly = true)
    <T> List<T> findByPostId(Long id, Class<T> type);
}
