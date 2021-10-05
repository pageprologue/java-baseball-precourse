package baseball.domain.baseball;

import baseball.domain.score.Score;

import java.util.List;

public class Inning {
    private final Player pitcher;
    private final Player batter;

    private Inning(Player pitcher, Player batter) {
        this.pitcher = pitcher;
        this.batter = batter;
    }

    public static Inning initialize(List<Integer> numbers) {
        return new Inning(Player.pitcher(), Player.batter(numbers));
    }

    public Inning tryInning(List<Integer> numbers) {
        batter.changeBalls(numbers);
        return this;
    }

    public Score compareInning() {
        Score score = new Score();
        return score.compare(pitcher.getBalls(), batter.getBalls());
    }
}
