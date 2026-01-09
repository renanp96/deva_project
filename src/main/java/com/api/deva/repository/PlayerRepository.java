package com.api.deva.repository;

import com.api.deva.models.character.Character;
import com.api.deva.models.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Character> findByUsername(String username);
    boolean existsByUsername(String username);
}
