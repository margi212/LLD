package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    int row;
    int col;
    Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
