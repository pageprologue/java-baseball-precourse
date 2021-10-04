package baseball.domain.game;

import baseball.domain.baseball.Ball;
import baseball.domain.baseball.Inning;

import java.util.List;

public class Player {
    private Inning inning;

    public Player(Inning inning) {
        this.inning = inning;
    }

    public void changeInning(List<Integer> numbers) {
        this.inning = Inning.createInning(numbers);
    }

    public List<Ball> getBalls() {
        return inning.getBalls();
    }
}
