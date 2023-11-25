package stretegies;

import models.Board;

public class DiagonalWinner2 implements WinningStretegies {
    Board board;

    public DiagonalWinner2(Board board) {
        this.board = board;
    }

    @Override
    public boolean execute(String symbol) {
        int n = board.getBoard().size();
        int m = board.getBoard().get(0).size();

        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (board.getBoard().get(row).get(col).getPlayer() == null ||
                    !board.getBoard().get(row).get(col).getPlayer().getSymbol().equals(symbol)) {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }
}
