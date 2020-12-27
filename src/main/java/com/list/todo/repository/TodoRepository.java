package com.list.todo.repository;

import com.list.todo.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TodoRepository extends JpaRepository<TodoItem, Integer> {
    @Query(value = "select * from todo_item", nativeQuery = true)
    List<TodoItem> getAll();
}
