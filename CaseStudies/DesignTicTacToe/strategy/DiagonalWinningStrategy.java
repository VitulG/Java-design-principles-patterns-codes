package CaseStudies.DesignTicTacToe.strategy;

import CaseStudies.DesignTicTacToe.models.Board;
import CaseStudies.DesignTicTacToe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {
    private final Map<Character, Integer> leftDiagonalMap = new HashMap<>();
    private final Map<Character, Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        char playerSymbol = move.getPlayer().getPlayerSymbol().getSymbol();

        // condition for check left col
        if(row == col) {
            if(!leftDiagonalMap.containsKey(playerSymbol)) {
                leftDiagonalMap.put(playerSymbol, 0);
            }
            leftDiagonalMap.put(playerSymbol, leftDiagonalMap.get(playerSymbol) + 1);
        }

        if(row + col == board.getBoardSize()-1) {
            if(!rightDiagonalMap.containsKey(playerSymbol)) {
                rightDiagonalMap.put(playerSymbol, 0);
            }
            rightDiagonalMap.put(playerSymbol, rightDiagonalMap.get(playerSymbol) + 1);
        }

        if(row == col && leftDiagonalMap.get(playerSymbol) == board.getBoardSize()) {
            return true;
        }

        return row + col == board.getBoardSize() - 1 && rightDiagonalMap.get(playerSymbol) == board.getBoardSize();
    }
}
