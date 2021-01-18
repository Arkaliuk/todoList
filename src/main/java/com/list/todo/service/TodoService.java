package com.list.todo.service;

import com.list.todo.DashBoard;
import com.list.todo.DashBoardInfo;
import com.list.todo.entity.TodoItem;
import com.list.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    LocalDate localDate = LocalDate.now();
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> getAllTasks() {
        return todoRepository.getAll();
    }

    public DashBoardInfo getDashboard(boolean done) {
        Integer numberTaskToday = todoRepository.getNumberTaskToday(localDate);
        List<DashBoard> listTasksToday = todoRepository.getTaskLists(localDate);
        return new DashBoardInfo(numberTaskToday, listTasksToday);
    }

    public List<TodoItem> getAllTasksToday() {
        return todoRepository.getAllTasksToday(localDate);
    }

    public List<TodoItem> getTasksByListIdAndDone(int listId, boolean all) {
        if (all) {
        return todoRepository.getListTasksByListId(listId);
        } else
            return todoRepository.getListTasksByListIdAndDone(listId);
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
