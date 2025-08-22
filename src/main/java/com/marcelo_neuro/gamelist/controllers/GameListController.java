package com.marcelo_neuro.gamelist.controllers;

import com.marcelo_neuro.gamelist.dto.GameListDTO;
import com.marcelo_neuro.gamelist.dto.ReplacementDTO;
import com.marcelo_neuro.gamelist.etities.Belonging;
import com.marcelo_neuro.gamelist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{listId}/replace")
    public ResponseEntity<List<Belonging>> updatePositions(@PathVariable Long listId,
                                                           @RequestBody ReplacementDTO replacementDTO) {
        List<Belonging> result = service.updatePositions(listId, replacementDTO.getGamePosition(), replacementDTO.getFinalPosition());
        return ResponseEntity.ok(result);
    }
}
