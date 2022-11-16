package com.github.carloscontrerasruiz.demopitestspock.service;

import com.github.carloscontrerasruiz.demopitestspock.entity.CharacterEntity;
import com.github.carloscontrerasruiz.demopitestspock.factory.TheFactory;
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheService {

    @Autowired
    private TheFactory factory;

    public CharacterEntity getCharacterInfo(String characterName, String identifier) {
        CharacterRepository characterRepo = factory.getRightRepo(identifier);
        CharacterEntity character = characterRepo.getCharacter(characterName);
        return character;
    }
}
