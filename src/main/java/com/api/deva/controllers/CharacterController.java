package com.api.deva.controllers;

import com.api.deva.models.character.Character;
import com.api.deva.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/character")
@Tag(name = "Character", description = "End-point para criação de personagem")
public class CharacterController {

    //TODO: Implementar o conceito de SOLID e arquitetura Hexagonal

    @Autowired
    private CharacterService characterService;

    @GetMapping
    @Operation(summary = "Lista todos os personagens")
    public List<Character> getAllCharacters() {
        return characterService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna os dados de um personagem utilizando o ID como parametro")
    public ResponseEntity<Character> getCharacterById(@RequestParam Long id) {
        Optional<Character> character = characterService.findById(id);
        return character.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{characterClass}")
    @Operation(summary = "Lista todos os personagens de um classe especifica")
    public List<Character> getCharactersByClass(@RequestParam String characterClass) {
        return characterService.findByClass(characterClass);
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo personagem")
    public Character createCharacter(@RequestBody Character character) {
        return characterService.createNewCharacter(character);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza os dados de um personagem utilizando seu ID como parametro")
    public ResponseEntity<Character> updateCharacter(@RequestParam Long id, @RequestBody Character characterDetails) {
        try {
            Character updatedCharacter = characterService.updateCharacter(id, characterDetails);
            return ResponseEntity.ok(updatedCharacter);
        } catch (RuntimeException err) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um personagem com base no ID informado")
    public ResponseEntity<Void> deleteCharacter(@RequestParam Long id) {
        characterService.deleteCharacterById(id);
        return ResponseEntity.noContent().build();
    }
}
