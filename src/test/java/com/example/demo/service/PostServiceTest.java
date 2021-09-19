package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceImpl.PostServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class PostServiceTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    void shouldDisplayAllPostsSuccessfully() {
        User user = new User();
        User user1 = new User();
        List<Post> posts = List.of(
                new Post("hello", "greeting", LocalDate.now(), LocalTime.now(), LocalDateTime.now(), user),
                new Post("hi", "bye", LocalDate.now(), LocalTime.now(), LocalDateTime.now(), user1)
        );

        given(postRepository.findAll()).willReturn(posts);
        List<Post> postList = postService.displayAllPosts();
        assertThat(postList).isEqualTo(posts);


    }
}