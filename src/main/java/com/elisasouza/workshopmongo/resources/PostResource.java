package com.elisasouza.workshopmongo.resources;

import com.elisasouza.workshopmongo.domain.Post;
import com.elisasouza.workshopmongo.domain.User;
import com.elisasouza.workshopmongo.dto.AuthorDTO;
import com.elisasouza.workshopmongo.dto.UserDTO;
import com.elisasouza.workshopmongo.resources.util.URL;
import com.elisasouza.workshopmongo.services.PostService;
import com.elisasouza.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URLDecoder;
import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }


}
