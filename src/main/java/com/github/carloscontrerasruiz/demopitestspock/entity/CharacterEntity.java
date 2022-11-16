package com.github.carloscontrerasruiz.demopitestspock.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacterEntity {
    private String fullName;
    private String imageUrl;
    private String show;
    private String description;
}
