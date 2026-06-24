package com.nt.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.nt.dto.ai.AiTaskRequest;
import com.nt.dto.ai.AiTaskResponse;
import com.nt.service.GeminiService;
import com.nt.util.ApiResponse;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AiController {

    private final GeminiService geminiService;

    @PostMapping("/generate")
    public ApiResponse<AiTaskResponse> generateTaskDetails(
            @Valid @RequestBody AiTaskRequest request) {

        return new ApiResponse<>(
                true,
                "AI task details generated successfully",
                geminiService.generateTaskDetails(
                        request.getTitle()
                )
        );
    }
}
