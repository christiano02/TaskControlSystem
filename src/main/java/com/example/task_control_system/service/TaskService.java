package com.example.task_control_system.service;

import com.example.task_control_system.dto.TaskDTO;
import com.example.task_control_system.entity.Task;
import com.example.task_control_system.entity.User;
import com.example.task_control_system.repository.TaskRepository;
import com.example.task_control_system.repository.UserRepository;
import com.example.task_control_system.role.EnumStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Task createTask(Long userId, TaskDTO dto){
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(EnumStatus.PENDING);
        task.setUser(existingUser);
        task.setCreationDate(LocalDateTime.now());

        return taskRepository.save(task);
    }

    @Transactional(readOnly = true)
    public List<TaskDTO> listTask(){
       List<Task> result = taskRepository.findAll();
        return result.stream().map(TaskDTO::new).toList();
    }
}
