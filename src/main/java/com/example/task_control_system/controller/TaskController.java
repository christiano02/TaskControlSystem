package com.example.task_control_system.controller;

import com.example.task_control_system.dto.TaskDTO;
import com.example.task_control_system.entity.Task;
import com.example.task_control_system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(name="/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<Task> createTask(@PathVariable Long userId, @RequestBody TaskDTO dto) {
        Task task = taskService.createTask(userId, dto);
        return ResponseEntity.ok(task);
    }
    @GetMapping("/task/listTasks")
    public List<TaskDTO> taskDTOList(){
        return taskService.listTask();
    }
}
