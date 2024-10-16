// Write your code here
package com.example.todo.repository;

import java.util.*;
import java.util.ArrayList;
import com.example.todo.model.Todo;

public interface TodoRepository {
  ArrayList<Todo> getTodos();

  Todo addTodo(Todo todo);

  Todo getTodoById(int Id);
  Todo updateTodo(int Id, Todo todo);
  void deleteTodo(int Id);
}


