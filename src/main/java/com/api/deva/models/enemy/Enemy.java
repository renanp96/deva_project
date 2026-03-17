package com.api.deva.models.enemy;


import com.api.deva.models.attributes.Attributes;
import com.api.deva.models.character.CharacterClasses;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deva_enemy")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public class Enemy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "enemy_race")
    private EnemyRace race;

    @Enumerated(EnumType.STRING)
    @Column(name = "enemy_class")
    private CharacterClasses enemyClass;

    @NotNull
    private Integer level;
    @NotNull
    private int hp;
    @NotNull
    private int attack;
    @NotNull
    private int defense;

    @JsonCreator
    public Enemy(
            @JsonProperty("name") String name,
            @JsonProperty("race") EnemyRace race,
            @JsonProperty("enemyClass") CharacterClasses enemyClass,
            @JsonProperty("level") Integer level,
            @JsonProperty("hp") int hp,
            @JsonProperty("attack") int attack,
            @JsonProperty("defense") int defense
    ){
        this.name = name;
        this.race = race;
        this.enemyClass = enemyClass;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

}
