package com.ToDo.ToDo.dto.service;

import com.ToDo.ToDo.dto.ToDoRequest;
import com.ToDo.ToDo.dto.ToDoResponse;
import com.ToDo.ToDo.model.ToDo;
import com.ToDo.ToDo.repository.ToDoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository todoRepository;

    public List<ToDoResponse> findAll() {
        return todoRepository.findAll().stream()
                .map(ToDoResponse::from)
                .toList();
    }

    public ToDoResponse findById(UUID id) {
        return ToDoResponse.from(getTodo(id));
    }

    @Transactional
    public ToDoResponse create(ToDoRequest request) {
        ToDo todo = new ToDo();
        todo.setContent(request.content());
        todo.setCompleted(request.completed());
        return ToDoResponse.from(todoRepository.save(todo));
    }

    @Transactional
    public ToDoResponse update(UUID id, ToDoRequest request) {
        ToDo todo = getTodo(id);
        todo.setContent(request.content());
        todo.setCompleted(request.completed());
        return ToDoResponse.from(todoRepository.save(todo));
    }

    @Transactional
    public void delete(UUID id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Not Found");
        }
        todoRepository.deleteById(id);
    }

    private ToDo getTodo(UUID id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }
}