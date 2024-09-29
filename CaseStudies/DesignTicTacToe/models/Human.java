package CaseStudies.DesignTicTacToe.models;

import java.util.Scanner;

public class Human extends Player {
    private final Scanner scanner;
    public Human(String name, Symbol symbol, PlayerType type) {
        super(name, symbol, type);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("enter your move: row and col number");
        int row  = scanner.nextInt();
        int col = scanner.nextInt();

        return new Move(this, new Cell(row, col));
    }
}
