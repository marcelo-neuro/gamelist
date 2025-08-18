package com.marcelo_neuro.gamelist.services;

import com.marcelo_neuro.gamelist.dto.GameMinDTO;
import com.marcelo_neuro.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional
    public List<GameMinDTO> findAll() {
        return repository.findAll()
                .stream().map(GameMinDTO::new)
                .toList();
    }
}
