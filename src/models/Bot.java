package models;

import strategies.BotPlayingStrategyFactory;

public class Bot extends Player {

    private BotDifficultyLevel difficultyLevel;

    public Bot(String name,Symbol symbol, PlayerType playerType,BotDifficultyLevel difficultyLevel) {
        super(name,symbol,playerType);
        this.difficultyLevel = difficultyLevel;
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove() {
        return BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel).makeMove(getGame().getBoard(),this);
    }
}
