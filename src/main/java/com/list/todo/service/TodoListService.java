package com.list.todo.service;

import com.list.todo.entity.TodoItem;
import com.list.todo.entity.TodoList;
import com.list.todo.repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public List<TodoList> getAllLists() {
        return todoListRepository.getAllLists();
    }

    public Optional<TodoList> getListById(int id) {
        return todoListRepository.findById(id);
    }

    public TodoList addList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    public void deleteListById(int id) {
        todoListRepository.deleteById(id);
    }

    public TodoList updateTask(TodoList todoList) {
        return todoListRepository.save(todoList);
    }
}
