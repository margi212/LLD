package stretegies;

import models.Board;

public class DiagonalWinner1 implements WinningStretegies {
    Board board;

    public DiagonalWinner1(Board board) {
        this.board = board;
    }

    @Override
    public boolean execute(String symbol) {
        int n = board.getBoard().size();
        int m = board.getBoard().get(0).size();

        int row = 0;
        int col = 0;
        while (row < n && col < m) {
            if (board.getBoard().get(row).get(col).getPlayer() == null ||
                    !board.getBoard().get(row).get(col).getPlayer().getSymbol().equals(symbol)) {
                return false;
            }
            row++;
            col++;
        }

        return true;
    }
}
