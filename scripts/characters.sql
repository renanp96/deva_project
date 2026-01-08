CREATE TABLE deva_characters (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,

                                 name VARCHAR(100) NOT NULL,

                                 character_class VARCHAR(30) NOT NULL,

    -- Attributes (Embeddable)
                                 vigor INT NOT NULL,
                                 mind INT NOT NULL,
                                 endurance INT NOT NULL,
                                 strength INT NOT NULL,
                                 dexterity INT NOT NULL,
                                 intelligence INT NOT NULL,
                                 faith INT NOT NULL,
                                 luck INT NOT NULL,
                                 arcane INT NOT NULL,

                                 CONSTRAINT chk_attributes_non_negative CHECK (
                                     vigor >= 0 AND
                                     mind >= 0 AND
                                     endurance >= 0 AND
                                     strength >= 0 AND
                                     dexterity >= 0 AND
                                     intelligence >= 0 AND
                                     faith >= 0 AND
                                     luck >= 0 AND
                                     arcane >= 0
                                     )
);