import models.Board;
import models.Cell;
import models.Player;
import stretegies.*;

import java.util.*;

/*
Requirement:
-> we are going to implement a game for n players which has option to choose name,id and symbol.
-> number of symbols
-> n*n boardSize
-> winning condition(row matches/column match/ diagonal match)
-> Undo option(optional)

Classes:
1) Game
	List<Player> players
	Board board;

2) Player
	String name;
	int id;
	Symbol symbol;

3) Symbol Enum

4) Board
	int[][] board;

 */
public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Row&Cols for board size:");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        Board board = new Board(row, col);
        System.out.println("Enter No of Players:");
        int players = scanner.nextInt();

        List<Player> playerList = new ArrayList<>();
        Queue<Player> playerQueue = new ArrayDeque<>();

        for (int player = 0; player < players; player++) {
            System.out.println("Enter Name of P" + player);
            String s = scanner.next();
            System.out.println("Enter Symbol of P" + player);
            String ch = scanner.next();
            Player cPlayer = new Player(player, s, ch);
            playerList.add(cPlayer);
            playerQueue.add(cPlayer);
        }

        board.display();

        System.out.println(startGame(board, playerList, scanner, playerQueue));
    }

    public static String startGame(Board board, List<Player> playerList, Scanner scanner, Queue<Player> playerQueue) {
        List<WinningStretegies> stretegies = new ArrayList<>();
        stretegies.add(new ColumnWinner(board));
        stretegies.add(new RowWinner(board));
        stretegies.add(new DiagonalWinner1(board));
        stretegies.add(new DiagonalWinner2(board));

        while (!board.isBoardFull()) {
            Player cPlayer = playerQueue.remove();
            System.out.println("Enter Row & Col to set Symbol for player: " + cPlayer.getName());
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Cell cell = board.getBoard().get(row).get(col);
            cell.setPlayer(cPlayer);
            for (WinningStretegies winningStretegies : stretegies) {
                boolean isWinner = winningStretegies.execute(cPlayer.getSymbol());
                if (isWinner) {
                    System.out.println("Winner is:" + cPlayer.getName());
                    return cPlayer.getName();
                }
            }

            playerQueue.add(cPlayer);
            board.display();

        }
        return "tie";
    }

}
