package com.elisasouza.workshopmongo.services;

import com.elisasouza.workshopmongo.domain.Post;
import com.elisasouza.workshopmongo.repository.PostRepository;
import com.elisasouza.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;


    // findById retorna Optional agora em vez de null, garantindo tratamento seguro quando o usuário não existe. finOne não é mais usado.
    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }


}
