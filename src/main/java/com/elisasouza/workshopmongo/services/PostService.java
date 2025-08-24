package com.elisasouza.workshopmongo.services;

import com.elisasouza.workshopmongo.domain.Post;
import com.elisasouza.workshopmongo.repository.PostRepository;
import com.elisasouza.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }


}
