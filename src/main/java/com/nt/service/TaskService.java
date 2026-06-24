package com.nt.service;

import java.util.List;

import com.nt.dto.task.TaskRequest;
import com.nt.dto.task.TaskResponse;
import com.nt.dto.task.TaskStatusUpdateRequest;
import com.nt.dto.task.UpdateTaskRequest;

public interface TaskService {

    TaskResponse createTask(TaskRequest request);

    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(Long id,
                            UpdateTaskRequest request);

    TaskResponse updateTaskStatus(
            Long id,
            TaskStatusUpdateRequest request
    );

    void deleteTask(Long id);

}
