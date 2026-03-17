CREATE TABLE deva_enemy (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            enemy_race VARCHAR(50),
                            enemy_class VARCHAR(50),
                            level INT,
                            hp INT,
                            attack INT,
                            defense INT,
                            phase_count INT,
                            is_legendary BOOLEAN,
                            is_optional BOOLEAN,
                            lore TEXT,
                            dtype VARCHAR(31) NOT NULL
);
