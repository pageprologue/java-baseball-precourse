package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.score.Score;
import baseball.domain.state.Finish;
import baseball.domain.state.Ready;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGameController {
    private BaseballGame baseballGame;

    public void run() {
        baseballGame = new BaseballGame(new Ready());
        while (!isFinish()) {
            proceedGame();
        }
    }

    private void proceedGame() {
        try {
            playBaseballGame();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private void playBaseballGame() {
        while (!isFinish()) {
            OutputView.printInputBallMessage();
            List<Integer> numbers = InputView.getBatterBalls();
            baseballGame.play(numbers);

            Score score = baseballGame.score();
            OutputView.printInningScore(score);

            ifAllStrikeThenGameEnd(score);
            ifGameFinished();
        }
    }

    private void ifAllStrikeThenGameEnd(Score score) {
        if (score.getStrike() == 3) {
            baseballGame.end();
            OutputView.printAllStrike();
        }
    }

    private void ifGameFinished() {
        if (isFinish()) {
            OutputView.printRestartOrEndMessage();
            changeState(InputView.inputState());
        }
    }

    private boolean isFinish() {
        return baseballGame.getGameState() instanceof Finish;
    }

    private void changeState(int state) {
        baseballGame.restart(state);
    }
}
