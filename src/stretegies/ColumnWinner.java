package stretegies;

import models.Board;

public class ColumnWinner implements WinningStretegies {
    Board board;

    public ColumnWinner(Board board) {
        this.board = board;
    }

    @Override
    public boolean execute(String symbol) {
        int n = board.getBoard().size();
        int m = board.getBoard().get(0).size();

        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n; row++) {
                if (board.getBoard().get(row).get(col).getPlayer() == null ||
                        !board.getBoard().get(row).get(col).getPlayer().getSymbol().equals(symbol)) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }
}
