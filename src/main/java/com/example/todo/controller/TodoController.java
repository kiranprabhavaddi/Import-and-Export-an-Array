/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.util.ArrayList;
import com.example.todo.service.TodoJpaService;
import com.example.todo.model.Todo;

@RestController
public class TodoController {

  @Autowired
  public TodoJpaService todoService;

  @GetMapping("/todos")
  public ArrayList<Todo> getAllTodos() {
    return todoService.getTodos();
  }

  @PostMapping("/todos")
  public Todo addTodo(@RequestBody Todo todo) {
    return todoService.addTodo(todo);

  }

  @GetMapping("/todos/{id}")
  public Todo getTodoById(@PathVariable("id") int id) {
    return todoService.getTodoById(id);
  }

  @PutMapping("/todos/{id}")
  public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
    return todoService.updateTodo(id, todo);
  }

  @DeleteMapping("/todos/{id}")
  public void deleteTodo(@PathVariable("id") int id) {
    todoService.deleteTodo(id);
  }
}
