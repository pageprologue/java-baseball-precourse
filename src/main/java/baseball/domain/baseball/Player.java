package baseball.domain.baseball;

import java.util.List;

public class Player {
    private Balls balls;

    private Player(Balls balls) {
        this.balls = balls;
    }

    public static Player pitcher() {
        return new Player(Balls.random());
    }

    public static Player batter(List<Integer> numbers) {
        return new Player(Balls.create(numbers));
    }

    public void changeBalls(List<Integer> numbers) {
        this.balls = Balls.create(numbers);
    }

    public List<Ball> getBalls() {
        return balls.getBalls();
    }
}
