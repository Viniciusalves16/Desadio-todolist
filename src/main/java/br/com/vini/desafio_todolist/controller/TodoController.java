package br.com.vini.desafio_todolist.controller;

import br.com.vini.desafio_todolist.entity.Todo;
import br.com.vini.desafio_todolist.service.TodoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @Transactional
    List<Todo> create(@RequestBody @Valid TodoListDto todoListDto) {
        return todoService.create(todoListDto);
    }

    @GetMapping
    List<Todo> list() {
        return todoService.list();
    }

    @PutMapping("/{id}")
    public List<Todo> update(@PathVariable("id") Long id, @RequestBody TodoListDto todoListDto) {
        return todoService.update(id, todoListDto);
    }

    @DeleteMapping("/{id}")
    List<Todo> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }
}
