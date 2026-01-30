package net.javaguides.todo_management.controller;

import lombok.AllArgsConstructor;
import net.javaguides.todo_management.dto.TodoDto;
import net.javaguides.todo_management.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

   private TodoService todoService;

   // Build Add Todo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){

        TodoDto savedTodo = todoService.addTodo(todoDto);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Build Get todo REST API
    @GetMapping("{id}")
    public  ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    // Build Get All todo Rest API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){
       List<TodoDto> todos = todoService.getAllTodos();
//       return new ResponseEntity<>(todos, HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }

    // Build update todo Rest API
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId){
        TodoDto updateTodo= todoService.updateTodo(todoDto, todoId);
        return  ResponseEntity.ok(updateTodo);
    }

    // Build delete todo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo deleted Successfully");
    }

    // Build Completed Todo Rest API
    @PatchMapping("complete/{id}")
    public ResponseEntity<TodoDto> CompleteTodo(@PathVariable("id") Long todoId){
        TodoDto updateTodo= todoService.completeTodo(todoId);
        return  ResponseEntity.ok(updateTodo);
    }


}
