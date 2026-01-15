package com.api.deva.mapper.character;

import com.api.deva.dto.attributes.AttributesDTO;
import com.api.deva.mapper.attributes.AttributesMapper;
import com.api.deva.models.attributes.Attributes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtrributesMapperTest {
    @Test
    void shouldConvertAttributesEntityToDTO() {
        Attributes attributes = new Attributes(10,10,10,10,10,10,10,10,10);
        AttributesDTO dto = AttributesMapper.toDTO(attributes);

        assertEquals(10, dto.vigor());
    }
}
