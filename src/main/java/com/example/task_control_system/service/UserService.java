package com.example.task_control_system.service;

import com.example.task_control_system.dto.UserDTO;
import com.example.task_control_system.entity.User;
import com.example.task_control_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
            User userExisting = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            return new UserDTO(userExisting);
    }
    public User createUser(UserDTO dto){

        User existing = userRepository.findByUserName(dto.getName());
        if(Objects.nonNull(existing)){
            throw new RuntimeException("Existing User");
        }
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto .getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setProfile(dto.getProfile());

        return new User(user.getId(), user.getName(), user.getEmail(),user.getPassword(), user.getProfile());
    }
}
