package baseball.domain.baseball;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Balls {
    private static final int MAX_BALL_COUNT = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls random() {
        List<Ball> balls = new LinkedList<>();
        while (balls.size() < MAX_BALL_COUNT) {
            balls.add(Ball.random());
        }
        return new Balls(balls);
    }

    public static Balls create(List<Integer> numbers) {
        validateSize(numbers);
        List<Ball> balls = new LinkedList<>();
        numbers.forEach(ball -> balls.add(Ball.of(ball)));
        return new Balls(balls);
    }

    private static void validateSize(List<Integer> numbers) {
        Set<Integer> balls = new HashSet<>(numbers);
        if (balls.size() != MAX_BALL_COUNT) {
            throw new IllegalArgumentException("야구 게임 한 회에는 중복되지 않는 숫자 3개가 있어야 합니다.");
        }
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
