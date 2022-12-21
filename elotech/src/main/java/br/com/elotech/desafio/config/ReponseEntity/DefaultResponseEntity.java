package br.com.elotech.desafio.config.ReponseEntity;

import java.util.List;

public class DefaultResponseEntity {
    
    protected final String message;
    protected final List<?> dados;

    public DefaultResponseEntity(String message, List<?> dados) {
        this.message = message;
        this.dados = dados;
    }

    public String getMessage() {
        return message;
    }

    public List<?> getData() {
        return dados;
    }
}