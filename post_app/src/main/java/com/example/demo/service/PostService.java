package com.example.demo.service;

import com.example.demo.model.PostModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    void createPost(PostModel postModel);
    List<PostModel> getAllPosts();
    PostModel getPostById(String id);
    void updatePostById(String id, PostModel postModel);
    void deletePostById(String id);
}
