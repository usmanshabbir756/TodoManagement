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

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos=todoRepository.findAll();
        return todos.stream().map((todo)->modelMapper.map(todo,TodoDto.class)).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(Long todoId, TodoDto todoDto) {
        Todo todo=todoRepository.findById(todoId)
                .orElseThrow(()->new ResponseNotFound("Not found with id : "+ todoId));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        Todo updatedTodo=todoRepository.save(todo);
        return modelMapper.map(updatedTodo,TodoDto.class);
    }
}
