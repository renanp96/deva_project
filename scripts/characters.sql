CREATE TABLE deva_characters (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    nickname VARCHAR(255),
    level INT,
    experience INT,
    character_class VARCHAR(50) NOT NULL,
    vigor INT,
    mind INT,
    endurance INT,
    strength INT,
    dexterity INT,
    intelligence INT,
    faith INT,
    arcane INT,
    luck INT
);