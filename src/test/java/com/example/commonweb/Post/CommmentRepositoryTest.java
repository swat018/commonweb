package com.example.commonweb.Post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommmentRepositoryTest {

    @Autowired
    CommmentRepository comments;

    @Test
    public void getComment() {
        comments.findByPost_Id(1l);
    }
}