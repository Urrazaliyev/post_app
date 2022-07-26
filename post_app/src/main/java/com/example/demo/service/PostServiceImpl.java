package com.example.demo.service;

import com.example.demo.model.PostModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{
    private static final HashMap<String, PostModel> postMap= new HashMap<>();
    static{
        PostModel post1= new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Glass", "sent"),
                post2= new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Phone", "recieved"),
                post3= new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "T-Shirt", "unknown");
        postMap.put(post1.getPostId(),post1);
        postMap.put(post2.getPostId(),post2);
        postMap.put(post3.getPostId(),post3);
    }

    @Override
    @GetMapping
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        postModel.setPostRecipentId(UUID.randomUUID().toString());
        postModel.setClientId(UUID.randomUUID().toString());
        postMap.put(postModel.getPostId(),postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public PostModel getPostById(String id) {
        return postMap.get(id);
    }

    @Override
    public void updatePostById(String id, PostModel postModel) {
        postModel.setPostId(id);
        postMap.put(id,postModel);
    }

    @Override
    public void deletePostById(String id) {
        postMap.remove(id);
    }
}
