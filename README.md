Todolist- Desafio

Descrição do projeto:
Este projeto tem como objetivo fornecer uma ferramenta de gerenciamento de tarefas personalizável, permitindo que os usuários organizem suas atividades em diversas áreas de interesse.
A ferramenta oferece funcionalidades como criação de tarefas, definição de prazos, marcação de tarefas como concluídas e organização em diferentes projetos.


Técnologias:
- Spring Boot
- Spring MVC
- Spring Data JPA
- SpringDoc OpenAPI 3
- Mysql

Práticas adotadas:
- SOLID
- API REST
- Consultas com Spring Data JPA
- Injeção de dependências
- Tratamentos de respostas de erro
- Geração automatica do swagger com a OpenAPI 3

Desenvolvimento:
Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:
git clone


mvn clean install:
O comando irá baixar todas as dependências do projeto e criar um diretório target com os artefatos construídos, que incluem o arquivo jar do projeto.
Além disso, serão executados os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.


Configuração:
Para executar o projeto, é necessário utilizar o intellij, para que o mesmo identifique as dependências necessárias para a execução no repositório .m2 do Maven.
Uma vez importado o projeto, será criado um arquivo .classpath que irá informar qual a classe principal para a execução.

API Endpoints
Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta Postman:

    * Criar tarefa
    - POST
    - http://localhost:8080/todos'

      {
      "nome": "Fazer compras",
      "descricao": "Comprar leite, pão e frutas",
      "realizado": false,
      "prioridade": 2
      }

-------------------------------------------------------

    * Excluir tarefa

    - DELETE
    - 'http://localhost:8080/todos/1'

--------------------------------------------------------
    * Listar tarefa

    - GET
    -  http://localhost:8080/todos'
--------------------------------------------------------

    * Listar tarefa

    - PUT
    -  http://localhost:8080/todos/1'

     {
     "nome": "Fazer compras",
     "descricao": "Comprar leite, pão e frutas",
     "realizado": false,
     "prioridade": 2
     }



-------------------------------------------------------
Testes:
Para rodar os testes, utilize o comando abaixo:
mvn test
