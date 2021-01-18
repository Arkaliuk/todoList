package com.list.todo.repository;

import com.list.todo.DashBoard;
import com.list.todo.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<TodoItem, Integer> {

    @Query("select t from TodoItem t " +
            "join TodoList l on l.id = t.todoList.id")
    List<TodoItem> getAll();

    @Query("select t from TodoItem t " +
            "join TodoList l on l.id = t.todoList.id " +
            "where t.dueDate =?1")
    List<TodoItem> getAllTasksToday(LocalDate date);

    @Query("select count(t.id) from TodoItem t " +
            "where t.dueDate =?1")
    Integer getNumberTaskToday(LocalDate date);

    @Query("select t from TodoItem t " +
            "join TodoList tl on t.todoList.id = ?1 and t.done=false ")
    List<TodoItem> getListTasksByListIdAndDone(int listId);

    @Query("select t from TodoItem t join TodoList tl on t.todoList.id = ?1")
    List<TodoItem> getListTasksByListId(int listId);

    @Query("select new com.list.todo.DashBoard(tl.id, tl.name, count(t.id)) from TodoItem t " +
            "join TodoList tl on t.todoList.id = tl.id and t.done = false " +
            "where (t.dueDate between ?1 and t.dueDate) group by tl.id")
    List<DashBoard> getTaskLists(LocalDate date);
}
