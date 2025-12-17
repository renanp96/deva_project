package com.api.deva.models.character;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "deva_characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    private String name;
    private String nickname;

    private Integer level;
    private Integer experience;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CharacterClasses characterClass;

    private Integer vigor;
    private Integer mind;
    private Integer endurance;
    private Integer strength;
    private Integer dexterity;
    private Integer intelligence;
    private Integer faith;
    private Integer arcane;
    private Integer luck;

    //TODO: implementar a enitade de itens
    //TODO: implementar os modificadores de level up

    public Character(String name, CharacterClasses characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        this.level = 5;
        this.experience = 0;
    }

    private void defaultAttributes() {
        this.vigor = 10;
        this.mind = 10;
        this.endurance = 10;
        this.strength = 10;
        this.dexterity = 10;
        this.intelligence = 10;
        this.faith = 10;
        this.luck = 10;
    }
}
