package com.marcelo_neuro.gamelist.controllers;

import com.marcelo_neuro.gamelist.dto.GameMinDTO;
import com.marcelo_neuro.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll() {
        List<GameMinDTO> result = service.findAll();
        return ResponseEntity.ok(result);
    }
}
