package com.production.prod_ready_features.controllers;

import com.production.prod_ready_features.dto.PostDTO;
import com.production.prod_ready_features.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }
    @PostMapping
    public PostDTO CreateNewPost(@RequestBody PostDTO inputPost){
        return postService.createNewPost(inputPost);
    }
    @GetMapping("/{postId}")
    public PostDTO getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public PostDTO updatePostById(@RequestBody PostDTO inputPost,
                                  @PathVariable Long postId){
        return postService.updatePostById(inputPost,postId);
    }
}
