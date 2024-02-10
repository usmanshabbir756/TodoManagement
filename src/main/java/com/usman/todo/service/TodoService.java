package com.usman.todo.service;

import com.usman.todo.dto.TodoDto;


public interface TodoService {

    public TodoDto addTodo(TodoDto todoDto);

    public TodoDto getTodo(Long todoId);

}
