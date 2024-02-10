package com.usman.todo.service;

import com.usman.todo.dto.TodoDto;

import java.util.List;


public interface TodoService {

    public TodoDto addTodo(TodoDto todoDto);
    public TodoDto getTodo(Long todoId);
    public List<TodoDto> getAllTodos();
    public TodoDto updateTodo(Long todoId,TodoDto todoDto);
    public void deleteTodo(Long todoId);


}
