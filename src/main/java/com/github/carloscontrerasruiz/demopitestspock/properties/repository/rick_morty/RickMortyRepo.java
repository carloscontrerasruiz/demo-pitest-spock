package com.github.carloscontrerasruiz.demopitestspock.properties.repository.rick_morty;

import com.github.carloscontrerasruiz.demopitestspock.entity.CharacterEntity;
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.CharacterRepository;
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.rick_morty.dto.RickMortyCharacter;
import com.github.carloscontrerasruiz.demopitestspock.properties.repository.rick_morty.dto.RickMortyResponse;
import com.google.gson.Gson;
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
public class RickMortyRepo implements CharacterRepository {
    @Override
    public CharacterEntity getCharacter(String characterName) {
        try {
            HttpResponse<String> response = HttpClient.newBuilder().build()
                    .send(HttpRequest.newBuilder()
                                    .uri(new URI("https://rickandmortyapi.com/api/character/?name=" + characterName.trim().toLowerCase()))
                                    .GET()
                                    .timeout(Duration.ofMillis(1000))
                                    .build(),
                            HttpResponse.BodyHandlers.ofString()
                    );

            if (response.statusCode() != 200) {
                throw new IllegalArgumentException("Este personaje no existe");
            }

            RickMortyResponse character = new Gson().fromJson(response.body(), RickMortyResponse.class);

            if (character == null || character.getResults().length <= 0) {
                throw new IllegalArgumentException("Este personaje no existe");
            }

            return rickResponseToEntity(character);

        } catch (URISyntaxException | RestClientException | IOException | InterruptedException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    private CharacterEntity rickResponseToEntity(RickMortyResponse character) {
        RickMortyCharacter result = character.getResults()[0];
        return CharacterEntity.builder()
                .fullName(result.getName())
                .description("")
                .show("RICK & MORTY")
                .imageUrl(result.getImage())
                .build();
    }
}
