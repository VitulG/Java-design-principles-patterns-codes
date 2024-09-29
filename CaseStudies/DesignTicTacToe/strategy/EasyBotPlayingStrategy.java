package CaseStudies.DesignTicTacToe.strategy;

import CaseStudies.DesignTicTacToe.models.Board;
import CaseStudies.DesignTicTacToe.models.Cell;
import CaseStudies.DesignTicTacToe.models.CellState;
import CaseStudies.DesignTicTacToe.models.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        for(int i=0; i<board.getBoardSize(); i++) {
            for(int j=0; j< board.getBoardSize(); j++) {
                if(board.getBoard().get(i).get(j).getCellState() == CellState.EMPTY) {
                    return new Move(null, new Cell(i, j));
                }
            }
        }
        return null;
    }
}
