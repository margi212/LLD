package models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Board {
    List<List<Cell>> board;

    public Board(int row,int col) {
        board = new ArrayList<>();

        for(int r=0;r<row;r++){
            board.add(new ArrayList<>());
            for(int c=0;c<col;c++) {
                board.get(r).add(new Cell(r, c));
            }
        }
    }

    public void display() {

        for (int row = 0; row < board.size(); row++) {
            for (int col = 0; col < board.get(row).size(); col++) {
                if(board.get(row).get(col).getPlayer()==null){
                    System.out.print("  |  ");
                }else{
                    System.out.print(board.get(row).get(col).getPlayer().getSymbol() + " | ");
                }
            }
            System.out.println();
        }
    }

    public boolean isBoardFull(){
        for (int row = 0; row < board.size(); row++) {
            for (int col = 0; col < board.get(row).size(); col++) {
                if (board.get(row).get(col).getPlayer() == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
