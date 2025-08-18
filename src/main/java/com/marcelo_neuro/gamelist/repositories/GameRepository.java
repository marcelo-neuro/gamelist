package com.marcelo_neuro.gamelist.repositories;

import com.marcelo_neuro.gamelist.etities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
