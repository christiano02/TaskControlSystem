package com.example.task_control_system.service;

import com.example.task_control_system.dto.UserDTO;
import com.example.task_control_system.entity.User;
import com.example.task_control_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
