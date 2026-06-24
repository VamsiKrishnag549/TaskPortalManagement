package com.nt.dto.task;

import com.nt.enums.TaskStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskStatusUpdateRequest {

    private TaskStatus status;

}