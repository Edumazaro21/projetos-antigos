# Consulta CEP

O ConsultaCEP é uma aplicação responsável por consultar todas as informações de um endereço passando apenas um CEP.

### Build

Para compilar o projeto, executar a task `build` do gradle.

Linux
```
./gradlew clean build
```

Windows
```
gradlew.bat clean build
```

Será gerado o arquvo consultacep-1.0.0.jar na pasta "pasta projeto"\build\libs.

Executando o .jar o servidor já está aperante e ouvindo a URL http://localhost:8080.

### End Point

Para que seja efetuada a consulta do CEP deve ser utilizado o seguinte endereço http://localhost:8080/consultarCEP/"CEP que deseja consultar"

## Construido com

* [Java 11](https://docs.oracle.com/javase/11/)
* [Gradle](https://docs.gradle.org/current/userguide/userguide.html) - Ferramenta de automação de build
* [Maven](https://maven.apache.org/) - Dependency Management
