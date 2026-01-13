package com.api.deva.dto.player;

import com.api.deva.dto.attributes.AttributesDTO;
import com.api.deva.models.attributes.Attributes;

import java.time.LocalDateTime;

public record PlayerResponseDTO(
        Long id,
        String username,
        Integer level,
        int runes,
        String characterClass,
        LocalDateTime createdAt,
        AttributesDTO attributes
) { }
