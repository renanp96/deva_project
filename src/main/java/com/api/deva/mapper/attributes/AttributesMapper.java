package com.api.deva.mapper.attributes;

import com.api.deva.dto.attributes.AttributesDTO;
import com.api.deva.models.attributes.Attributes;

public class AttributesMapper {

    public static Attributes toEntity(AttributesDTO dto) {
        return new Attributes(
                dto.vigor(),
                dto.mind(),
                dto.endurance(),
                dto.strength(),
                dto.dexterity(),
                dto.intelligence(),
                dto.faith(),
                dto.luck(),
                dto.arcane()
        );
    }

    public static AttributesDTO toDTO(Attributes attributes) {
        return new AttributesDTO(
          attributes.getVigor(),
          attributes.getMind(),
          attributes.getEndurance(),
          attributes.getStrength(),
          attributes.getDexterity(),
          attributes.getIntelligence(),
          attributes.getFaith(),
          attributes.getLuck(),
          attributes.getArcane()
        );
    }

}
