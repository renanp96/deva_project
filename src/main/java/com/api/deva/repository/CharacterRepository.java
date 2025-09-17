package com.api.deva.repository;

import com.api.deva.models.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Optional<Character> findByName(String name);
    List<Character> findByCharacterClass(String characterClass);
    List<Character> findByLevelGreaterThanEqual(Integer minLevel);
    boolean existsByName(String name);
}
