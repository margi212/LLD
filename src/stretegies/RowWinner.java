package stretegies;

import models.Board;

public class RowWinner implements WinningStretegies {
    Board board;

    public RowWinner(Board board) {
        this.board = board;
    }

    @Override
    public boolean execute(String symbol) {
        int n = board.getBoard().size();
        int m = board.getBoard().get(0).size();

        for (int cRow = 0; cRow < n; cRow++) {
            for (int col = 0; col < m; col++) {
                if (board.getBoard().get(cRow).get(col).getPlayer() == null ||
                        !board.getBoard().get(cRow).get(col).getPlayer().getSymbol().equals(symbol)) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
