package baseball.view;

import baseball.domain.score.Score;

import static baseball.domain.score.Zone.*;

public class OutputView {
    private OutputView() {
    }

    public static void printInputBallMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printInningScore(Score inningScore) {
        int strike = inningScore.getStrike();
        int ball = inningScore.getBall();

        if (strike == 0 && ball == 0) {
            System.out.print(NOTHING.getName());
        }
        if (strike > 0) {
            System.out.printf("%d%s ", inningScore.getStrike(), STRIKE.getName());
        }
        if (ball > 0) {
            System.out.printf("%d%s ", inningScore.getBall(), BALL.getName());
        }
        System.out.println();
    }

    public static void printAllStrike() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public static void printRestartOrEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
