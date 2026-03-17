package com.api.deva.service.enemy;

import com.api.deva.models.enemy.Enemy;
import com.api.deva.models.greaterEnemy.GreaterEnemy;
import com.api.deva.repository.enemy.EnemyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnemyService {

    private final EnemyRepository repository;

    public EnemyService(EnemyRepository repository) {
        this.repository = repository;
    }

    public List<Enemy> getAllEnemies() {
        return repository.findAll();
    }

    public List<GreaterEnemy> getAllGreaterEnemies() {
        return repository.findAllGreaterEnemy();
    }

    public Optional<Enemy> getEnemyById(Long id) {
        return repository.findById(id);
    }

    public Enemy createEnemy(Enemy enemy) {
        if(enemy instanceof GreaterEnemy greaterEnemy) {
            validateGreaterEnemy(greaterEnemy);
        }
        return repository.save(enemy);
    }

    private void validateGreaterEnemy(GreaterEnemy greaterEnemy) {
        if(greaterEnemy.getPhaseCount() < 2){
            throw new IllegalArgumentException("O boss deve ter pelo menos duas fases");
        }
    }

}
