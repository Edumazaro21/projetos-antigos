package br.com.dextra.dextrachallenge.service;

import br.com.dextra.dextrachallenge.model.dto.CharacterDto;
import br.com.dextra.dextrachallenge.model.entity.Character;
import br.com.dextra.dextrachallenge.model.mapper.CharacterMapper;
import br.com.dextra.dextrachallenge.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CharacterService implements CharacterMapper {

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    HouseService houseService;

    @Autowired
    CharacterMapper characterMapper;

    @CacheEvict(cacheNames = "Characters", allEntries = true)
    public Character save(CharacterDto character) throws Exception {

        Character characterPersist = characterMapper.toEntity(character);

        houseService.validateIdHouse(characterPersist.getIdHouse());

        return characterRepository.save(characterPersist);
    }

    public List<Character> findAll() {

        return characterRepository.findAll();
    }

    @Cacheable(cacheNames = "Characters", key="#id")
    public Character findById(Long id) throws Exception {

        Optional<Character> character = characterRepository.findById(id);

        if (character.isPresent()) {
            return character.get();

        } else {
            throw new Exception("Character not found!");
        }
    }

    @Cacheable(cacheNames = "Characters", key="#idHouse")
    public List<Character> findByHouse(String idHouse) {

        return characterRepository.findByIdHouse(idHouse);
    }

    @CacheEvict(cacheNames = "Characters", key="#id")
    public Character delete(Long id) throws Exception {

        Optional<Character> character = characterRepository.findById(id);

        if (character.isPresent()) {
            characterRepository.deleteById(id);

            return character.get();

        } else {
            throw new Exception("Character not found!");
        }
    }

    @Override
    public Character toEntity(CharacterDto characterDto) {

        return Character.builder()
                .id(characterDto.getId())
                .idHouse(characterDto.getHouse())
                .name(characterDto.getName())
                .patronus(characterDto.getPatronus())
                .role(characterDto.getRole())
                .school(characterDto.getSchool())
                .build();
    }

    @Override
    public CharacterDto toDto(Character character) {
        return null;
    }
}
