package CaseStudies.DesignTicTacToe.strategy.GameWinningStrategy;

import CaseStudies.DesignTicTacToe.models.Board;
import CaseStudies.DesignTicTacToe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
