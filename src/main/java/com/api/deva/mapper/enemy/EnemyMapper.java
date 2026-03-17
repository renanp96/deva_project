package com.api.deva.mapper.enemy;

import com.api.deva.dto.enemy.EnemyCreateDTO;
import com.api.deva.dto.enemy.EnemyResponseDTO;
import com.api.deva.models.character.CharacterClasses;
import com.api.deva.models.enemy.Enemy;
import com.api.deva.models.enemy.EnemyRace;

public class EnemyMapper {
    public static Enemy toEntity(EnemyCreateDTO dto) {
        Enemy enemy = new Enemy();

        CharacterClasses enemyClass;
        EnemyRace race;

        try {
            enemyClass = CharacterClasses.valueOf(dto.enemyClass().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Classe inválida");
        }

        try {
            race = EnemyRace.valueOf(dto.race().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Raça inválida");
        }

        enemy.setName(dto.name());
        enemy.setRace(race);
        enemy.setEnemyClass(enemyClass);
        enemy.setLevel(dto.level());
        enemy.setHp(dto.hp());
        enemy.setAttack(dto.attack());
        enemy.setDefense(dto.defense());

        return enemy;
    }

    public static EnemyResponseDTO toDTO(Enemy enemy) {
        return new EnemyResponseDTO(
                enemy.getId(),
                enemy.getName(),
                enemy.getRace().name(),
                enemy.getEnemyClass().name(),
                enemy.getLevel(),
                enemy.getHp(),
                enemy.getAttack(),
                enemy.getDefense()
        );
    }

}
