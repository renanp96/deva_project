package com.api.deva.service.character;

import com.api.deva.models.character.Character;
import com.api.deva.models.character.CharacterClasses;
import com.api.deva.repository.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTest {

    @Mock
    private CharacterRepository repository;

    @InjectMocks
    private  CharacterService service;

    @Test
    void shouldCreateCharacterSuccessfully() {
        Character character = new Character();
        character.setName("Frost");
        character.setCharacterClass(CharacterClasses.MAGE);

        when(repository.existsByName("Frost")).thenReturn(false);
        when(repository.save(any(Character.class))).thenReturn(character);

        Character saved = service.createNewCharacter(character);

        assertNotNull(saved);
        verify(repository).save(character);
    }

    @Test
    void shouldThrowExceptionWhenNameAlreadyExists() {
        Character character = new Character();

        character.setName("Frost");
        character.setCharacterClass(CharacterClasses.MAGE);

        when(repository.existsByName("Frost")).thenReturn(true);

        assertThrows(RuntimeException.class, () -> service.createNewCharacter(character));

        verify(repository, never()).save(any());
    }

    @Test
    void shouldThrowExceptionWhenNameIsBlank() {
        Character character = new Character();

        character.setName(" ");
        character.setCharacterClass(CharacterClasses.MAGE);

        assertThrows(IllegalArgumentException.class, () -> {
            service.createNewCharacter(character);
        });
    }
}
