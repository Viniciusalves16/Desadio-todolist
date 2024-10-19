package br.com.vini.desafio_todolist.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TodoListDto (@NotBlank String nome, @NotBlank String descricao,  Boolean realizado, @NotNull Integer prioridade){
}
