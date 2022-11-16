package com.github.carloscontrerasruiz.demopitestspock.properties.repository.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sprites {
    private String backDefault;
    private String backFemale;
    private String backShiny;
    private String backShinyFemale;
    private String frontDefault;
    private String frontFemale;
    private String frontShiny;
    private String frontShinyFemale;
}
