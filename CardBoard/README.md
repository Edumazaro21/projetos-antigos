# CardBoard
Meu projeto é composto de dois aplicativos java, o Desktop que fica responsável de toda interação com o usuário, 
feito com java 11 e o gerenciador de dependências Gradle, e uma aplicação WebService feita em Springboot para gerencias as 
requisições REST, usei nesta o gerenciador de dependência Maven e java 8.

Configurar o ambiente para a execução das aplicações:
1 - Colar a pasta "cardboard" dentro do diretório "c:" dentro desta pasta está o arquivo .properties com os dados para a conexão
ao banco de dados.

2 - Executar o Script de criação do Database "Database.sql"

3 - Executar o aplicativo "CardBoardWS" que esta dentro da pasta executáveis, o mesmo subirá os endpoints utilizando springboot.

4 - Executar o aplicativo "CardBoard" que esta dentro da pasta executáveis, este aplicativo é onde deverá ocorrer toda a interação 
com o usuário.
