package com.api.deva.controllers.enemy;

import com.api.deva.dto.enemy.EnemyCreateDTO;
import com.api.deva.dto.enemy.EnemyResponseDTO;
import com.api.deva.mapper.enemy.EnemyMapper;
import com.api.deva.models.enemy.Enemy;
import com.api.deva.service.enemy.EnemyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enemy")
@Tag(name = "Enemy", description = "End-point para criação de inimigos e chefes")
public class EnemyController {

    private final EnemyService service;

    public EnemyController(EnemyService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Lista todos os inimigos e chefes")
    public List<EnemyResponseDTO> getAllEnemies() {
        return service.getAllEnemies().stream().map(EnemyMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna as infos do inimigo de acordo com o ID")
    public ResponseEntity<EnemyResponseDTO> getEnemyById(@PathVariable Long id) {
        return service.getEnemyById(id).map(EnemyMapper::toDTO).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo inimigo/chefe")
    public ResponseEntity<EnemyResponseDTO> createNewEnemy(@RequestBody EnemyCreateDTO dto) {
        Enemy entity = EnemyMapper.toEntity(dto);
        Enemy create = service.createEnemy(entity);

        return ResponseEntity.ok(EnemyMapper.toDTO(create));
    }
}
