package com.marcelo_neuro.gamelist.services;

import com.marcelo_neuro.gamelist.dto.GameDTO;
import com.marcelo_neuro.gamelist.dto.GameMinDTO;
import com.marcelo_neuro.gamelist.etities.Game;
import com.marcelo_neuro.gamelist.repositories.GameRepository;
import com.marcelo_neuro.gamelist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return repository.findAll()
                .stream().map(GameMinDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Optional<Game> optionalGame = repository.findById(id);
        if(optionalGame.isEmpty()) {
            throw new ResourceNotFoundException("Recurso não encontrado ; id: " + id);
        }

        return new GameDTO(optionalGame.get());
    }
}
