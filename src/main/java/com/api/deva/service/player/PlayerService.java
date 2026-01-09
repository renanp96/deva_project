package com.api.deva.service.player;

import com.api.deva.models.character.CharacterClasses;
import com.api.deva.models.player.Player;
import com.api.deva.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public List<Player> findAll() {
        return repository.findAll();
    }

    public Optional<Player> findById(Long id) {
        return repository.findById(id);
    }

    public Player createNewPlayer(Player player) {
        validate(player.getUsername(), player.getCharacterClass());

        if(repository.existsByUsername(player.getUsername())) {
            throw new RuntimeException("Nome do jogador já foi escolhido");
        }

        return repository.save(player);
    }

    public Player renamePlayerUsername(Long id, Player username) {
        Player player = repository.findById(id).orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
        player.setUsername(username.getUsername());
        return repository.save(player);
    }

    public void deletePlayerById(Long id) {
        repository.deleteById(id);
    }

    private void validate(String name, CharacterClasses characterClass) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome do jogador é obrigatório");
        }
        if (characterClass == null) {
            throw new IllegalArgumentException("Classe do jogador é obrigatória");
        }
    }

}
