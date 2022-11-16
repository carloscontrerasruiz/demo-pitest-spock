package com.github.carloscontrerasruiz.demopitestspock.properties.repository.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PokemonCharacter {
    private int height;
    private int id;
    private String name;
    private Sprites sprites;
    private int weight;
}
