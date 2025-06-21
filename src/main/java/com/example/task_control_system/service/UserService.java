package com.example.task_control_system.service;

import com.example.task_control_system.dto.UserDTO;
import com.example.task_control_system.entity.User;
import com.example.task_control_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){

            User user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            return new UserDTO(user);
    }

    public User createUser(UserDTO dto){

        User userExisting = userRepository.findByUserName(dto.getUserName());
        if(Objects.nonNull(userExisting)){

            throw new RuntimeException("Existing User");

        }

        User user = new User();

        user.setId(dto.getId());
        user.setName(dto .getName());
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setProfile(dto.getProfile());

        return new User(user.getId(), user.getName(), user.getEmail(), user.getUserName(), user.getPassword(), user.getProfile());
        
    }

    public User updateUser(Long id, UserDTO dto){

        User userUpdate = userRepository.findById(id).orElse(null);

        if(Objects.nonNull(userUpdate)){

            userUpdate.setId(dto.getId());
            userUpdate.setName(dto.getName());
            userUpdate.setEmail(dto.getEmail());
            userUpdate.setUserName(dto.getUserName());
            userUpdate.setPassword(dto.getPassword());
            userUpdate.setProfile(dto.getProfile());

            return userRepository.save(userUpdate);

        }

        return null;
    }
}
