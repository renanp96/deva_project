package com.api.deva.models.character;

import com.api.deva.models.attributes.Attributes;

import java.util.function.Supplier;

public enum CharacterClasses {
    WARRIOR(() -> new Attributes(
            22,
            10,
            20,
            28,
            14,
            6,
            6,
            10,
            5
    )),

    MAGE(() -> new Attributes(
            12,
            25,
            12,
            6,
            10,
            30,
            18,
            8,
            6
    )),

    ROGUE(() -> new Attributes(
            16,
            12,
            18,
            12,
            26,
            8,
            6,
            18,
            10
    )),

    SAMURAI(() -> new Attributes(
            20,
            12,
            20,
            16,
            28,
            8,
            6,
            18,
            12
    )),

    DRUID(() -> new Attributes(
            18,
            20,
            14,
            10,
            12,
            14,
            22,
            10,
            20
    )),

    MONK(() -> new Attributes(
            22,
            10,
            26,
            18,
            22,
            6,
            8,
            14,
            10
    )),

    HEALER(() -> new Attributes(
            14,
            26,
            12,
            6,
            10,
            14,
            30,
            8,
            6
    )),

    PALADIN(() -> new Attributes(
            24,
            14,
            18,
            22,
            10,
            8,
            26,
            10,
            6
    ));

    private final Supplier<Attributes> baseAttributes;

    CharacterClasses(Supplier<Attributes> baseAttributes) {
        this.baseAttributes = baseAttributes;
    }

    public Attributes createBaseAttributes() {
        return baseAttributes.get();
    }

}
