package com.api.deva.dto.character;

import com.api.deva.dto.attributes.AttributesDTO;

public record CharacterResponseDTO(
        Long id,
        String name,
        String nickname,
        Integer level,
        String characterClass,
        AttributesDTO attributes
) { }
