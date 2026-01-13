package com.api.deva.controllers.character;

import com.api.deva.dto.character.CharacterCreateDTO;
import com.api.deva.dto.character.CharacterResponseDTO;
import com.api.deva.mapper.CharacterMapper;
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

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Lista todos os personagens")
    public List<CharacterResponseDTO> getAllCharacters() {
        return service.findAll().stream().map(CharacterMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna as infos do personagem utilizando o ID como parametro")
    public ResponseEntity<CharacterResponseDTO> getCharacterById(@PathVariable Long id) {
        return service.findById(id).map(CharacterMapper::toDTO).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo personagem")
    public ResponseEntity<CharacterResponseDTO> createNewCharacter(@RequestBody CharacterCreateDTO dto) {
        Character entity = CharacterMapper.toEntity(dto);
        Character create = service.createNewCharacter(entity);

        return ResponseEntity.ok(CharacterMapper.toDTO(create));
    }

    @PutMapping("/{id}")
    @Operation(summary = "renomeia o personagem")
    public ResponseEntity<CharacterResponseDTO> renameCharacter(@PathVariable Long id, @RequestBody CharacterCreateDTO dto) {
        Character character = CharacterMapper.toEntity(dto);
        Character update = service.renameCharacter(id, character);

        return ResponseEntity.ok(CharacterMapper.toDTO(update));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um personagem com base no ID informado")
    public ResponseEntity<Void> deleteCharacter(@RequestParam Long id) {
        service.deleteCharacterById(id);
        return ResponseEntity.noContent().build();
    }
}
