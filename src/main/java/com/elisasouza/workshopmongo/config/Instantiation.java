package com.elisasouza.workshopmongo.config;

import com.elisasouza.workshopmongo.domain.Post;
import com.elisasouza.workshopmongo.domain.User;
import com.elisasouza.workshopmongo.repository.PostRepository;
import com.elisasouza.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.UUID;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository  userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone(ZoneId.of("GMT")));
        userRepository.deleteAll();
        postRepository.deleteAll();

        // Garantir ID como String, porque na versão atual do Spring/Mongo, null gera ObjectId
        User maria = new User(UUID.randomUUID().toString(), "Maria Brown", "maria@gmail.com");
        User alex = new User(UUID.randomUUID().toString(), "Alex Green", "alex@gmail.com");
        User bob = new User(UUID.randomUUID().toString(), "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(UUID.randomUUID().toString(),sdf.parse("21/03/2018"),"Partiu viagem", "vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(UUID.randomUUID().toString(),sdf.parse("23/03/2018"),"Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria,alex,bob));
        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
