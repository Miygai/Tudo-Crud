package com.ToDo.ToDo.dto;

import jakarta.validation.constraints.NotBlank;

public record ToDoRequest(
        @NotBlank(message = "content nu poate fi gol")
        String content,
        boolean completed
) {
}