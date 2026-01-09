package com.api.deva.controllers.player;

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

    @Autowired
    private PlayerService service;

    @GetMapping
    @Operation(summary = "Retorna a lista de todos os jogadores")
    public List<Player> getAllPlayers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um jogador especifico pelo seu Id")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = service.findById(id);
        return player.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    @Operation(summary = "Registra um novo jogador")
    public Player registerNewPlayer(@RequestBody Player player) {
        return service.createNewPlayer(player);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Renomeia o nome do jogador")
    public ResponseEntity<Player> renamePlayerUserName(@PathVariable Long id, @RequestBody Player username) {
        try {
            Player player = service.renamePlayerUsername(id, username);
            return ResponseEntity.ok(player);
        } catch (RuntimeException err) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta o jogador da base de dados")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        service.deletePlayerById(id);
        return ResponseEntity.notFound().build();
    }

}
