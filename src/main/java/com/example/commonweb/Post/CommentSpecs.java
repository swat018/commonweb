package com.example.commonweb.Post;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CommentSpecs {

    public static Specification<Comment> isBest() {
        return (root, query, builder) -> builder.isTrue(root.get(Comment_.best));
    }

    public static Specification<Comment> isGood() {
        return (root, query, builder) -> builder.greaterThan(root.get(Comment_.up), 10);
    }
}
