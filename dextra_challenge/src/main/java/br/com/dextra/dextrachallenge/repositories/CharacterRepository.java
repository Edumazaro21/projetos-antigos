package br.com.dextra.dextrachallenge.repositories;

import br.com.dextra.dextrachallenge.model.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    public List<Character> findByIdHouse(String idHouse);
}
