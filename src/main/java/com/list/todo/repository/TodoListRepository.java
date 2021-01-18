package com.list.todo.repository;

import com.list.todo.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface TodoListRepository extends JpaRepository<TodoList, Integer> {

    @Query("select tl from TodoList tl")
    List<TodoList> getAllLists();
}
