package com.example.task_control_system.controller;

import com.example.task_control_system.dto.TaskDTO;
import com.example.task_control_system.service.TaskService;
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

    //logica para criar uma nova tarefa
    @PostMapping("/create/{userId}")
    public ResponseEntity<TaskDTO> createTask(@PathVariable Long userId, @RequestBody TaskDTO dto) {
        TaskDTO task = taskService.createTask(userId, dto);
        return ResponseEntity.ok(task);
    }

    //logica para listar as tarefas de cada usuario de acordo com seu id
    @GetMapping("/list/{userId}")
    public List<TaskDTO> taskDTOListById(@PathVariable Long userId){
        return taskService.listTaskByUserId(userId);
    }

    //logica para listar todas as tarefas
    @GetMapping("/list")
    public List<TaskDTO> taskDTOList(){
        return taskService.listTask();
    }

    //logica para atualizar tarefas (ainda não finalizado)
    @PutMapping("/update/{id}")
    public TaskDTO updateTask(@PathVariable Long id, @RequestBody TaskDTO updateTask){
        return taskService.updateTaskDTO(id, updateTask);
    }

    //logica para apagar qualquer tarefa de acordo com o seu id (ainda não finalizado)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
