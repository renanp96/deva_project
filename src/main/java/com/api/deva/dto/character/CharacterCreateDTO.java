package com.api.deva.dto.character;

public record CharacterCreateDTO(
        String name,
        String nickname,
        Integer level,
        String characterClass
) { }
