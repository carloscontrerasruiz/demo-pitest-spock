package com.github.carloscontrerasruiz.demopitestspock.factory;

import com.github.carloscontrerasruiz.demopitestspock.properties.RepositoriesProperties;
import com.github.carloscontrerasruiz.demopitestspock.properties.ShowsProperties;
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.CharacterRepository;
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.pokemon.PokemonRepo;
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.rick_morty.RickMortyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TheFactory {

    @Autowired
    private RickMortyRepo rickMortyRepo;

    @Autowired
    private PokemonRepo pokemonRepo;

    @Autowired
    private RepositoriesProperties repositoriesProperties;

    public CharacterRepository getRightRepo(String identifier) {
        Map<String, ShowsProperties> shows = repositoriesProperties.getShows();
        if (!shows.containsKey(identifier) || !shows.get(identifier).isActive()) {
            throw new IllegalArgumentException("Repository is not configured");
        }

        switch (identifier) {
            case "rick":
                return rickMortyRepo;
            case "pokemon":
                return pokemonRepo;
            default:
                throw new IllegalArgumentException("Repository not found");
        }
    }
}
