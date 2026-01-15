package com.api.deva.mapper.character;

import com.api.deva.dto.character.CharacterCreateDTO;
import com.api.deva.models.character.Character;
import com.api.deva.models.character.CharacterClasses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CharacterMapperTest {

    @Test
    void shouldConvertCreateDTOToEntity() {
        CharacterCreateDTO dto = new CharacterCreateDTO(
                "Frost",
                "Ice Mage",
                10,
                "MAGE"
        );

        Character character = CharacterMapper.toEntity(dto);

        assertNotNull(character);
        assertEquals("Frost", character.getName());
        assertEquals("Ice Mage", character.getNickname());
        assertEquals(10, character.getLevel());
        assertEquals(CharacterClasses.MAGE, character.getCharacterClass());

        assertNotNull(character.getAttributes());
    }
}
