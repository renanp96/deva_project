CREATE TABLE deva_player (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             username VARCHAR(100) NOT NULL,
                             level INT,
                             runes INT NOT NULL DEFAULT 0,
                             created_at DATETIME NOT NULL,
                             character_class VARCHAR(50),
    -- Embedded Attributes
                             vigor INT NOT NULL,
                             mind INT NOT NULL,
                             endurance INT NOT NULL,
                             strength INT NOT NULL,
                             dexterity INT NOT NULL,
                             intelligence INT NOT NULL,
                             faith INT NOT NULL,
                             luck INT NOT NULL,
                             arcane INT NOT NULL
);
