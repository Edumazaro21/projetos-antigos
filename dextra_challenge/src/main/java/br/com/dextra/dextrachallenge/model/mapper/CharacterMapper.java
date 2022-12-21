package br.com.dextra.dextrachallenge.model.mapper;

import br.com.dextra.dextrachallenge.model.dto.CharacterDto;
import br.com.dextra.dextrachallenge.model.entity.Character;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterMapper instance = Mappers.getMapper(CharacterMapper.class);

    Character toEntity(CharacterDto characterDto);

    CharacterDto toDto(Character character);
}
