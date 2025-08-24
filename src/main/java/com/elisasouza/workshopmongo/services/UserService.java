package com.elisasouza.workshopmongo.services;

import com.elisasouza.workshopmongo.domain.User;
import com.elisasouza.workshopmongo.dto.UserDTO;
import com.elisasouza.workshopmongo.repository.UserRepository;
import com.elisasouza.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User>findAll(){
        return userRepository.findAll();
    }

    // findById retorna Optional agora em vez de null, garantindo tratamento seguro quando o usuário não existe. finOne não é mais usado.
    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
