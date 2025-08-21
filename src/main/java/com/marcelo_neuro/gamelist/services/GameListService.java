package com.marcelo_neuro.gamelist.services;

import com.marcelo_neuro.gamelist.dto.GameListDTO;
import com.marcelo_neuro.gamelist.etities.Belonging;
import com.marcelo_neuro.gamelist.etities.Game;
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

    // incompleto
    @Transactional
    public List<Belonging> updatePosition(Long listId, Long gameID, Integer finalPosition) {
        List<Belonging> belongings = repository.querry(listId);

        Belonging game = belongings
                .stream().filter(b -> b.getId().getGame().getId().equals(gameID))
                .toList().getFirst();

        for (int i = 0; i < belongings.size() ; i++) {

            if(i < game.getPosition()) {
                continue;
            }

            if(i > finalPosition + 1) {
                break;
            }

            belongings.get(i).setPosition(belongings.get(i).getPosition() + 1);


        }
        return belongings;
    }
}
