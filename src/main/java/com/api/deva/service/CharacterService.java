package com.api.deva.service;

import com.api.deva.models.character.Character;
import com.api.deva.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    //TODO: Implementar o conceito de SOLID e arquitetura Hexagonal

    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> findAll(){
        return characterRepository.findAll();
    }

    public Optional<Character> findById(Long id){
        return characterRepository.findById(id);
    }

    public List<Character> findByClass(String characterClass){
        return characterRepository.findByCharacterClass(characterClass);
    }

    public Character updateCharacter(Long id, Character characterDetails){
        Character character = characterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Character not found"));

        character.setName(characterDetails.getName());
        character.setNickname(characterDetails.getNickname());
        character.setExperience(characterDetails.getExperience());
        character.setLevel(characterDetails.getLevel());

        return characterRepository.save(character);
    }

    public Character createNewCharacter(Character character){
        if(characterRepository.existsByName(character.getName())){
            throw new RuntimeException("Character name already exists");
        }

        return characterRepository.save(character);
    }

    public void deleteCharacterById(Long id){
        characterRepository.deleteById(id);
    }
}
