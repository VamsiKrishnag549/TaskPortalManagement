package com.nt.dto.task;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import com.nt.enums.Priority;

@Getter
@Setter
public class UpdateTaskRequest {

    private String title;

    private String description;

    private Priority priority;

    private LocalDate dueDate;

}