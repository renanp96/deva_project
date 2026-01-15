package com.api.deva.dto.character;

import com.api.deva.dto.attributes.AttributesDTO;

public record CharacterCreateDTO(
        String name,
        String nickname,
        Integer level,
        String characterClass
) { }
