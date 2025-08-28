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
    private int position;

    public Belonging(Game game, GameList list, int position) {
        this.id = new BelongingPK(game, list);
        this.position = position;
    }
}
