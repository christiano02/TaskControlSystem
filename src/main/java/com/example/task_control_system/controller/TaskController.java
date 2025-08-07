package com.example.task_control_system.controller;

import com.example.task_control_system.dto.TaskDTO;
import com.example.task_control_system.entity.Task;
import com.example.task_control_system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<Task> createTask(@PathVariable Long userId, @RequestBody TaskDTO dto) {
        Task task = taskService.createTask(userId, dto);
        return ResponseEntity.ok(task);
    }
    @GetMapping("/teste")
    public String test(){
        return "teste on";
    }


    @GetMapping("/list")
    public List<TaskDTO> taskDTOList(){
        return taskService.listTask();
    }
}
