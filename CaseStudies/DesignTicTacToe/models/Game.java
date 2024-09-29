package CaseStudies.DesignTicTacToe.models;

import CaseStudies.DesignTicTacToe.Exception.InvalidMoveException;
import CaseStudies.DesignTicTacToe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState state;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(Builder builder) {
        this.board = new Board(builder.boardSize);
        this.players = builder.players;
        this.moves = new ArrayList<>();
        this.winner = null;
        this.state = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStrategies = builder.winningStrategies;
    }

    public static class Builder {
        private int boardSize;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder() {
            this.boardSize = 0;
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }

        public Builder setBoardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build() {
            validateGameDetails(this.boardSize, this.players);
            return new Game(this);
        }

        private void validateGameDetails(int dimensions, List<Player> player) {
            if(dimensions < 3) {
                throw new IllegalArgumentException("Invalid board size. Board size must at least 3x3.");
            }

            if(player == null || player.isEmpty()) {
                throw new IllegalArgumentException("No players provided.");
            }

            int botCount = 0;
            Set<Symbol> playerSymbols = new HashSet<>();
            for(Player currentPlayer : players) {
                if(currentPlayer.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
                if(botCount > 1) {
                    throw new IllegalArgumentException("Only one bot player is allowed.");
                }

                if(playerSymbols.contains(currentPlayer.getPlayerSymbol())) {
                    throw new IllegalArgumentException("Duplicate player symbol.");
                }
                playerSymbols.add(currentPlayer.getPlayerSymbol());
            }

            if(playerSymbols.size() != dimensions-1) {
                throw new IllegalArgumentException("each player must have their symbols.");
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public void printGameBoard() {
        this.board.printBoard();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    private boolean validateMoveMethod(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row < 0 || col < 0 || row >= board.getBoardSize() || col >= board.getBoardSize()) {
            return false;
        }
        return move.getCell().getCellState() != CellState.FILLED && move.getCell().getCellState() != CellState.BLOCKED;
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println(currentPlayer.getPlayerName()+"'s move:");

        // player will choose to move
        Move move = currentPlayer.makeMove(board);

        // validate the move by game class
        if(!validateMoveMethod(move)) {
            throw new InvalidMoveException("Invalid move");
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setRow(row);
        cell.setCol(col);
        cell.setPlayer(currentPlayer);
        nextPlayerIndex =  (nextPlayerIndex+1) % players.size();

        Move newMove = new Move(currentPlayer, cell);
        moves.add(newMove);

        // check winner
        if(checkWinner(this.board, newMove)) {
            winner = currentPlayer;
            state = GameState.GAME_OVER;
            System.out.println("Player "+currentPlayer.getPlayerName()+" wins!");
        } else if(moves.size() == board.getBoardSize()*board.getBoardSize()) {
            state = GameState.DRAW;
            System.out.println("It's a draw!");
        }
    }

    private boolean checkWinner(Board board, Move move) {
        for(WinningStrategy strategy : winningStrategies) {
            if(strategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }
}
