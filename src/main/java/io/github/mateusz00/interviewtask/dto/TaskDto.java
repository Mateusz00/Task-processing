package io.github.mateusz00.interviewtask.dto;

import javax.validation.constraints.NotNull;

public record TaskDto(@NotNull Double base, @NotNull Double exponent) {
}
