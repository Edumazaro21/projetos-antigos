package br.com.mazaro.consultacep.controller;

import br.com.mazaro.consultacep.service.ConsultaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/consultarCEP")
public class ConsultaCepController {
   
    @Autowired
    private ConsultaCepService service;
    
    @GetMapping("/{cep}")
    public ResponseEntity<String> getEndereco(@PathVariable String cep) {
        
        return service.buscaEndereco(cep);
    }
    
}
