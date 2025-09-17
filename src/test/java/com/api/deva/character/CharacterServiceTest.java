package com.api.deva.character;

import com.api.deva.models.character.Character;
import com.api.deva.models.character.CharacterClasses;
import com.api.deva.repository.CharacterRepository;
import com.api.deva.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private CharacterService characterService;

    @Test
    void shouldCreateNewCharacterSuccessfully() {
        Character character = new Character("Artorias", CharacterClasses.WARRIOR);
        when(characterRepository.save(any(Character.class))).thenReturn(character);
        when(characterRepository.existsByName("Artorias")).thenReturn(false);

        Character savedCharacter = characterService.createNewCharacter(character);

        assertThat(savedCharacter.getName()).isEqualTo("Artorias");
        assertThat(savedCharacter.getCharacterClass()).isEqualTo(CharacterClasses.WARRIOR);
        verify(characterRepository).save(character);
    }

}
