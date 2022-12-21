package br.com.dextra.dextrachallenge.repositories;

import br.com.dextra.dextrachallenge.model.entity.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CharacterRepositoryTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    @DisplayName("Insert new character")
    void testInsert() {

        Character harry = Character.builder()
                .name("Harry Potter")
                .role("student")
                .school("Hogwarts School of Witchcraft and Wizardry")
                .idHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde")
                .patronus("stag")
                .build();

        Character characterResult = characterRepository.save(harry);

        assertNotNull(characterResult);
        assertTrue(characterResult.getId() > 0);
    }

    @Test
    @DisplayName("Update character")
    void testUpdate() {

        Character harry = Character.builder()
                .name("Harry Potter")
                .role("student")
                .school("Hogwarts School of Witchcraft and Wizardry")
                .idHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde")
                .patronus("stag")
                .build();

        characterRepository.save(harry);

        harry.setRole("The boy who survived");

        characterRepository.save(harry);

        Optional<Character> characterResult = characterRepository.findById(harry.getId());

        assertNotNull(characterResult.get());
        assertEquals("The boy who survived", characterResult.get().getRole());
    }

    @Test
    @DisplayName("Find all characters")
    void testFindAll() {

        Character harry = Character.builder()
                .name("Harry Potter")
                .role("student")
                .school("Hogwarts School of Witchcraft and Wizardry")
                .idHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde")
                .patronus("stag")
                .build();

        Character neville = Character.builder()
                .name("Neville Longbottom")
                .role("student")
                .school("Hogwarts School of Witchcraft and Wizardry")
                .idHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde")
                .patronus("incorporeal")
                .build();

        characterRepository.save(harry);
        characterRepository.save(neville);

        List<Character> allCharacter = characterRepository.findAll();

        assertNotNull(allCharacter);
        assertTrue(allCharacter.size() >= 2);
    }

    @Test
    @DisplayName("Find specific character")
    void testFindById() {

        Character harry = Character.builder()
                .name("Harry Potter")
                .role("student")
                .school("Hogwarts School of Witchcraft and Wizardry")
                .idHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde")
                .patronus("stag")
                .build();

        Character neville = Character.builder()
                .name("Neville Longbottom")
                .role("student")
                .school("Hogwarts School of Witchcraft and Wizardry")
                .idHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde")
                .patronus("incorporeal")
                .build();

        characterRepository.save(harry);
        characterRepository.save(neville);

        Optional<Character> characterResult = characterRepository.findById(neville.getId());

        assertNotNull(characterResult.get());
        assertEquals("Neville Longbottom", characterResult.get().getName());
    }

    @Test
    @DisplayName("Find all Character queried by house")
    void testFindByHome() {

        Character harry = Character.builder()
                .name("Harry Potter")
                .role("student")
                .school("Hogwarts School of Witchcraft and Wizardry")
                .idHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde")
                .patronus("stag")
                .build();

        Character neville = Character.builder()
                .name("Neville Longbottom")
                .role("student")
                .school("Hogwarts School of Witchcraft and Wizardry")
                .idHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde")
                .patronus("incorporeal")
                .build();

        characterRepository.save(harry);
        characterRepository.save(neville);

        List<Character> allCharacters = characterRepository.findByIdHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde");

        assertNotNull(allCharacters);
        assertTrue(allCharacters.size() >= 2);
    }

    @Test
    @DisplayName("Delete character")
    void testDelete() {

        Character harry = Character.builder()
                .name("Harry Potter")
                .role("student")
                .school("Hogwarts School of Witchcraft and Wizardry")
                .idHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde")
                .patronus("stag")
                .build();

        characterRepository.save(harry);

        characterRepository.deleteById(harry.getId());

        Optional<Character> characterDeleted = characterRepository.findById(harry.getId());

        assertFalse(characterDeleted.isPresent());
    }
}