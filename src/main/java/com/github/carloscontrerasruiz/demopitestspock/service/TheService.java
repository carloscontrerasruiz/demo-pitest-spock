package com.github.carloscontrerasruiz.demopitestspock.service;

import com.github.carloscontrerasruiz.demopitestspock.entity.CharacterEntity;
import com.github.carloscontrerasruiz.demopitestspock.factory.TheFactory;
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class TheService {

    private TheFactory factory;

    public TheService(TheFactory factory){
        this.factory = factory;
    }

    public CharacterEntity getCharacterInfo(String characterName, String identifier) {
        CharacterRepository characterRepo = factory.getRightRepo(identifier);
        CharacterEntity character = characterRepo.getCharacter(characterName);
        return character;
    }
}
