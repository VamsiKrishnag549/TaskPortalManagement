package com.nt.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.nt.dto.task.TaskRequest;
import com.nt.dto.task.TaskResponse;
import com.nt.dto.task.TaskStatusUpdateRequest;
import com.nt.dto.task.UpdateTaskRequest;
import com.nt.service.TaskService;
import com.nt.util.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ApiResponse<TaskResponse> createTask(
            @Valid @RequestBody TaskRequest request) {

        return new ApiResponse<>(
                true,
                "Task created successfully",
                taskService.createTask(request)
        );
    }

    @GetMapping
    public ApiResponse<List<TaskResponse>> getAllTasks() {

        return new ApiResponse<>(
                true,
                "Tasks fetched successfully",
                taskService.getAllTasks()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<TaskResponse> getTaskById(
            @PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Task fetched successfully",
                taskService.getTaskById(id)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<TaskResponse> updateTask(
            @PathVariable Long id,
            @RequestBody UpdateTaskRequest request) {

        return new ApiResponse<>(
                true,
                "Task updated successfully",
                taskService.updateTask(id, request)
        );
    }

    @PatchMapping("/{id}/status")
    public ApiResponse<TaskResponse> updateStatus(
            @PathVariable Long id,
            @RequestBody TaskStatusUpdateRequest request) {

        return new ApiResponse<>(
                true,
                "Task status updated successfully",
                taskService.updateTaskStatus(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteTask(
            @PathVariable Long id) {

        taskService.deleteTask(id);

        return new ApiResponse<>(
                true,
                "Task deleted successfully",
                null
        );
    }
}
