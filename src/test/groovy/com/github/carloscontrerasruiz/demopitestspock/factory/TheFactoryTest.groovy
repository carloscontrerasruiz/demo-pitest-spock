package com.github.carloscontrerasruiz.demopitestspock.factory

import com.github.carloscontrerasruiz.demopitestspock.properties.RepositoriesProperties
import com.github.carloscontrerasruiz.demopitestspock.properties.ShowsProperties
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.pokemon.PokemonRepo
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.rick_morty.RickMortyRepo
import spock.lang.Specification

class TheFactoryTest extends Specification {

    RickMortyRepo rickMortyMock = Mock()
    PokemonRepo pokemonMock = Mock()
    RepositoriesProperties repositoriesPropertiesMock = Mock()

    TheFactory factory = new TheFactory(rickMortyMock, pokemonMock, repositoriesPropertiesMock)

    def "Get Right Repo | Rick Y Morty"() {
        given:
        ShowsProperties showsProperties = new ShowsProperties()
        showsProperties.setUrl("URL")
        showsProperties.setActive(true)

        Map<String, ShowsProperties> shows = new HashMap<>()
        shows.put("rick", showsProperties)

        repositoriesPropertiesMock.getShows() >> shows

        when:
        def repo = factory.getRightRepo("rick")

        then:
        repo instanceof RickMortyRepo

    }

    def "Get Right Repo | Pokemon"() {
        given:
        ShowsProperties showsProperties = new ShowsProperties()
        showsProperties.setUrl("URL")
        showsProperties.setActive(true)

        Map<String, ShowsProperties> shows = new HashMap<>()
        shows.put("pokemon", showsProperties)

        repositoriesPropertiesMock.getShows() >> shows

        when:
        def repo = factory.getRightRepo("pokemon")

        then:
        repo instanceof PokemonRepo

    }

    def "Get Right Repo | Repo not configured"() {
        given: "Property pokemon configured"
        ShowsProperties showsProperties = new ShowsProperties()
        showsProperties.setUrl("URL")
        showsProperties.setActive(true)

        Map<String, ShowsProperties> shows = new HashMap<>()
        shows.put("pokemon", showsProperties)

        repositoriesPropertiesMock.getShows() >> shows

        when: "We call the rick property"
        factory.getRightRepo("rick")

        then: "Exception throw"
        thrown IllegalArgumentException

    }
}
