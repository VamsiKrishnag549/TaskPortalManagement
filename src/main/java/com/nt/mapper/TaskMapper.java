package com.nt.mapper;

import com.nt.dto.task.TaskResponse;
import com.nt.entity.Task;

public class TaskMapper {

    private TaskMapper() {
    }

    public static TaskResponse toResponse(Task task) {

        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .priority(task.getPriority())
                .dueDate(task.getDueDate())
                .status(task.getStatus())
                .estimatedTime(task.getEstimatedTime())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }
}
