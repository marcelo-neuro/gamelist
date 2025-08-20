package com.marcelo_neuro.gamelist.dto;

import com.marcelo_neuro.gamelist.etities.GameList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.PropertyAccessorUtils;
import org.yaml.snakeyaml.introspector.PropertyUtils;

@Getter
@NoArgsConstructor
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }


}
