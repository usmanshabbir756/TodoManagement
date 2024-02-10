package com.usman.todo.controller;


import com.usman.todo.dto.TodoDto;
import com.usman.todo.service.TodoService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    TodoService todoService;

    // http://localhost:8080/api/todos

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        return new ResponseEntity<>(todoService.addTodo(todoDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodoByID(@PathVariable("id") Long todoId){
        return ResponseEntity.ok(todoService.getTodo(todoId));
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllToodos(){
        List<TodoDto> todosDto=todoService.getAllTodos();
        return ResponseEntity.ok(todosDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long todoId,
                                              @RequestBody TodoDto todoDto){
        return ResponseEntity.ok(todoService.updateTodo(todoId,todoDto));
    }
}
