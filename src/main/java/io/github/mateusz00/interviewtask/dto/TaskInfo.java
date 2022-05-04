package io.github.mateusz00.interviewtask.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.mateusz00.interviewtask.model.TaskStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TaskInfo(Long id, TaskStatus status, Integer progress, Double result) {
}
