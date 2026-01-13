package com.api.deva.mapper.character;

import com.api.deva.dto.character.CharacterCreateDTO;
import com.api.deva.dto.character.CharacterResponseDTO;
import com.api.deva.mapper.attributes.AttributesMapper;
import com.api.deva.models.character.Character;
import com.api.deva.models.character.CharacterClasses;

public class CharacterMapper {
    public static Character toEntity(CharacterCreateDTO dto) {
        Character character = new Character();

        CharacterClasses charClass;
        try {
            charClass = CharacterClasses.valueOf(dto.characterClass().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Classe de personagem inválida");
        }

        character.setName(dto.name());
        character.setNickname(dto.nickname());
        character.setLevel(5);
        character.setCharacterClass(charClass);
        character.setAttributes(charClass.createBaseAttributes());

        return character;
    }

    public static CharacterResponseDTO toDTO(Character character) {
        return new CharacterResponseDTO(
          character.getId(),
                character.getName(),
                character.getNickname(),
                character.getLevel(),
                character.getCharacterClass().name(),
                AttributesMapper.toDTO(character.getAttributes())
        );
    }
}
