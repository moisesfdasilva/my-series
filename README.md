# My Series

## Sobre o Projeto
Aplicação desenvolvida para disponibilizar uma API com funcionalidades de criar, ler, modificar e deletar informações relativas às séries assistidas pela pessoa usuária.

## Tecnologias e Ferramentas empregadas

Maven;
Java 11;
JUnit 5;
Spring; e 
H2 Database.

## Status do Projeto
Aplicação em funcionamento, com os testes em desenvolvimento.

## Acesso à Aplicação
### Antes da instalação
Fazer o Clone do repositório.

### Instalação e Execução
A. Entrar no diretório raiz da aplicação:

  $ cd my-series

B. Instalar a aplicação pelo Maven, através do comando:
  
  $ mvn install

C. Iniciar a aplicação pelo comando:

  $ mvn spring-boot:run

D. Acessar a API, nas seguintes rotas:
1. Post, em http://localhost:8080/series, contendo o body { "nome": String }, cadastra uma nova série.
2. Get, em http://localhost:8080/series, exibe uma lista com todas as séries cadastradas.
3. Delete, em http://localhost:8080/series/{id}, deleta o cadastro da série, conforme o id especificado na rota.
4. Post, em http://localhost:8080/series/{id}/episodios, contendo o body { "numero": Integer, "duracaoEmMinutos": Integer }, cadastra os episódios da série, conforme o id especificado na rota.
5. Get, em http://localhost:8080/series/{id}/episodios, exibe uma lista com todos os episódios da série cadastrada, conforme o id especificado na rota.
6. Get, em http://localhost:8080/series/{id}/episodios, apresenta o valor total da duração dos episódios das séries cadastradas em minutos.

## Contribuintes
|Nome|GitHub|
| -------- | -------- |
|Trybe|https://github.com/trybe-tech-ops|
|Moisés Fernandes|https://github.com/moisesfdasilva|

## Contato
[GitHub: Repositório-my-series](https://github.com/moisesfdasilva/my-series)
