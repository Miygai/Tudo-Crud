package com.ToDo.ToDo.controller;

import com.ToDo.ToDo.dto.ToDoRequest;
import com.ToDo.ToDo.dto.ToDoResponse;
import com.ToDo.ToDo.dto.service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService todoService;

    @GetMapping
    public List<ToDoResponse> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public ToDoResponse findById(@PathVariable UUID id) {
        return todoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoResponse create(@Valid @RequestBody ToDoRequest request) {
        return todoService.create(request);
    }

    @PutMapping("/{id}")
    public ToDoResponse update(@PathVariable UUID id, @Valid @RequestBody ToDoRequest request) {
        return todoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        todoService.delete(id);
    }
}
