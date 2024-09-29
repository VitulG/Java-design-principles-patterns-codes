package CaseStudies.DesignTicTacToe.controller;

import CaseStudies.DesignTicTacToe.Exception.InvalidMoveException;
import CaseStudies.DesignTicTacToe.models.Game;
import CaseStudies.DesignTicTacToe.models.GameState;
import CaseStudies.DesignTicTacToe.models.Player;
import CaseStudies.DesignTicTacToe.strategy.GameWinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    // make move functionality
    // undo functionality
    // check win/lose functionality
    // game state

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        return Game.builder()
                .setBoardSize(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState checkGameState(Game game) {
        return game.getState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printGameBoard();
    }

    public void undoMove(Game game) {

    }
}
