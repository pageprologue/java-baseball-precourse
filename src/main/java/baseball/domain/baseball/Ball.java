package baseball.domain.baseball;

import nextstep.utils.Randoms;

import java.util.Objects;

public class Ball {
    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 9;

    private final int ball;

    private Ball(int ball) {
        this.ball = ball;
    }

    public static Ball of(int ball) {
        validateRange(ball);
        return new Ball(ball);
    }

    public static Ball random() {
        int randomBall = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
        return new Ball(randomBall);
    }

    private static void validateRange(int ball) {
        if (ball < MIN_BALL_NUMBER || ball > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException("야구공의 숫자는 1 ~ 9 사이의 값이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball1 = (Ball) o;
        return ball == ball1.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }
}
