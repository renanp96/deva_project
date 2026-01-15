package com.api.deva.mapper.character;

import com.api.deva.dto.player.PlayerCreateDTO;
import com.api.deva.mapper.player.PlayerMapper;
import com.api.deva.models.character.CharacterClasses;
import com.api.deva.models.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerMapperTest {

    @Test
    void shouldConvertCreateDTOToEntity() {
        PlayerCreateDTO dto = new PlayerCreateDTO(
          "Miin",
          "WARRIOR"
        );

        Player player = PlayerMapper.toEntity(dto);

        assertNotNull(player);
        assertEquals("Miin", player.getUsername());
        assertEquals(CharacterClasses.WARRIOR, player.getCharacterClass());

        assertNotNull(player.getAttributes());
    }
}
