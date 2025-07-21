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

/**
 * Classe de serviço responsável por conter a lógica de negócios relacionada às tarefas (Tasks).
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Cria uma nova tarefa associada a um usuário existente.
     * Define status inicial como PENDING e registra a data de criação.
     *
     * @param userId ID do usuário ao qual a tarefa será atribuída.
     * @param dto Objeto contendo os dados da tarefa.
     * @return Objeto Task salvo no banco de dados.
     */
    @Transactional //@Transactional para permitir escrita
    public Task createTask(Long userId, TaskDTO dto) {
        // Busca o usuário associado à tarefa
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Cria e popula os campos da nova tarefa
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(EnumStatus.PENDING);
        task.setUser(existingUser);
        task.setCreationDate(LocalDateTime.now());

        // Salva e retorna a tarefa
        return taskRepository.save(task);
    }

    /**
     * Lista todas as tarefas existentes, convertendo cada entidade Task em um DTO.
     *
     * @return Lista de TaskDTOs representando todas as tarefas.
     */
    @Transactional(readOnly = true)
    public List<TaskDTO> listTask() {
        List<Task> result = taskRepository.findAll();
        return result.stream().map(TaskDTO::new).toList();
    }

    /**
     * Remove uma tarefa com base no seu ID. Lança exceção caso a tarefa não exista.
     *
     * @param id Identificador da tarefa a ser removida.
     */
    @Transactional //@Transactional para permitir exclusão
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found");
        } else {
            taskRepository.deleteById(id);
        }
    }
}

