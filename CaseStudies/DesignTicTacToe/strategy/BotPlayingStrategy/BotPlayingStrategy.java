package CaseStudies.DesignTicTacToe.strategy.BotPlayingStrategy;

import CaseStudies.DesignTicTacToe.models.Board;
import CaseStudies.DesignTicTacToe.models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
