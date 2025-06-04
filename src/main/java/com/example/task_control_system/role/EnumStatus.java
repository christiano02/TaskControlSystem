package com.example.task_control_system.role;

public enum EnumStatus {
    PENDING("Penging"),COMPLETED("Completed");

    private final String status;

    EnumStatus(String status) {
        this.status = status;
    }
}
