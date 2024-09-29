package CaseStudies.DesignTicTacToe.models;

import CaseStudies.DesignTicTacToe.factory.BotPlayingFactory;
import CaseStudies.DesignTicTacToe.strategy.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, BotDifficultyLevel difficultyLevel, Symbol symbol, PlayerType type) {
        super(name, symbol, type);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingFactory.getBotPlayingStrategy(difficultyLevel);
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    @Override
    public Move makeMove(Board board) {
        return botPlayingStrategy.makeMove(board);
    }
}
