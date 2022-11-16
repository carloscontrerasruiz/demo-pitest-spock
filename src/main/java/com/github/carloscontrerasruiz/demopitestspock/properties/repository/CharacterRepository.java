package com.github.carloscontrerasruiz.demopitestspock.properties.repository;

import com.github.carloscontrerasruiz.demopitestspock.entity.CharacterEntity;

public interface CharacterRepository {
    CharacterEntity getCharacter(String characterName);
}
