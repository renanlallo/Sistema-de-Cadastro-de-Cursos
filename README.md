# Sistema de Cadastro de Cursos - Projeto Spring Boot

Este projeto é uma aplicação web simples para gerenciar cursos.  
Ele foi feito com **Spring Boot**, **Thymeleaf** e **H2 Database**.

---

## Como funciona

- **Área pública**: qualquer visitante pode acessar o catálogo de cursos em `http://localhost:8080/`.  
  Lá são listados todos os cursos cadastrados no sistema.

- **Área administrativa**: acessível apenas para quem faz login.  
  - Usuário padrão: `admin`  
  - Senha: `admin`  
  Após o login, o administrador é redirecionado para `/admin/cursos`, onde pode:
    - Cadastrar novos cursos
    - Editar cursos existentes
    - Excluir cursos
    - Visualizar detalhes da lista

Todas as alterações feitas pelo administrador são salvas no banco H2 e aparecem automaticamente na área pública.

---

## Lógica de acesso

- Visitante acessa `/` → vê catálogo público.  
- Clica em "Área Administrativa" → vai para `/login`.  
- Faz login com `admin/admin` → redirecionado para `/admin/cursos`.  
- Se tentar acessar `/admin/**` sem login, é redirecionado para `/login`.  

---

## Banco de dados H2

O projeto usa o banco **H2 em memória**.  
Isso significa que os dados ficam disponíveis enquanto a aplicação está rodando.  
Ao reiniciar, o banco é recriado automaticamente.

Para acessar o console web do H2:

1. Abra `http://localhost:8080/h2-console` no navegador.  
2. Use as credenciais:
   - **JDBC URL**: `jdbc:h2:mem:escola`  
   - **User Name**: `sa`  
   - **Password**: (deixe em branco)  
3. Clique em **Connect**.  
4. Você verá as tabelas criadas (ex.: `CURSO`) e pode executar consultas SQL, como:
   SELECT * FROM CURSO
