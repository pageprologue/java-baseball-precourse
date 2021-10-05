package baseball.domain;

import baseball.domain.baseball.Inning;
import baseball.domain.score.Score;
import baseball.domain.state.GameState;
import baseball.domain.state.Ready;

import java.util.List;

public class BaseballGame {
    private GameState gameState;

    public BaseballGame(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void play(List<Integer> numbers) {
        if (gameState instanceof Ready) {
            this.gameState = gameState.start(numbers);
            return;
        }
        this.gameState = gameState.playing(numbers);
    }

    public Score score() {
        Inning inning = gameState.getInning();
        return inning.compareInning();
    }

    public void end() {
        this.gameState = gameState.end();
    }

    public void restart(int state) {
        if (state == 1) {
            this.gameState = gameState.restart();
        }
    }
}
