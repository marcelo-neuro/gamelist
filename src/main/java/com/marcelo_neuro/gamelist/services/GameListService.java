package com.marcelo_neuro.gamelist.services;

import com.marcelo_neuro.gamelist.dto.GameListDTO;
import com.marcelo_neuro.gamelist.etities.Game;
import com.marcelo_neuro.gamelist.repositories.GameListRepository;
import com.marcelo_neuro.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll()
                .stream().map(GameListDTO::new)
                .toList();
    }

    @Transactional
    public void updatePositions(Long listId, int gamePosition, int finalPosition) {
        LinkedList<Game> games = gameRepository.findByListId(listId);

        Game object = games.remove(gamePosition);
        games.add(finalPosition, object);

        int maxPosition = Math.max(finalPosition, gamePosition);
        int minPosition = Math.min(finalPosition, gamePosition);

        for (int i = minPosition; i <= maxPosition; i++) {
            gameListRepository.updateBelongingPosition(i, listId, games.get(i).getId());
        }
    }
}
