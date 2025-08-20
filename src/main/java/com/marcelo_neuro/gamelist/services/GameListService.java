package com.marcelo_neuro.gamelist.services;

import com.marcelo_neuro.gamelist.dto.GameListDTO;
import com.marcelo_neuro.gamelist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    @Transactional
    public List<GameListDTO> findAll() {
        return repository.findAll()
                .stream().map(GameListDTO::new)
                .toList();
    }
}
