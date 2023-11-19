package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Game {
    List<Player> playerList;
    Board board;
}
