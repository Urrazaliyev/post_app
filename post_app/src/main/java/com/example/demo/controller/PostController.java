package com.example.demo.controller;
import com.example.demo.model.PostModel;
import com.example.demo.service.PostService;
import com.example.demo.service.PostServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {
    private final PostServiceImpl postService;

    @PostMapping("/")
    public ResponseEntity<String> createPost(@RequestBody PostModel postModel){
        postService.createPost(postModel);
        return new ResponseEntity<String>("Successfully created!", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostModel> getAll(){
        return postService.getAllPosts();
    }
    @GetMapping("/{id}")
    public PostModel getPostById(@PathVariable String id){
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable String id, @RequestBody PostModel postModel){
        postService.updatePostById(id,postModel);
        return new ResponseEntity<String>("Successfully updated!", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id){
        postService.deletePostById(id);
        return new ResponseEntity<String>("Successfully deleted!", HttpStatus.OK);
    }




}
