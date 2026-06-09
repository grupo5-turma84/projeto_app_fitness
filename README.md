# 🏋️‍♂️ Projeto App Fitness

## 📖 Sobre o Projeto

O **Projeto App Fitness** é uma API REST desenvolvida durante o **Projeto Integrador da Generation Brasil**, com o objetivo de auxiliar usuários no acompanhamento de sua jornada fitness por meio do gerenciamento de exercícios, categorias de treino e controle de informações pessoais.

A aplicação permite o cadastro de usuários, organização de treinos personalizados, autenticação segura utilizando JWT e cálculo automático do IMC (Índice de Massa Corporal).

---

## 👥 Integrantes

* Fernando Garcia Cabeceiro
* Iohana Maria de Oliveira Santos
* Jackeline Pessoa Gomes
* Kauã Alves Cazemiro
* Milena Fernandes Silva
* Vitória Neris

---

## 🎯 Objetivo

Desenvolver uma API REST utilizando Java e Spring Boot, aplicando conceitos de:

* Programação Orientada a Objetos (POO)
* Arquitetura MVC
* CRUD Completo
* Relacionamento entre Entidades
* Persistência de Dados
* Segurança com JWT
* Boas Práticas de Desenvolvimento
* Versionamento com Git e GitHub

---

## 🚀 Tecnologias Utilizadas

### Back-end

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* Hibernate
* Maven

### Banco de Dados

* MySQL

### Ferramentas

* Spring Tool Suite (STS)
* Insomnia
* Git
* GitHub

---

## 📌 Funcionalidades

### 👤 Usuários

* Cadastrar usuário
* Buscar todos os usuários
* Buscar usuário por ID
* Atualizar usuário
* Excluir usuário

### 📂 Categorias

* Cadastrar categoria
* Buscar todas as categorias
* Buscar categoria por ID
* Buscar categoria por descrição
* Atualizar categoria
* Excluir categoria

### 🏋️ Exercícios

* Cadastrar exercício
* Buscar todos os exercícios
* Buscar exercício por ID
* Atualizar exercício
* Excluir exercício

### 🔐 Segurança

* Autenticação com JWT
* Controle de acesso às rotas
* Criptografia de senha

### 📊 Funcionalidade Extra

* Cálculo automático do IMC (Índice de Massa Corporal)

---

## 🗄️ Entidades

### Usuário

| Campo   | Tipo   |
| ------- | ------ |
| id      | Long   |
| nome    | String |
| usuario | String |
| senha   | String |
| foto    | String |

---

### Categoria

| Campo     | Tipo   |
| --------- | ------ |
| id        | Long   |
| descricao | String |

---

### Exercício

| Campo      | Tipo    |
| ---------- | ------- |
| id         | Long    |
| nome       | String  |
| descricao  | String  |
| series     | Integer |
| repeticoes | Integer |

---

## 🔗 Relacionamentos

### Categoria → Exercício

Uma categoria pode possuir vários exercícios.

```text
Categoria (1) ------ (N) Exercício
```

### Usuário → Exercício

Um usuário pode possuir vários exercícios.

```text
Usuário (1) ------ (N) Exercício
```

---

## 📊 Diagrama Entidade Relacionamento (DER)

```text
┌─────────────┐
│   Usuario   │
├─────────────┤
│ id          │
│ nome        │
│ usuario     │
│ senha       │
│ foto        │
└──────┬──────┘
       │ 1
       │
       │ N
┌──────▼──────┐
│  Exercicio  │
├─────────────┤
│ id          │
│ nome        │
│ descricao   │
│ series      │
│ repeticoes  │
│ usuario_id  │
│ categoria_id│
└──────┬──────┘
       │ N
       │
       │ 1
┌──────▼──────┐
│ Categoria   │
├─────────────┤
│ id          │
│ descricao   │
└─────────────┘
```

---

## 📂 Estrutura do Projeto

```text
src
├── controller
├── model
├── repository
├── security
├── service
└── exception
```

---

## ⚙️ Como Executar o Projeto

### Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/app-fitness.git
```

### Entrar na Pasta

```bash
cd app-fitness
```

### Executar

```bash
mvn spring-boot:run
```

A aplicação estará disponível em:

```text
http://localhost:8080
```

---

## 📬 Testes da API

Os endpoints podem ser testados utilizando:

* Insomnia
* Postman

---

## 🏆 Considerações Finais

O Projeto App Fitness foi desenvolvido com o propósito de consolidar os conhecimentos adquiridos durante o Bootcamp Java Full Stack da Generation Brasil.

Além de aplicar conceitos fundamentais de desenvolvimento Back-end com Spring Boot, o projeto proporcionou experiência prática com modelagem de banco de dados, segurança de aplicações, versionamento de código e desenvolvimento colaborativo utilizando Git e GitHub.

Este projeto serve como base para futuras implementações e evolução da plataforma, permitindo a expansão de funcionalidades voltadas ao universo fitness e à saúde dos usuários.

---

### Desenvolvido por Grupo 5 🚀
