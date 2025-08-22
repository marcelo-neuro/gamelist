package com.marcelo_neuro.gamelist.services;

import com.marcelo_neuro.gamelist.dto.GameListDTO;
import com.marcelo_neuro.gamelist.etities.Belonging;
import com.marcelo_neuro.gamelist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
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

    @Transactional
    public LinkedList<Belonging> updatePositions(Long listId, int gamePosition, int finalPosition) {
        LinkedList<Belonging> belongings = repository.findBelongingByListId(listId);

        Belonging target = belongings.remove(gamePosition);
        belongings.add(finalPosition, target);

        int maxPosition = Math.max(gamePosition, finalPosition);
        int minPosition = Math.min(gamePosition, finalPosition);

        for (int i = minPosition; i < maxPosition; i++) {
            belongings.get(i).setPosition(i);
        }

        return repository.findBelongingByListId(listId);
    }
}
