package com.nt.dto.ai;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AiTaskResponse {

    private String description;
    private String priority;
    private String estimatedTime;

}
