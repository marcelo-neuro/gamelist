package com.marcelo_neuro.gamelist.repositories;

import com.marcelo_neuro.gamelist.etities.Belonging;
import com.marcelo_neuro.gamelist.etities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {


    @Query(value = """
            SELECT b
            FROM Belonging b
            WHERE b.id.list.id = :listId
            ORDER BY b.position
            """)
    LinkedList<Belonging> findBelongingByListId(Long listId);

    @Query(value = """
            UPDATE Belonging b
            SET b.position = :newPosition
            WHERE b.id.list.id = :listId AND b.id.game.id = :gameId
            """)
    void updateBelongingPosition(Long newPosition, Long listId, Long gameId);
}
