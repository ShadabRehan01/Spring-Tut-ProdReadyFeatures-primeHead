package com.production.prod_ready_features.services;

import com.production.prod_ready_features.dto.PostDTO;
import com.production.prod_ready_features.entities.PostEntity;
import com.production.prod_ready_features.exceptions.ResourceNotFoundExceptions;
import com.production.prod_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(Long postId) {
       PostEntity postEntity=postRepository.findById(postId).orElseThrow(()->
               new ResourceNotFoundExceptions("Post Not found with Id "+postId));
       return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDTO.class);
    }

    @Override
    public PostDTO updatePostById(PostDTO inputPost, Long postId) {
        PostEntity olderPost=postRepository.findById(postId).orElseThrow(()->
                new ResourceNotFoundExceptions("Post Not found with Id "+postId));

        inputPost.setId(postId);
        modelMapper.map(inputPost,olderPost);
        PostEntity savedPostEntity=postRepository.save(olderPost);
        return modelMapper.map(savedPostEntity,PostDTO.class);
    }
}
