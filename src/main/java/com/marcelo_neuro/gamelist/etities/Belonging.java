package com.marcelo_neuro.gamelist.etities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPK id;
    private Integer position;

    public Belonging(Game game, GameList list, Integer position) {
        this.id = new BelongingPK(game, list);
        this.position = position;
    }
}
