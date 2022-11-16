package com.github.carloscontrerasruiz.demopitestspock.properties.repository.rick_morty.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RickMortyCharacter {
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
    private String url;
}
