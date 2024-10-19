package br.com.vini.desafio_todolist.service;

import br.com.vini.desafio_todolist.controller.TodoListDto;
import br.com.vini.desafio_todolist.entity.Todo;
import br.com.vini.desafio_todolist.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(TodoListDto todoListDto) {
        Todo todo = new Todo(todoListDto);
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }
    public List<Todo> update(Long id, TodoListDto todoListDto) {
        Optional<Todo> search = todoRepository.findById(id);

        if (search.isPresent()) {
            Todo existingTodo = search.get();
            existingTodo.updateFromDto(todoListDto);
            todoRepository.save(existingTodo);
        } else {
            throw new EntityNotFoundException("Todo não encontrado");
        }

        return list(); // Presumindo que isso retorna a lista atualizada de Todos
    }


    public List<Todo> delete(Long id) {

        todoRepository.deleteById(id);
        return list();
    }

}
