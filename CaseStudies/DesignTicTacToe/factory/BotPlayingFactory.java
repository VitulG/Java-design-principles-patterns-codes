package CaseStudies.DesignTicTacToe.factory;

import CaseStudies.DesignTicTacToe.models.BotDifficultyLevel;
import CaseStudies.DesignTicTacToe.strategy.BotPlayingStrategy;
import CaseStudies.DesignTicTacToe.strategy.EasyBotPlayingStrategy;
import CaseStudies.DesignTicTacToe.strategy.HardBotPlayingStrategy;
import CaseStudies.DesignTicTacToe.strategy.MediumBotPlayingStrategy;

public class BotPlayingFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel) {
        return switch (difficultyLevel) {
            case EASY -> new EasyBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStrategy();
            case HARD -> new HardBotPlayingStrategy();
            default -> throw new IllegalArgumentException("Invalid difficulty level");
        };
    }
}
