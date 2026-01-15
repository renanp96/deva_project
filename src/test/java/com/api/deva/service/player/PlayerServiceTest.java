package com.api.deva.service.player;

import com.api.deva.models.character.CharacterClasses;
import com.api.deva.models.player.Player;
import com.api.deva.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.parameters.P;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
public class PlayerServiceTest {

    @Mock
    private PlayerRepository repository;

    @InjectMocks
    private PlayerService service;

    @Test
    void shouldCreateNewPlayerSuccessfully() {
        Player player = new Player();
        player.setUsername("Miin");
        player.setCharacterClass(CharacterClasses.WARRIOR);

        when(repository.existsByUsername("Miin")).thenReturn(false);
        when(repository.save(any(Player.class))).thenReturn(player);

        Player saved = service.createNewPlayer(player);

        assertNotNull(saved);
        verify(repository).save(player);
    }

    @Test
    void shouldThrowExceptionWhenUsernameAlreadyExists(){
        Player player = new Player();
        player.setUsername("Miin");
        player.setCharacterClass(CharacterClasses.MAGE);

        when(repository.existsByUsername(anyString())).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
           service.createNewPlayer(player);
        });

        assertEquals("Nome do jogador já foi escolhido", exception.getMessage());

        verify(repository).existsByUsername("Miin");
        verify(repository, never()).save(any());
    }

    @Test
    void shouldDeletePlayerById() {
        Long id = 1L;

        when(repository.existsById(id)).thenReturn(true);

        service.deletePlayerById(id);

        verify(repository).deleteById(id);
    }
}
