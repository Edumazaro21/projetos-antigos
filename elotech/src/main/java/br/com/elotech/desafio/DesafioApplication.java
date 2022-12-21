package br.com.elotech.desafio;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DesafioApplication {

    public static void main(String[] args) {

        try {
            SpringApplication app = new SpringApplication(DesafioApplication.class);

            app.setDefaultProperties(Collections.singletonMap("server.port", "8484"));

            app.run(args);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
