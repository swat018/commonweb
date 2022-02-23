package com.example.commonweb.Post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommmentRepositoryTest {

    @Autowired
    CommmentRepository comments;

    @Test
    public void getComment() {
        comments.getById(1l);

        System.out.println("============================");

        comments.findById(1L);
    }
}