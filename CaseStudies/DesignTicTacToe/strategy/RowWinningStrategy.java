package CaseStudies.DesignTicTacToe.strategy;

import CaseStudies.DesignTicTacToe.models.Board;
import CaseStudies.DesignTicTacToe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {
    private final Map<Integer, Map<Character, Integer>> rowsMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        char playerSymbol = move.getPlayer().getPlayerSymbol().getSymbol();

        if(!rowsMap.containsKey(row)) {
            rowsMap.put(row, new HashMap<>());
        }

        if(!rowsMap.get(row).containsKey(playerSymbol)) {
            rowsMap.get(row).putIfAbsent(playerSymbol, 0);
        }
        rowsMap.get(row).put(playerSymbol, rowsMap.get(row).get(playerSymbol) + 1);

        return rowsMap.get(row).get(playerSymbol).equals(board.getBoardSize());
    }
}
