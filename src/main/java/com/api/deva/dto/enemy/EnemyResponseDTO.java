package com.api.deva.dto.enemy;

public record EnemyResponseDTO(
        Long id,
        String name,
        String race,
        String enemyClass,
        Integer level,
        int hp,
        int attack,
        int defense
)
{ }
