package com.api.deva.models.player;

import com.api.deva.models.attributes.Attributes;
import com.api.deva.models.character.CharacterClasses;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deva_player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String username;

    private Integer level;
    private int runes;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "character_class")
    private CharacterClasses characterClass;

    @Embedded
    private Attributes attributes;

    @JsonCreator
    public Player(@JsonProperty("username") String username, @JsonProperty("characterClass") CharacterClasses characterClass){
        this.username = username;
        this.level = 5;
        this.runes = 100;
        this.createdAt = LocalDateTime.now();
        this.characterClass = characterClass;
        this.attributes = characterClass.createBaseAttributes();
    }

}
