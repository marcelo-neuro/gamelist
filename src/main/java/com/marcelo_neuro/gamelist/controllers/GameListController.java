package com.marcelo_neuro.gamelist.controllers;

import com.marcelo_neuro.gamelist.dto.GameListDTO;
import com.marcelo_neuro.gamelist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "lists")
public class GameListController {

    @Autowired
    private GameListService service;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        List<GameListDTO> result = service.findAll();
        return ResponseEntity.ok(result);
    }
}
