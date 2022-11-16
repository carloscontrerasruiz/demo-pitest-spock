package com.github.carloscontrerasruiz.demopitestspock.properties.repository.pokemon;

import com.github.carloscontrerasruiz.demopitestspock.entity.CharacterEntity;
import com.github.carloscontrerasruiz.demopitestspock.properties.RepositoriesProperties;
import com.github.carloscontrerasruiz.demopitestspock.properties.ShowsProperties;
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.CharacterRepository;
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.pokemon.dto.PokemonCharacter;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Repository
public class PokemonRepo implements CharacterRepository {

    @Autowired
    private RepositoriesProperties repositoriesProperties;

    @Override
    public CharacterEntity getCharacter(String characterName) {
        ShowsProperties shows = repositoriesProperties.getShows().get("pokemon");
        try {
            HttpResponse<String> response = HttpClient.newBuilder().build()
                    .send(HttpRequest.newBuilder()
                                    .uri(new URI(shows.getUrl() + characterName.trim().toLowerCase()))
                                    .GET()
                                    .timeout(Duration.ofMillis(1000))
                                    .build(),
                            HttpResponse.BodyHandlers.ofString()
                    );

            if (response.statusCode() != 200) {
                throw new IllegalArgumentException("Este pokemon no existe");
            }

            PokemonCharacter pokemonCharacter = new Gson().fromJson(response.body(), PokemonCharacter.class);

            if (pokemonCharacter == null) {
                throw new IllegalArgumentException("Este pokemon no existe");
            }

            return pokemonResponseToEntity(pokemonCharacter);

        } catch (URISyntaxException | RestClientException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    private CharacterEntity pokemonResponseToEntity(PokemonCharacter character) {
        return CharacterEntity.builder()
                .fullName(character.getName())
                .description("")
                .show("POKEMON")
                .imageUrl(character.getSprites().getFrontDefault())
                .build();
    }
}
