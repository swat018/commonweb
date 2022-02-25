package com.example.commonweb.Post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.commonweb.Post.CommentSpecs.isBest;
import static com.example.commonweb.Post.CommentSpecs.isGood;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository comments;

    @Autowired
    PostRepository posts;

    @Test
    public void getComment() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = posts.save(post);

        Comment comment = new Comment();
        comment.setComment("spring data jpa projection");
        comment.setPost(savedPost);
        comment.setUp(10);
        comment.setDown(1);
        comments.save(comment);

        comments.findByPostId(savedPost.getId(), CommentSummary.class).forEach(c -> {
            System.out.println("======================");
            System.out.println(c.getVotes());
        });

//        comments.findByPostId(savedPost.getId(), CommentOnly.class).forEach(c -> {
//            System.out.println("======================");
//            System.out.println(c.getComment());
//        });
    }

    @Test
    public void specs() {
//        comments.findAll(CommentSpecs.isBest());

        comments.findAll(isBest().or(isGood()));

        Page<Comment> paqqqge = comments.findAll(isBest().or(isGood()), PageRequest.of(0,10));
    }

    @Test
    public void qbe() {
        Comment prove = new Comment();
        prove.setBest(true);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                .withIgnorePaths("up", "down");

        Example<Comment> example = Example.of(prove, exampleMatcher);

        comments.findAll(example);
    }
}