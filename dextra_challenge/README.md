# dextra_challenge
Aplicação backend com um CRUD básico, ondem é possível salvar, editar, consultar e excluir personagens.

## Formas de subir o serviço
 
### Local
Na raiz do projeto se encontra o arquivo docker-compose.yml responsável por subir uma imagem já configurada para rodar toda a aplicação.

```
$ docker compose -f docker-compose.yml up
``` 
A aplicação ficará disponível na porta 8080 para acesso.
	
### Remota
Realizado o deploy da aplicação no Heroku.

https://aw-challenge-dextra-api.herokuapp.com

#### EndPoints

https://aw-challenge-dextra-api.herokuapp.com/api/characters/findAll  - Retorna todos os personagens cadastrados.

https://aw-challenge-dextra-api.herokuapp.com/api/characters/findById/{id do personagem}  - Retorna o personagem com o id informado.

https://aw-challenge-dextra-api.herokuapp.com/api/characters/findByHouse  - Retorna todos os personagens cadastrados para determinada casa.

https://aw-challenge-dextra-api.herokuapp.com/api/characters/save  - Salava um novo personagem e atualiza um existente informado seu id.

https://aw-challenge-dextra-api.herokuapp.com/api/characters/delete  - Deleta um personagem informando seu id.

#### Documentação

Para facilitar o acesso foi implementado o Swagger que mapeia todos os endPoints e ajuda a consumí-los expondo os objetos requeridos.

https://aw-challenge-dextra-api.herokuapp.com/api/characters/swagger-ui.html

http://localhost:8080/api/characters/swagger-ui.html

## Constrido com
*  [Java 11](https://docs.oracle.com/en/java/javase/11/)
*  [Maven](https://maven.apache.org/) - Gerenciador de Dependências
*  [Docker] (https://docs.docker.com) - Gerenciador de Containers  