package com.ToDo.ToDo.dto;

import com.ToDo.ToDo.model.ToDo;

import java.util.UUID;

public record ToDoResponse(UUID id, String content, boolean completed) {

    public static ToDoResponse from(ToDo todo) {
        return new ToDoResponse(todo.getId(), todo.getContent(), todo.isCompleted());
    }
}