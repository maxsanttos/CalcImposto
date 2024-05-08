# CalcImposto

---

## API de Calculadora de Imposto para Trabalhador CLT

Esta é uma API RESTful desenvolvida em Java com Spring Boot que oferece uma calculadora de impostos para trabalhadores com regime CLT (Consolidação das Leis do Trabalho). A API permite aos clientes calcular automaticamente os impostos sobre o salário informado, incluindo INSS (Instituto Nacional do Seguro Social) e IRRF (Imposto de Renda Retido na Fonte), além de fornecer endpoints para consulta dos resultados dos cálculos.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL

## Funcionalidades Principais

- Cálculo automático dos impostos (INSS e IRRF) com base no salário informado.
- Armazenamento dos cálculos de impostos no banco de dados para consulta posterior.
- Endpoints RESTful para calcular impostos, criar, atualizar, buscar e excluir usuários, além de recuperar os impostos calculados.

## Como Usar

1. Certifique-se de ter o Java e o MySQL instalados em seu sistema.
2. Clone este repositório para o seu ambiente local.
3. Configure o arquivo `application.properties` com as informações de conexão do banco de dados MySQL.
4. Execute a aplicação usando o comando `mvn spring-boot:run`.
5. A API estará disponível em `http://localhost:8080`.

## Endpoints Disponíveis

- `GET /users`: Retorna todos os usuários cadastrados.
- `GET /users/{userId}`: Retorna um usuário específico pelo ID.
- `POST /users`: Cria um novo usuário.
- `PUT /users/{userId}`: Atualiza um usuário existente pelo ID.
- `DELETE /users/{userId}`: Exclui um usuário pelo ID.
- `GET /users/{userId}/impostos`: Retorna os impostos calculados para um usuário específico pelo ID.
- `GET /users/{userId}/calcular-impostos`: Calcula e armazena os impostos para um usuário específico pelo ID.

## Próximos Passos

Algumas melhorias e recursos que podem ser adicionados à API incluem:

- Implementação de autenticação de usuário para proteger as informações sensíveis.
- Validação de entrada para garantir que os dados informados sejam válidos antes de calcular os impostos.
- Adição de endpoints para consulta de impostos específicos e cálculos históricos.

## Contribuição

Contribuições são bem-vindas! Se você deseja sugerir uma melhoria, relatar um problema ou contribuir com código, sinta-se à vontade para abrir uma issue ou enviar um pull request.
