package com.github.carloscontrerasruiz.demopitestspock.controller;

import com.github.carloscontrerasruiz.demopitestspock.entity.CharacterEntity;
import com.github.carloscontrerasruiz.demopitestspock.service.TheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class TheController {

    @Autowired
    private TheService service;

    @GetMapping(value = "/{show}/{character}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterEntity> getCharacterByName(@PathVariable String show, @PathVariable String character) {
        CharacterEntity characterInfo = service.getCharacterInfo(character, show);
        return ResponseEntity.ok(characterInfo);
    }
}
