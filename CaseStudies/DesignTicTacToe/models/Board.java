package CaseStudies.DesignTicTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int boardSize;
    private List<List<Cell>> board;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.board = new ArrayList<>();

        for(int i =0; i<this.boardSize; i++) {
            board.add(new ArrayList<>());

            for(int j=0; j<this.boardSize; j++) {
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
