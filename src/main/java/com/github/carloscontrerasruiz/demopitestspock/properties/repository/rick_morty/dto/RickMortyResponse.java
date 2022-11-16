package com.github.carloscontrerasruiz.demopitestspock.properties.repository.rick_morty.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RickMortyResponse {
    private RickMortyCharacter[] results;
}
