package com.nt.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.nt.enums.Priority;
import com.nt.enums.TaskStatus;

@Getter
@Setter
@Builder
public class TaskResponse {

    private Long id;

    private String title;

    private String description;

    private Priority priority;

    private LocalDate dueDate;

    private TaskStatus status;

    private String estimatedTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
