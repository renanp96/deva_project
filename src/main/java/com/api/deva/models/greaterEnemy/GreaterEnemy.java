package com.api.deva.models.greaterEnemy;

import com.api.deva.models.enemy.Enemy;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("GREATER")
public class GreaterEnemy extends Enemy {

    private int phaseCount;
    private boolean isLegendary;
    private boolean isOptional;

    @NotBlank
    private String lore;

    @JsonCreator
    public GreaterEnemy(
            @JsonProperty("phaseCount") int phaseCount,
            @JsonProperty("isLegendary") boolean isLegendary,
            @JsonProperty("isOptional") boolean isOptional,
            @JsonProperty("lore") String lore
    ) {
        this.phaseCount = phaseCount;
        this.isLegendary = isLegendary;
        this.isOptional = isOptional;
        this.lore = lore;
    }

}
