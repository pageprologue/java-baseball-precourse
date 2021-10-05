package baseball.domain.score;

import baseball.domain.baseball.Ball;

import java.util.List;

public class Score {
    private int strike;
    private int ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public Score compare(List<Ball> pitcherBalls, List<Ball> batterBalls) {
        for (int i = 0; i < pitcherBalls.size(); i++) {
            strike(pitcherBalls.get(i), batterBalls.get(i));
            ball(pitcherBalls, batterBalls.get(i));
        }
        this.ball = ball - strike;
        return this;
    }

    private void strike(Ball pitcherBall, Ball batterBall) {
        if (pitcherBall.equals(batterBall)) {
            this.strike++;
        }
    }

    private void ball(List<Ball> pitcherBalls, Ball batterBall) {
        if (pitcherBalls.contains(batterBall)) {
            this.ball++;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
