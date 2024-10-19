package br.com.vini.desafio_todolist.entity;

import br.com.vini.desafio_todolist.controller.TodoListDto;
import jakarta.annotation.Generated;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private boolean realizado;
    private int prioridade;

    public Todo(TodoListDto todoListDto) {
        this.prioridade = todoListDto.prioridade();
        this.realizado = todoListDto.realizado();
        this.descricao = todoListDto.descricao();
        this.nome = todoListDto.nome();
    }



    public void updateFromDto(TodoListDto todoListDto) {
        this.prioridade = todoListDto.prioridade();
        this.realizado = todoListDto.realizado();
        this.descricao = todoListDto.descricao();
        this.nome = todoListDto.nome();
    }



}
