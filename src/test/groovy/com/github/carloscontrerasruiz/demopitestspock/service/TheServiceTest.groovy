package com.github.carloscontrerasruiz.demopitestspock.service

import com.github.carloscontrerasruiz.demopitestspock.entity.CharacterEntity
import com.github.carloscontrerasruiz.demopitestspock.factory.TheFactory
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.pokemon.PokemonRepo
import spock.lang.Specification

class TheServiceTest extends Specification {
    TheFactory factory = Mock()
    TheService service = new TheService(factory)

    def "GetCharacterInfo"() {
        given: "Given"
        PokemonRepo repo = Mock()
        repo.getCharacter(_) >> CharacterEntity.builder().build()

        factory.getRightRepo(_) >> repo

        when: "When"
        def response = service.getCharacterInfo("Charizard", "pokemon")

        then: "Then"
        response != null
    }
}
