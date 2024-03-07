# Lava Car
## Requisitos

- [ ] CRUD Agendamento
- [ ] CRUD Cadastro
- [ ] CRUD Login
- [ ] Dashboard
- [ ] Autenticação

## ENDPOINTS

### Cadastro

`GET` /cadastro

Listagem de dados necessários para cadastrar o cliente
`Nome`
`Email`
`Senha`

**Códigos de status**

`200` sucesso

`GET` /cadastro/{id}

Sistema retorna os detalhes do cadastro com o `id` informado.

**Códigos de status**
`200` sucesso
`404` id não encontrado
---
`POST` /cadastro

Cadastra um novo cliente
`200` sucesso
`404` id não encontrado

| Campo | Tipo | Obrigatório | Descrição
|-------|------|:-------------:|-----------
|Nome|String|✅|Inserir um nome curto para identificar o novo cliente.
|Email|String|✅|Adicionar o email.
|Senha|String|✅|Inserir uma senha.
---
`DELETE` /cadastro/{id}

Apaga o cadastro atraves do `id` informado.

**Códigos de status**

`204` Apagado com sucesso
`404` Id não encontrado 
---
`PUT` /cadastro/{id} 

Atualiza o cadastro com o `id` informado.

| Campo | Tipo | Obrigatório | Descrição
|-------|------|:-------------:|-----------
|Nome|String|✅|Inserir um novo nome curto para atualizar o novo usuário.
|Email|String|✅|Adicionar o novo email a ser atualizado.
|Senha|String|✅|Adicionar a nova senha a ser atualizada.

**Códigos de status**

`200` Alterado com sucesso.
`404` Id não encontrado.
`400` validação falhou.
---
**Schema**

```js
{
    "id": 1,
    "nome": "Cleiton Rasta",
    "email": "robeerson@gmail.com"
    "senha": "234"
}
```
### Login

`GET` /login

Lista todos os requistios para o login!

`Email`
`Senha`

`200` sucesso

---

`GET` /login/{id}

Sistema retorna os detalhes do login com o `id` informado.

**Códigos de status**

`200` sucesso
`404` id não encontrado

---
`POST` /login

Adiciona um novo login no sistema do lava rapido.

| Campo | Tipo | Obrigatório | Descrição
|-------|------|:-------------:|-----------
|Email|String|✅|Inserir um novo email para o cadastro.
|Senha|String|✅|Adicionar uma nova senha para cadastro.

**Códigos de status**

`201` Criado com sucesso
`400` Validação falhou

---

`DELETE` /categoria/{id}

Apaga o login atraves do `id` informado.

**Códigos de status**

`204` Apagado com sucesso
`404` Id não encontrado 

---

`PUT` /login/{id} 

Altera o login com o `id` informado.

| Campo | Tipo | Obrigatório | Descrição
|-------|------|:-------------:|-----------
|Email|String|✅|Inserir um novo email para atualizar no cadastro.
|Senha|String|✅|Adicionar a nova senha para atualizar no cadastro.

**Códigos de status**

`200` Alterado com sucesso.
`404` Id não encontrado.
`400` validação falhou.

---

**Schema**

```js
{
    "id": 1,
    "email": "everson@gmail.com",
    "senha": "2324"
}
```
