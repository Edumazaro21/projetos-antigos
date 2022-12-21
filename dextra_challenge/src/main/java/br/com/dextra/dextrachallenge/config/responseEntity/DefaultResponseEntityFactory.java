package br.com.dextra.dextrachallenge.config.responseEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DefaultResponseEntityFactory {

    public static ResponseEntity<DefaultResponseEntity> create(String message, List<?> object, HttpStatus httpStatus) {
        System.out.println(message);

        return new ResponseEntity<DefaultResponseEntity>(new DefaultResponseEntity(message, object), httpStatus);
    }
}
