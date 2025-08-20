package com.marcelo_neuro.gamelist.repositories;

import com.marcelo_neuro.gamelist.etities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(value = """
            SELECT g
            FROM Game g
            JOIN Belonging b ON g.id = b.id.game.id
            WHERE b.id.list.id = :listId
            ORDER BY b.position
            """)
    List<Game> findByListId(Long listId);
}
