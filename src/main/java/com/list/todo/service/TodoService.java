package com.list.todo.service;


import com.list.todo.entity.TodoItem;
import com.list.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> getAllTasks() {
        return todoRepository.getAll();
    }

    public Optional<TodoItem> getTaskById(int id) {
        return todoRepository.findById(id);
    }

    public TodoItem addTask(TodoItem todoItem) {
        if (todoItem.getDateOfCreation() == null) {
            todoItem.setDateOfCreation(LocalDate.now());
        }
        return todoRepository.save(todoItem);
    }

    public void deleteTaskById(int id) {
        todoRepository.deleteById(id);
    }

    public TodoItem updateTask(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }
}
