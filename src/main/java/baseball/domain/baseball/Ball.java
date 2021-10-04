package baseball.domain.baseball;

import nextstep.utils.Randoms;

import java.util.Objects;

public class Ball {
    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 9;

    private final int number;

    private Ball(int number) {
        this.number = number;
    }

    public static Ball of(int number) {
        validateRange(number);
        return new Ball(number);
    }

    public static Ball random() {
        int randomBall = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
        return new Ball(randomBall);
    }

    private static void validateRange(int number) {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException("야구공의 숫자는 1 ~ 9 사이의 값이어야 합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
