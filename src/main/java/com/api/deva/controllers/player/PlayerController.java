package com.api.deva.controllers.player;

import com.api.deva.dto.player.PlayerCreateDTO;
import com.api.deva.dto.player.PlayerResponseDTO;
import com.api.deva.mapper.player.PlayerMapper;
import com.api.deva.models.player.Player;
import com.api.deva.service.player.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/player")
@Tag(name = "Character", description = "End-point para cadastro de jogadores")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Retorna a lista de todos os jogadores")
    public List<PlayerResponseDTO> getAllPlayers() {
        return service.findAll()
                .stream()
                .map(PlayerMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um jogador especifico pelo seu Id")
    public PlayerResponseDTO getPlayerById(@PathVariable Long id) {
        return PlayerMapper.toDTO(service.findById(id));
    }

    @PostMapping("/register")
    @Operation(summary = "Registra um novo jogador")
    public PlayerResponseDTO registerNewPlayer(@RequestBody PlayerCreateDTO dto) {
       Player player = PlayerMapper.toEntity(dto);
       return PlayerMapper.toDTO(service.createNewPlayer(player));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Renomeia o nome do jogador")
    public PlayerResponseDTO renamePlayerUserName(@PathVariable Long id, @RequestBody PlayerCreateDTO dto) {
        Player player = service.renamePlayerUsername(id, dto.username());
        return PlayerMapper.toDTO(player);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta o jogador da base de dados")
    public void deletePlayerById(@PathVariable Long id) {
        service.deletePlayerById(id);
    }
}
