package br.com.dextra.dextrachallenge.controller;

import br.com.dextra.dextrachallenge.config.responseEntity.DefaultResponseEntity;
import br.com.dextra.dextrachallenge.config.responseEntity.DefaultResponseEntityFactory;
import br.com.dextra.dextrachallenge.model.dto.CharacterDto;
import br.com.dextra.dextrachallenge.model.entity.Character;
import br.com.dextra.dextrachallenge.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @PostMapping(value = "save")
    public ResponseEntity save(@RequestBody @Valid CharacterDto character) throws Exception {

        try {
            Character characterSaved = characterService.save(character);

            return DefaultResponseEntityFactory.create("Character save with sucess!", Arrays.asList(characterSaved), HttpStatus.OK);

        } catch (Exception ex) {
            return DefaultResponseEntityFactory.create(ex.getMessage(), new ArrayList<Character>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "findAll")
    public ResponseEntity findAll() {

        try {
            List<Character> vCharacter = characterService.findAll();

            return DefaultResponseEntityFactory.create("All Character queried successfully!", vCharacter, HttpStatus.OK);

        } catch (Exception ex) {
            return DefaultResponseEntityFactory.create(ex.getMessage(), new ArrayList<Character>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "findById/{id}")
    public ResponseEntity findById(@PathVariable Long id) {

        try {
            Character character = characterService.findById(id);

            return DefaultResponseEntityFactory.create("Character consulted successfully!", Arrays.asList(character), HttpStatus.OK);

        } catch (Exception ex) {
            return DefaultResponseEntityFactory.create(ex.getMessage(), new ArrayList<Character>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "findByHouse/{idHouse}")
    public ResponseEntity findByHouse(@PathVariable String idHouse) {

        try {
            List<Character> vCharacter = characterService.findByHouse(idHouse);

            return DefaultResponseEntityFactory.create("All Character queried by house successfully!", vCharacter, HttpStatus.OK);

        } catch (Exception ex) {
            return DefaultResponseEntityFactory.create(ex.getMessage(), new ArrayList<Character>(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        try {
            Character character = characterService.delete(id);

            return DefaultResponseEntityFactory.create("Character successfully deleted!", Arrays.asList(character), HttpStatus.OK);

        } catch (Exception ex) {
            return DefaultResponseEntityFactory.create(ex.getMessage(), new ArrayList<Character>(), HttpStatus.BAD_REQUEST);
        }
    }
}
