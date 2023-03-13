<p align="center">
  <img src="https://user-images.githubusercontent.com/60453269/220384874-f136b1f9-a852-4774-a600-7fab9d77e8a2.png" alt="Logo" width="300" height="200" />
</p>

<h1 align="center"> ⭐ Readme </h1>

<p align="center">
  <b> ⭐ Gerenciamento de Projetos </b></br>
  <sub> ⭐ API para um sistema de gerenciamento de projetos.
  <sub>
</p>


[![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/colored.png)](#table-of-contents)

<p align="center">
  <a href="#Introdução"> 🧩 Introdução </a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Resultados"> 🚀 Resultados</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#ComoUtilizar"> 🧪 Como Utilizar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#Ideias">💡 Possíveis Melhorias </a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>

<br/>

<a id="Introdução"></a>
## 🧩 Introdução 

  ***⠀⠀⠀⠀⭐ A API é baseada em duas entidades, são elas Project(para projetos) e Task(para tarefas dos projetos). 
Possuindo 4 tipos de endpoint, a API possibilita criar(POST), listar(GET), excluir(DELETE) e alterar(PUT) Projetos e Tarefas.***

<br/>


<a id="Resultados"></a>
## 🚀 Resultados 
  > Todos os resultados foram alcançados com sucesso. De modo geral são esses os resultados de cada requisição. 

<br/> 

### ***⠀⠀⠀⠀⭐ Requests dos Endpoints:***

  
### 🎯 CRIAR UM PROJETO 

### ```POST``` 

```URL
 http://localhost:8080/projects

```
  REQUEST:
```JSON
{
  "name": "Spartan Project",
  "description": "Project for Spartans"
}
```
RESPONSE:
### ```STATUS CODE - 201```
```JSON
{
	"id": 1,
	"name": "Spartan Project",
	"description": "Project for Spartans",
	"tasks": []
}
```

<br /> 

### 🎯 LISTAR TODOS OS PROJETOS
  
### ```GET``` 

```URL

http://localhost:8080/projects

```
  Retorna lista com todos os projetos:
### ```STATUS CODE - 200```
```JSON
[
  {
    "id": 1,
    "name": "Spartan Project",
    "description": "Project for Spartans",
    "tasks": [
      {
        "id": 1,
        "description": "Logic Test",
        "deadLine": "2023-03-13T23:59:59Z",
        "status": "DONE"
      },
      {
        "id": 2,
        "description": "Data Structure and SQL",
        "deadLine": "2023-03-13T23:59:59Z",
        "status": "DONE"
      }
    ]
  },
  {
    "id": 2,
    "name": "Victory Project",
    "description": "Victory for Spartans",
    "tasks": []
  }
]
```

<br />

### 🎯 LISTAR UM ÚNICO PROJETO 

### ```GET``` 

```URL

 http://localhost:8080/projects/{id}

```
Retorna o projeto com o {id} indicado na URL:
### ```STATUS CODE - 200```
```JSON
{
	"id": 1,
	"name": "Spartan Project",
	"description": "Project for Spartans",
	"tasks": [
      {
        "id": 1,
        "description": "Logic Test",
        "deadLine": "2023-03-13T23:59:59Z",
        "status": "DONE"
      },
      {
        "id": 2,
        "description": "Data Structure and SQL",
        "deadLine": "2023-03-13T23:59:59Z",
        "status": "DONE"
      }
    ]
}
```
***⠀⠀⠀⠀⭐ Exceção: Caso o {id} não seja encontrado, retorna 404***

<br />

### 🎯 EDITAR PROJETO 

### ```PUT``` 

```URL
 http://localhost:8080/projects/{id}

```
  REQUEST:
```JSON
{
  "name": "Update Victory Project",
  "description": "Victory for ALL Spartans"
}
```
RESPONSE:
### ```STATUS CODE - 200```
```JSON
{
  "id": 2,
  "name": "Update Victory Project",
  "description": "Victory for ALL Spartans",
  "tasks": []
}
```
***⠀⠀⠀⠀⭐ Exceção: Caso o {id} não seja encontrado, retorna 404***

<br />

### 🎯 DELETAR PROJETO, ASSIM COMO TODAS AS SUAS TAREFAS 

### ```DELETE``` 

```URL
 http://localhost:8080/projects/{id}
```
RESPONSE:
### ```STATUS CODE - 204```
***⠀⠀⠀⠀⭐ Exceção: Caso o {id} não seja encontrado, retorna 404***

<br />

### 🎯 ADICIONAR TAREFA A UM PROJETO 

### ```POST``` 

```URL
 http://localhost:8080/tasks

```
  REQUEST:
```JSON
{
  "description": "Logic Test",
  "deadLine": "2023-03-13T23:59:59Z",
  "status": "DONE",
  "projectId": 1
}
```
RESPONSE:
### ```STATUS CODE - 201```
```JSON
{
  "id": 1,
  "description": "Logic Test",
  "deadLine": "2023-03-13T23:59:59Z",
  "status": "DONE"
}
```
***⠀⠀⠀⠀⭐ Exceção: Caso o campo "projectId" não corresponda a nenhum id de Projeto existente, retorna 404***

<br />

### 🎯 LISTAR TAREFAS DE UM PROJETO 

### ```GET``` 

```URL
 http://localhost:8080/tasks/{projectId}
```

RESPONSE:
### ```STATUS CODE - 200```
```JSON
[
  {
    "id": 1,
    "description": "Logic Test",
    "deadLine": "2023-03-13T23:59:59Z",
    "status": "DONE"
  },
  {
    "id": 2,
    "description": "Data Structure and SQL",
    "deadLine": "2023-03-13T23:59:59Z",
    "status": "DONE"
  }
]
```
***⠀⠀⠀⠀⭐ Exceção: Caso {projectId} não corresponda a nenhum id de Projeto existente, retorna 404***

<br />

### 🎯 EDITAR TAREFA 

### ```PUT``` 

```URL
 http://localhost:8080/tasks/{id}

```
  REQUEST:
```JSON
{
  "description": "Update Data Structure and SQL",
  "deadLine": "2023-03-12T20:00:00Z",
  "status": "FINISHED"
}
```
RESPONSE:
### ```STATUS CODE - 200```
```JSON
{
  "id": 2,
  "description": "Update Data Structure and SQL",
  "deadLine": "2023-03-12T20:00:00Z",
  "status": "FINISHED"
}
```
***⠀⠀⠀⠀⭐ Exceção: Caso o {id} não seja encontrado, retorna 404***

<br />

### 🎯 DELETAR TAREFA 

### ```DELETE``` 

```URL
 http://localhost:8080/tasks/{id}
```
RESPONSE:
### ```STATUS CODE - 204```
***⠀⠀⠀⠀⭐ Exceção: Caso o {id} não seja encontrado, retorna 404***

<br />

### 🎯 PADRÃO DAS EXCEÇÕES

<br />

⭐ Exceção |
|---|
 ![Captura de tela de 2023-03-13 20-24-54](https://user-images.githubusercontent.com/75883603/224854256-7d47d655-0570-4b6c-9735-08baf6eb5fcd.png)|

<br />

<a id="ComoUtilizar"></a>
## 🧪 Como Utilizar
> Siga este passo a passo para executar a aplicação

<br />   

  ### ***⠀⠀⠀⠀⭐ Versões utilizadas no desenvolvimento:***
  ###          `📖 Java:` 17.0.6-oracle
  ###          `📖 Apache Maven:` 3.6.3
  ###          `📖 Spring Boot:` 3.0.4
  ###          `📖 psql (PostgreSQL):` 15.2 (Ubuntu 15.2-1.pgdg20.04+1)
  
<br />   

## 1. Clonar o projeto

<br />  

## 2. Criar um banco PostgreSQL local
### No terminal rode os comandos:
Pare entrar no postgres ```psql```

Para criar o banco ```CREATE DATABASE project_management_db;```

Pare sair do postgres ```\q```

<br />  

## 3. Editar o arquivo ```application.properties``` do projeto
### As variáveis que você irá editar são:
#### 1. colocar a url do banco que você acabou de criar no psql: (ficará algo semelhante a isso: jdbc:postgresql://localhost:5432/project_management_db)
```JSON
spring.datasource.url=url_do_banco_que_foi_criado
```
#### 2. colocar o seu username do psql:
```JSON
spring.datasource.username=seu_user_do_psql
```
#### 3. colocar a sua senha do psql:
```JSON
spring.datasource.password=sua_senha
```

### O arquivo ficará com uma disposição semelhante a essa:
```JSON
spring.datasource.url=url_do_banco_que_foi_criado
spring.datasource.username=seu_user_do_psql
spring.datasource.password=sua_senha
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.jpa.open-in-view=true
```

<br />

## 4. Rodar o projeto

<br />  
  
<a id="Ideias"></a>
## 💡 Possíveis Melhoras
> Possíveis melhorias no código e no projeto.

<br />

- [ ] ***- Mostrar o campo projectId no POST da Task.*** 
- [ ] ***- PUT do Project ser um PATCH para ser possível alterar apenas name ou description*** 
- [ ] ***- Endpoint para excluír Tasks de um Project sem precisar deletar a Task*** 
- [ ] ***- PUT da Task ser um PATCH para ser possível alterar description, deadLine ou status***
- [ ] ***- Exceções para quando faltar um campo em uma requisição POST***
- [ ] ***- Exceção para quando o campo status da Task não estiver no padrão correto*** 
- [ ] ***- Melhor tratamento do campo deadLine da Task*** 

<br /> 
