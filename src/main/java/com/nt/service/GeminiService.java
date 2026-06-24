package com.nt.service;

import com.nt.dto.ai.AiTaskResponse;

public interface GeminiService {

    AiTaskResponse generateTaskDetails(String title);

}
