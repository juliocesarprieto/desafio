# Aplicação Web pra gerenciar os livros da biblioteca com Angular 5.0 e Spring Boot 2.0

**Prerequisito:** 
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Angular 5](https://angular.io/)
* [Node.js](https://nodejs.org/)
* MySQL Server 5.1

## Getting Started

Para instalar o exemplo, executar os seguintes comandos:

```bash
git clone https://github.com/juliocesarprieto/desafio.git
cd desafio
```

Isto vai fazer uma copia do projeto localmente. Para instalar e executar as aplicações, seguir as seguintes instruções:



Para executar o server, execute o comando `cd server` no `prompt` pra ficar dentro da pasta `server` e executar o seguinte comando: 
 
```bash
mvnw spring-boot:run
```

Para ver o api-doc Restful:

```
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
```

Para executar o client, execute o comando `cd client` no `prompt` pra ficar dentro da pasta `client` e executar os seguintes comandos:
 
```bash
npm install && npm start
```
#### Configuração do server

Para configurar a conexão com o Banco de Dados abrir o arquivo `application.properties` dentro `server/src/main/resources/application.properties`.

```
bd.url= `url`
bd.port= `porta`
bd.dataBase= `dataBase`
bd.usuario= `usuario`
bd.senha= `senha`
```

Para configurar a comunicação com o server abrir o arquivo `config.ts` dentro `client/src/app/config/config.ts`

```typescript
export const URL_ROOT={
    url : `url`,
    port: `porta`
}
```

#### Configuração o Banco de Dados

Na pasta BD contem o `gerenciar_biblioteca.sql`, subir num gestor de bancos de dados MySQL


