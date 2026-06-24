package com.nt.service.impl;

import com.nt.dto.ai.AiTaskResponse;
import com.nt.exception.AiServiceException;
import com.nt.service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GeminiServiceImpl implements GeminiService {

    private final RestTemplate restTemplate;

    @Value("${gemini.api.key}")
    private String apiKey;

    @Override
    public AiTaskResponse generateTaskDetails(String title) {

        try {

            String prompt = """
                    Generate:
                    1. Task Description
                    2. Priority (LOW, MEDIUM, HIGH)
                    3. Estimated Completion Time

                    Task Title:
                    %s

                    Format:

                    Description:
                    Priority:
                    Estimated Time:
                    """.formatted(title);

            String url =
                    "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                            + apiKey;

            Map<String, Object> requestBody = Map.of(
                    "contents",
                    List.of(
                            Map.of(
                                    "parts",
                                    List.of(
                                            Map.of("text", prompt)
                                    )
                            )
                    )
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> entity =
                    new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(
                            url,
                            entity,
                            Map.class
                    );

            Map body = response.getBody();

            List candidates =
                    (List) body.get("candidates");

            Map candidate =
                    (Map) candidates.get(0);

            Map content =
                    (Map) candidate.get("content");

            List parts =
                    (List) content.get("parts");

            Map part =
                    (Map) parts.get(0);

            String text =
                    part.get("text").toString();

            return new AiTaskResponse(
                    text,
                    "MEDIUM",
                    "2 Hours"
            );

        } catch (Exception e) {

            throw new AiServiceException(
                    "Failed to generate AI task details"
            );
        }
    }
}
