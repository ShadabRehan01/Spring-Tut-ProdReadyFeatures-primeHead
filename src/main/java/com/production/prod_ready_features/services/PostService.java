package com.production.prod_ready_features.services;

import com.production.prod_ready_features.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getAllPosts();
    PostDTO getPostById(Long PostId);
    PostDTO createNewPost(PostDTO inputPost);
    PostDTO updatePostById(PostDTO inputPost, Long postId);
}
