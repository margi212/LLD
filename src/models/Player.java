package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    int id;
    String name;
    String symbol;
    public Player(int id, String name, String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }
}
