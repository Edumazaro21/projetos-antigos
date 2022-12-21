package br.com.elotech.desafio.controller;

import br.com.elotech.desafio.config.ReponseEntity.DefaultResponseEntityFactory;
import br.com.elotech.desafio.model.dto.PessoaDto;
import br.com.elotech.desafio.model.dto.PessoaFiltroDto;
import br.com.elotech.desafio.model.entity.Pessoa;
import br.com.elotech.desafio.service.PessoaService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity getAll() {

        try {
            List<PessoaDto> vPessoa = service.findAll();

            if (vPessoa.isEmpty()) {
                return DefaultResponseEntityFactory.create("Nenhum resultado encontrado.", vPessoa, HttpStatus.OK);

            } else {
                return DefaultResponseEntityFactory.create("Pessoas consultadas com sucesso.", vPessoa, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return DefaultResponseEntityFactory.create("Erro: " + ex.getMessage(), new ArrayList<Pessoa>(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody @Valid PessoaDto pessoa) {

        try {
            service.save(pessoa);

            return DefaultResponseEntityFactory.create("Pessoa salva com sucesso", Arrays.asList(pessoa), HttpStatus.OK);

        } catch (Exception ex) {
            return DefaultResponseEntityFactory.create("Erro: " + ex.getMessage(), new ArrayList<Pessoa>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@RequestParam Long id) {

        try {
            List<PessoaDto> vPessoa = service.findById(id);

            if (vPessoa.isEmpty()) {
                return DefaultResponseEntityFactory.create("Nenhum resultado encontrado.", vPessoa, HttpStatus.OK);

            } else {
                return DefaultResponseEntityFactory.create("Pessoa consultada com sucesso.", vPessoa, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return DefaultResponseEntityFactory.create("Erro: " + ex.getMessage(), new ArrayList<Pessoa>(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@RequestParam Long id) {

        try {
            List<PessoaDto> vPessoa = service.deleteById(id);

            return DefaultResponseEntityFactory.create("Pessoa deletada com sucesso.", vPessoa, HttpStatus.OK);

        } catch (Exception ex) {
            return DefaultResponseEntityFactory.create("Erro: " + ex.getMessage(), new ArrayList<Pessoa>(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/filtro")
    public ResponseEntity getByFilter(@RequestBody @Valid PessoaFiltroDto filtro) {

        try {
            List<PessoaDto> vPessoa = service.findByFilter(filtro);

            if (vPessoa.isEmpty()) {
                return DefaultResponseEntityFactory.create("Nenhum resultado encontrado.", vPessoa, HttpStatus.OK);

            } else {
                return DefaultResponseEntityFactory.create("Pessoas consultadas com sucesso.", vPessoa, HttpStatus.OK);
            }

        } catch (Exception ex) {
            return DefaultResponseEntityFactory.create("Erro: " + ex.getMessage(), new ArrayList<Pessoa>(), HttpStatus.BAD_REQUEST);
        }
    }
}
