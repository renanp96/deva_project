package com.api.deva.controllers;

import com.api.deva.models.character.Character;
import com.api.deva.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacterById(@RequestParam Long id) {
        Optional<Character> character = characterService.findById(id);
        return character.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{characterClass}")
    public List<Character> getCharactersByClass(@RequestParam String characterClass) {
        return characterService.findByClass(characterClass);
    }

    @PostMapping("/create")
    public Character createCharacter(@RequestBody Character character) {
        return characterService.createNewCharacter(character);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@RequestParam Long id, @RequestBody Character characterDetails) {
        try {
            Character updatedCharacter = characterService.updateCharacter(id, characterDetails);
            return ResponseEntity.ok(updatedCharacter);
        } catch (RuntimeException err) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@RequestParam Long id) {
        characterService.deleteCharacterById(id);
        return ResponseEntity.noContent().build();
    }
}
