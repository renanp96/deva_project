package com.api.deva.models.attributes;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
public class Attributes {
    private int vigor;
    private int mind;
    private int endurance;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int faith;
    private int luck;
    private int arcane;

    public Attributes(){}

    public Attributes(int vigor, int mind, int endurance, int strength, int dexterity, int intelligence, int faith, int luck, int arcane) {
        validate(vigor, mind, endurance, strength, dexterity, intelligence, faith, luck, arcane);
        this.vigor = vigor;
        this.mind = mind;
        this.endurance = endurance;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.faith = faith;
        this.luck = luck;
        this.arcane = arcane;
    }

    private void validate(int... values){
        for(int val : values) {
            if(val < 5) throw new IllegalArgumentException("Atributo não pode ser menor que 5");
        }
    }
}
