package com.nt.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.nt.dto.task.TaskRequest;
import com.nt.dto.task.TaskResponse;
import com.nt.dto.task.TaskStatusUpdateRequest;
import com.nt.dto.task.UpdateTaskRequest;
import com.nt.entity.Task;
import com.nt.exception.ResourceNotFoundException;
import com.nt.mapper.TaskMapper;
import com.nt.repository.TaskRepository;
import com.nt.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public TaskResponse createTask(TaskRequest request) {

        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .priority(request.getPriority())
                .dueDate(request.getDueDate())
                .status(request.getStatus())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return TaskMapper.toResponse(
                taskRepository.save(task)
        );
    }

    @Override
    public List<TaskResponse> getAllTasks() {

        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }

    @Override
    public TaskResponse getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found"));

        return TaskMapper.toResponse(task);
    }

    @Override
    public TaskResponse updateTask(
            Long id,
            UpdateTaskRequest request) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found"));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());
        task.setUpdatedAt(LocalDateTime.now());

        return TaskMapper.toResponse(
                taskRepository.save(task)
        );
    }

    @Override
    public TaskResponse updateTaskStatus(
            Long id,
            TaskStatusUpdateRequest request) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found"));

        task.setStatus(request.getStatus());
        task.setUpdatedAt(LocalDateTime.now());

        return TaskMapper.toResponse(
                taskRepository.save(task)
        );
    }

    @Override
    public void deleteTask(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found"));

        taskRepository.delete(task);
    }
}
