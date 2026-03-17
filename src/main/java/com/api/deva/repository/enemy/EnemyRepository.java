package com.api.deva.repository.enemy;

import com.api.deva.models.enemy.Enemy;
import com.api.deva.models.greaterEnemy.GreaterEnemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnemyRepository extends JpaRepository<Enemy, Long> {
    @Query("select g from GreaterEnemy g")
    List<GreaterEnemy> findAllGreaterEnemy();
}
