package com.api.deva.dto.enemy;

import com.api.deva.dto.attributes.AttributesDTO;

public record EnemyCreateDTO(
        Long id,
        String name,
        String race,
        String enemyClass,
        Integer level,
        int hp,
        int attack,
        int defense,
        AttributesDTO attributes
)
{ }
