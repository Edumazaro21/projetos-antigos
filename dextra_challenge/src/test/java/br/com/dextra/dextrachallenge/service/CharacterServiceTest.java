package br.com.dextra.dextrachallenge.service;

import br.com.dextra.dextrachallenge.model.dto.CharacterDto;
import br.com.dextra.dextrachallenge.model.entity.Character;
import br.com.dextra.dextrachallenge.model.mapper.CharacterMapper;
import br.com.dextra.dextrachallenge.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CharacterServiceTest {

    @InjectMocks
    private CharacterService characterService;

    @Mock
    private HouseService houseService;

    @Mock
    private CharacterMapper characterMapper;

    @Mock
    private CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {

        Character harry = Character.builder()
                .id(1L)
                .name("Harry Potter")
                .role("student")
                .school("Hogwarts School of Witchcraft and Wizardry")
                .idHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde")
                .patronus("stag")
                .build();

        BDDMockito.when(characterRepository.save(ArgumentMatchers.any(Character.class)))
                .thenReturn(harry);

        Mockito.when(characterMapper.toEntity(ArgumentMatchers.any(CharacterDto.class)))
                        .thenReturn(harry);

        BDDMockito.when(characterRepository.findAll()).thenReturn(Arrays.asList(harry));

        BDDMockito.when(characterRepository.findById(ArgumentMatchers.anyLong())).
                thenReturn(Optional.of(harry));

        BDDMockito.when(characterRepository.findByIdHouse(ArgumentMatchers.anyString()))
                .thenReturn(Arrays.asList(harry));

        BDDMockito.doNothing().when(characterRepository).deleteById(ArgumentMatchers.anyLong());
    }

    @Test
    @DisplayName("Save character")
    void save() throws Exception {

        CharacterDto harryDto = CharacterDto.builder()
                .name("Harry Potter")
                .role("student")
                .school("Hogwarts School of Witchcraft and Wizardry")
                .house("1760529f-6d51-4cb1-bcb1-25087fce5bde")
                .patronus("stag")
                .build();

        Character character = characterService.save(harryDto);

        assertTrue(character.getId() > 0L);
    }

    @Test
    @DisplayName("Find all characters")
    void findAll() {

        List<Character> allCharacters = characterService.findAll();

        assertNotNull(allCharacters);
        assertEquals(1, allCharacters.size());
    }

    @Test
    @DisplayName("Find specific characters")
    void findById() throws Exception {

        Character character = characterService.findById(1L);

        assertNotNull(character);
        assertEquals("Harry Potter", character.getName());
    }

    @Test
    @DisplayName("Find all Character queried by house")
    void findByHouse() {

        List<Character> allCharacters = characterService.findByHouse("1760529f-6d51-4cb1-bcb1-25087fce5bde");

        assertNotNull(allCharacters);
        assertEquals(1, allCharacters.size());
    }

    @Test
    @DisplayName("Delete character")
    void delete() throws Exception {

        assertDoesNotThrow(() -> characterService.delete(1L));
    }
}