package CaseStudies.DesignTicTacToe.strategy;

import CaseStudies.DesignTicTacToe.models.Board;
import CaseStudies.DesignTicTacToe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {
    private final Map<Integer, Map<Character, Integer>> columnMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        char playerSymbol = move.getPlayer().getPlayerSymbol().getSymbol();

        if(!columnMap.containsKey(col)) {
            columnMap.put(col, new HashMap<>());
        }

        if(!columnMap.get(col).containsKey(playerSymbol)) {
            columnMap.get(col).putIfAbsent(playerSymbol, 0);
        }
        columnMap.get(col).put(playerSymbol, columnMap.get(col).get(playerSymbol) + 1);

        return columnMap.get(col).get(playerSymbol) == board.getBoardSize();
    }
}
