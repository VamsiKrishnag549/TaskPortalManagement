package com.nt.dto.task;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import com.nt.enums.Priority;
import com.nt.enums.TaskStatus;

@Getter
@Setter
public class TaskRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private Priority priority;

    private LocalDate dueDate;

    private TaskStatus status;

}
