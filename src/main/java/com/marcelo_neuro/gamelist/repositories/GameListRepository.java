package com.marcelo_neuro.gamelist.repositories;

import com.marcelo_neuro.gamelist.etities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {

}
