# Projeto Integrador - Eventos

Projeto individual com Front-end em React e API REST em Java/Spring Boot/JdbcTemplate usando H2.

## Estrutura
- `cliente/`: React + Vite + Axios + CSS Modules
- `api/`: Spring Boot + JdbcTemplate + H2

## Executar
### API
Na pasta `api`:
```bash
mvn spring-boot:run
```
API: `http://localhost:8080`

### Cliente
Na pasta `cliente`:
```bash
npm install
npm run dev
```
Normalmente: `http://localhost:5173`

## Contrato
### GET /eventos
Retorna todos os eventos. Status: `200 OK`.

### POST /eventos
Body:
```json
{"nome":"Workshop de Java","data":"2026-10-15","local":"São Paulo","responsavel":"João Silva","tipo":"Workshop","situacao":"ATIVO"}
```
Sucesso: `201 Created`. Dados inválidos: `400 Bad Request`.

Todos os campos são obrigatórios e `situacao` deve ser `ATIVO` ou `INATIVO`.
