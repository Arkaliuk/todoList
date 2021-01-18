package com.list.todo.controller;

import com.list.todo.entity.TodoList;
import com.list.todo.service.TodoListService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lists")
public class TodoListController {

    private TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @CrossOrigin
    @GetMapping()
    public List<TodoList> getLists() {
        return todoListService.getAllLists();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<TodoList> getListById(@PathVariable int id) {
        return todoListService.getListById(id);
    }

    @CrossOrigin
    @PostMapping()
    public TodoList addList(@Valid @NotNull @RequestBody TodoList todoList) {
        return todoListService.addList(todoList);
    }

    @CrossOrigin
    @PutMapping(value = "/{id}")
    public TodoList updateList(@RequestBody TodoList todoList, @PathVariable int id) {

        todoListService.getListById(id)
                .map(item -> {
                    item.setId(todoList.getId());
                    item.setName(todoList.getName());
                    return todoListService.updateTask(item);

                })
                .orElseGet(() -> {
                    todoList.setId(id);
                    return todoListService.updateTask(todoList);
                });
        return null;
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void deleteList(@PathVariable int id) {
        todoListService.deleteListById(id);
    }
}
