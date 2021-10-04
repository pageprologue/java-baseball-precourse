package baseball.domain.baseball;

import java.util.List;

public class InningScore {
    private int strike;
    private int ball;

    public InningScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public void compare(List<Ball> pitcherBalls, List<Ball> batterBalls) {
        for (int i = 0; i < pitcherBalls.size(); i++) {
            strike(pitcherBalls.get(i), batterBalls.get(i));
            ball(pitcherBalls, batterBalls.get(i));
        }
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
