package com.api.deva.repository;

import com.api.deva.models.character.Character;
import com.api.deva.models.character.CharacterClasses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Optional<Character> findByName(String name);
    List<Character> findByCharacterClass(CharacterClasses characterClass);
    boolean existsByName(String name);
}
