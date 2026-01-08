package com.api.deva.controllers.character;

import com.api.deva.models.character.Character;
import com.api.deva.service.character.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/npc")
@Tag(name = "Character", description = "End-point para criação de personagem")
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping
    @Operation(summary = "Lista todos os personagens")
    public List<Character> getAllCharacters() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna as infos do personagem utilizando o ID como parametro")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {
        Optional<Character> character = service.findById(id);
        return character.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo personagem")
    public Character createCharacter(@RequestBody Character character) {
        return service.createNewCharacter(character);
    }

    @PutMapping("/{id}")
    @Operation(summary = "renomeia o personagem")
    public ResponseEntity<Character> renameCharacter(@PathVariable Long id, @RequestBody Character characterName) {
        try{
            Character character = service.renameCharacter(id, characterName);
            return ResponseEntity.ok(character);
        } catch(RuntimeException err) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um personagem com base no ID informado")
    public ResponseEntity<Void> deleteCharacter(@RequestParam Long id) {
        service.deleteCharacterById(id);
        return ResponseEntity.noContent().build();
    }
}
