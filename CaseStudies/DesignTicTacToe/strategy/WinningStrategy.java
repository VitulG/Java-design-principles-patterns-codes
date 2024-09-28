package CaseStudies.DesignTicTacToe.strategy;

import CaseStudies.DesignTicTacToe.models.Board;
import CaseStudies.DesignTicTacToe.models.Cell;
import CaseStudies.DesignTicTacToe.models.Move;
import CaseStudies.DesignTicTacToe.models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
