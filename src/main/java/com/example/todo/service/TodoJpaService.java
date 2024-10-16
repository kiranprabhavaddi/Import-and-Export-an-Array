/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.todo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.util.ArrayList;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.TodoJpaRepository;
import com.example.todo.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TodoJpaService implements TodoRepository {

  @Autowired
  private TodoJpaRepository todoJpaRepository;

  @Override
  public void deleteTodo(int Id) {
    try {

      todoJpaRepository.deleteById(Id);
    } catch (Exception e) {

      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

  }

  @Override
  public Todo updateTodo(int Id, Todo todo) {
    try {
      Todo newTodo = todoJpaRepository.findById(Id).get();
      if (todo.getTodo() != null) {
        newTodo.setTodo(todo.getTodo());
      }
      if (todo.getStatus() != null) {
        newTodo.setStatus(todo.getStatus());
      }
      if (todo.getPriority() != null) {
        newTodo.setPriority(todo.getPriority());
      }

      todoJpaRepository.save(newTodo);

      return newTodo;

    } catch (Exception e) {

      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

  }

  @Override
  public Todo getTodoById(int Id) {

    try {

      Todo todo = todoJpaRepository.findById(Id).get();
      return todo;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public Todo addTodo(Todo todo) {
    Todo savedTodo = todoJpaRepository.save(todo);
    return savedTodo;
  }

  @Override
  public ArrayList<Todo> getTodos() {
    List<Todo> todolist = todoJpaRepository.findAll();
    ArrayList<Todo> todos = new ArrayList<>(todolist);
    return todos;
  }
}
