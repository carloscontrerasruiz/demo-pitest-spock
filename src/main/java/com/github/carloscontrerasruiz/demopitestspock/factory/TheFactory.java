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

    private RickMortyRepo rickMortyRepo;
    private PokemonRepo pokemonRepo;
    private RepositoriesProperties repositoriesProperties;

    public TheFactory(RickMortyRepo rickMortyRepo, PokemonRepo pokemonRepo, RepositoriesProperties repositoriesProperties) {
        this.rickMortyRepo = rickMortyRepo;
        this.pokemonRepo = pokemonRepo;
        this.repositoriesProperties = repositoriesProperties;
    }

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
