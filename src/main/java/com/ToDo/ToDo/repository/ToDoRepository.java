package com.ToDo.ToDo.repository;

import com.ToDo.ToDo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ToDoRepository extends JpaRepository<ToDo, UUID> {
}