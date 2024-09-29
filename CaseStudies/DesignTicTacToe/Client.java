package CaseStudies.DesignTicTacToe;

import CaseStudies.DesignTicTacToe.Exception.InvalidMoveException;
import CaseStudies.DesignTicTacToe.controller.GameController;
import CaseStudies.DesignTicTacToe.models.*;
import CaseStudies.DesignTicTacToe.strategy.GameWinningStrategy.ColumnWinningStrategy;
import CaseStudies.DesignTicTacToe.strategy.GameWinningStrategy.DiagonalWinningStrategy;
import CaseStudies.DesignTicTacToe.strategy.GameWinningStrategy.RowWinningStrategy;
import CaseStudies.DesignTicTacToe.strategy.GameWinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Game starts");
        Scanner sc = new Scanner(System.in);
        GameController controller = new GameController();

        System.out.println("enter the board dimensions/size");
        int dimension = sc.nextInt();

        List<Player> players = new ArrayList<Player>();
        Symbol symbolForHuman = new Symbol('X');
        Symbol symbolForBot = new Symbol('O');
        players.add(new Human("Vitul", symbolForHuman, PlayerType.HUMAN));
        players.add(new Bot("Bot", BotDifficultyLevel.EASY, symbolForBot, PlayerType.BOT));

        List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(),
                new ColumnWinningStrategy(), new DiagonalWinningStrategy());


        Game game = controller.startGame(dimension, players, winningStrategies);

        while(controller.checkGameState(game).equals(GameState.IN_PROGRESS)) {
            // show the board
            // make a move to place the player symbol
            controller.printBoard(game);

            System.out.println("do you want to do undo (y/n)");
            char undo = sc.next().charAt(0);

            if(undo == 'y') {
                controller.undoMove(game);
                continue;
            }
            try {
                controller.makeMove(game);
            } catch (InvalidMoveException invalidMoveException) {
                System.out.println(invalidMoveException.getMessage());
            }
        }

        controller.printBoard(game);
        if(controller.checkGameState(game).equals(GameState.GAME_OVER)) {
            System.out.println("Game Over. Winner: " + game.getWinner().getPlayerName());
        }else {
            System.out.println("Game Over. It's a Draw");
        }

    }
}
