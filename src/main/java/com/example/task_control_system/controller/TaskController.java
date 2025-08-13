package com.example.task_control_system.controller;

import com.example.task_control_system.dto.TaskDTO;
import com.example.task_control_system.entity.Task;
import com.example.task_control_system.repository.TaskRepository;
import com.example.task_control_system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<TaskDTO> createTask(@PathVariable Long userId, @RequestBody TaskDTO dto) {
        TaskDTO task = taskService.createTask(userId, dto);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/list/{userId}")
    public List<TaskDTO> taskDTOListById(@PathVariable Long userId){
        return taskService.listTaskByUserId(userId);
    }


    @GetMapping("/list")
    public List<TaskDTO> taskDTOList(){
        return taskService.listTask();
    }

    @PutMapping("/update/{id}")
    public TaskDTO updateTask(@PathVariable Long id, @RequestBody TaskDTO updateTask){
        return taskService.updateTaskDTO(id, updateTask);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


}
