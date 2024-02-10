package com.usman.todo.service.impl;

import com.usman.todo.dto.TodoDto;
import com.usman.todo.entity.Todo;
import com.usman.todo.exeption.ResponseNotFound;
import com.usman.todo.repository.TodoRepository;
import com.usman.todo.service.TodoService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    TodoRepository todoRepository;
    ModelMapper modelMapper;


    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        Todo todo=modelMapper.map(todoDto, Todo.class);
        Todo saveTodo=todoRepository.save(todo);
        return modelMapper.map(saveTodo,TodoDto.class);
    }

    @Override
    public TodoDto getTodo(Long todoId) {
        Todo getTodo=todoRepository.findById(todoId)
                .orElseThrow(()->{
                   return new ResponseNotFound("Not Found With id : " + todoId);
                });
        return modelMapper.map(getTodo,TodoDto.class);
    }
}
