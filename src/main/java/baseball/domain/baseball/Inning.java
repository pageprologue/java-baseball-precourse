package baseball.domain.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Inning {
    public static final int INNING_COUNT = 3;
    private final List<Ball> balls;

    private Inning(List<Ball> balls) {
        this.balls = balls;
    }

    public static Inning randomInning() {
        List<Ball> balls = new ArrayList<>();
        while (balls.size() < INNING_COUNT) {
            balls.add(Ball.random());
        }
        return new Inning(balls);
    }

    public static Inning createInning(List<Integer> numbers) {
        validateSize(numbers);
        List<Ball> balls = new ArrayList<>();
        numbers.forEach(ball -> balls.add(Ball.of(ball)));
        return new Inning(balls);
    }

    private static void validateSize(List<Integer> numbers) {
        HashSet<Integer> balls = new HashSet<>(numbers);
        if (balls.size() != INNING_COUNT) {
            throw new IllegalArgumentException("야구 게임 한 회에는 중복되지 않는 숫자 3개가 있어야 합니다.");
        }
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
