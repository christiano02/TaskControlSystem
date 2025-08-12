package com.example.task_control_system.dto;

import com.example.task_control_system.entity.Task;

public class TaskDTO {

    private Long id;
    private String title;
    private String description;

    public TaskDTO(){
    }

    public TaskDTO(Task entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
