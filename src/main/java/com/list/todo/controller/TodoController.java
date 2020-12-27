package com.list.todo.controller;

import com.list.todo.entity.TodoItem;
import com.list.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {


    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @CrossOrigin
    @GetMapping
    public List<TodoItem> getAllTasks() {
        return todoService.getAllTasks();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<TodoItem> getTaskById(@PathVariable int id) {
        return todoService.getTaskById(id);

    }

    @CrossOrigin
    @PostMapping("/add")
    public TodoItem addTask(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoService.addTask(todoItem);

    }

    @CrossOrigin
    @PutMapping(value = "/{id}")
    public TodoItem updateTask(@RequestBody TodoItem todoItem, @PathVariable int id) {

        todoService.getTaskById(id)
                .map(item -> {
                    item.setTitle(todoItem.getTitle());
                    item.setDescription(todoItem.getDescription());
                    item.setDone(todoItem.isDone());
                    item.setDueDate(todoItem.getDueDate());
                    return todoService.updateTask(item);

                })
                .orElseGet(() -> {
                    todoItem.setId(id);
                    return todoService.updateTask(todoItem);
                });
        return null;
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable int id) {
        todoService.deleteTaskById(id);
    }
}
