package com.api.deva.service.character;


import com.api.deva.models.character.Character;
import com.api.deva.models.character.CharacterClasses;
import com.api.deva.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public List<Character> findAll() {
        return repository.findAll();
    }

    public Optional<Character> findById(Long id){
        return repository.findById(id);
    }

    public Character createNewCharacter(Character character) {
        validate(character.getName(), character.getLevel(), character.getCharacterClass());

        if(repository.existsByName(character.getName())) {
            throw new RuntimeException("Nome do personagem já foi escolhido");
        }

        return repository.save(character);
    }

    public Character renameCharacter(Long id, Character characterName) {
        Character character = repository.findById(id).orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        character.setName(characterName.getName());

        return repository.save(character);
    }

    public void deleteCharacterById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Personagem não encontrado");
        }

        repository.deleteById(id);
    }

    private void validate(String name, Integer level, CharacterClasses characterClass) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome do personagem é obrigatório");
        }
        if(level < 5){
            throw new IllegalArgumentException("O nivel do personagem deve ser maior ou igual a cinco");
        }
        if (characterClass == null) {
            throw new IllegalArgumentException("Classe do personagem é obrigatória");
        }
    }
}
