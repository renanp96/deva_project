package com.api.deva.service.character;

import com.api.deva.models.character.Character;
import com.api.deva.models.character.CharacterClasses;
import com.api.deva.repository.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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
        character.setLevel(10);
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
        character.setLevel(10);
        character.setCharacterClass(CharacterClasses.MAGE);

        when(repository.existsByName(anyString())).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
           service.createNewCharacter(character);
        });

        assertEquals("Nome do personagem já foi escolhido", exception.getMessage());

        verify(repository).existsByName("Frost");
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

    @Test
    void shouldThrowExceptionWhenLevelIsLessThanFive() {
        Character character = new Character();

        character.setName("Frost");
        character.setLevel(3);
        character.setCharacterClass(CharacterClasses.MAGE);

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.createNewCharacter(character)
        );

        assertEquals("O nivel do personagem deve ser maior ou igual a cinco", ex.getMessage());
    }

    @Test
    void shouldRenameCharacterSuccessfully() {
        Character existing = new Character();
        existing.setId(1L);
        existing.setName("Old");

        Character newName = new Character();
        newName.setName("New");

        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(existing)).thenReturn(existing);

        Character updated = service.renameCharacter(1L, newName);

        assertEquals("New", updated.getName());
        verify(repository).findById(1L);
        verify(repository).save(existing);
    }

    @Test
    void shouldThrowExceptionWhenRenamingNonExistingCharacter() {
        Character newName = new Character();
        newName.setName("New");

        when(repository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class, () -> service.renameCharacter(1L, newName)
        );

        assertEquals("Personagem não encontrado", exception.getMessage());
        verify(repository).findById(1L);
        verify(repository, never()).save(any());
    }

    @Test
    void shouldDeleteCharacterById() {
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(true);

        service.deleteCharacterById(id);

        verify(repository).deleteById(id);
    }

    @Test
    void shouldThrowExceptionWhenDeletingNonExistingCharacter() {
        when(repository.existsById(1L)).thenReturn(false);

        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> service.deleteCharacterById(1L)
        );

        assertEquals("Personagem não encontrado", ex.getMessage());
        verify(repository, never()).deleteById(any());
    }
}
