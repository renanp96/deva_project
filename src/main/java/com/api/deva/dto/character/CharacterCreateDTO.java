package com.api.deva.dto.character;

import com.api.deva.models.attributes.Attributes;

public record CharacterCreateDTO(
        String name,
        String nickname,
        Integer level,
        String characterClass,
        Attributes attributes
) { }
