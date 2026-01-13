package com.api.deva.mapper.player;

import com.api.deva.dto.player.PlayerCreateDTO;
import com.api.deva.dto.player.PlayerResponseDTO;
import com.api.deva.mapper.attributes.AttributesMapper;
import com.api.deva.models.character.CharacterClasses;
import com.api.deva.models.player.Player;

import java.time.LocalDateTime;

public class PlayerMapper {

    public static Player toEntity(PlayerCreateDTO dto) {
        Player player = new Player();

        CharacterClasses charClass = CharacterClasses.valueOf(dto.characterClass());

        player.setUsername(dto.username());
        player.setLevel(5);
        player.setRunes(100);
        player.setCharacterClass(charClass);
        player.setAttributes(charClass.createBaseAttributes());
        player.setCreatedAt(LocalDateTime.now());

        return player;
    }

    public static PlayerResponseDTO toDTO(Player player) {
        return new PlayerResponseDTO(
          player.getId(),
          player.getUsername(),
                player.getLevel(),
                player.getRunes(),
                player.getCharacterClass().name(),
                player.getCreatedAt(),
                AttributesMapper.toDTO(player.getAttributes())
        );
    }

}
