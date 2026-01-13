package com.api.deva.models.character;

import com.api.deva.models.attributes.Attributes;
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
@Table(name = "deva_characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;
    private String nickname;
    private Integer level;

    @Enumerated(EnumType.STRING)
    @Column(name = "character_class")
    private CharacterClasses characterClass;

    @Embedded
    private Attributes attributes;

    @JsonCreator
    public Character(@JsonProperty("name") String name,
                     @JsonProperty("characterClass") CharacterClasses characterClass) {
        this.name = name;
        this.level = 5;
        this.characterClass = characterClass;
        this.attributes = characterClass.createBaseAttributes();
    }
}
