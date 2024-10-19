package br.com.vini.desafio_todolist;

import br.com.vini.desafio_todolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateSucess() {
        var todo = new Todo();
        todo.setDescricao("descricao");
        todo.setNome("Valdemar");
        todo.setPrioridade(1);
        todo.setRealizado(false);

        webTestClient.post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$")
                .isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].nome").isEqualTo(todo.getNome())
                .jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
                .jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
                .jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());


    }

    @Test
    void testCreateFailed() {

        var todo = new Todo();
        todo.setDescricao(null);
        todo.setNome("Valdemar");
        todo.setPrioridade(1);
        todo.setRealizado(false);


        webTestClient.post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus()
                .isBadRequest();

    }

}
