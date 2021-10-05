package baseball.domain.baseball;

import baseball.domain.game.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class InningScoreTest {
    private InningScore inningScore;

    @BeforeEach
    void before() {
        inningScore = new InningScore();
    }

    @Test
    @DisplayName("투수와 타자의 야구공 숫자를 비교하여 같은 수가 같은 자리에 있으면 스트라이크이다.")
    void strike() {
        //given
        Player pitcher = new Player(Inning.createInning(Arrays.asList(1, 2, 3)));
        Player batter = new Player(Inning.createInning(Arrays.asList(1, 4, 5)));

        //when
        inningScore.compare(pitcher.getBalls(), batter.getBalls());

        //then
        assertThat(inningScore.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("투수와 타자의 야구공 숫자를 비교하여 같은 수가 다른 자리에 있으면 볼이다.")
    void ball() {
        //given
        Player pitcher = new Player(Inning.createInning(Arrays.asList(1, 2, 3)));
        Player batter = new Player(Inning.createInning(Arrays.asList(3, 1, 2)));

        //when
        inningScore.compare(pitcher.getBalls(), batter.getBalls());

        //then
        assertThat(inningScore.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("투수와 타자의 야구공 숫자를 비교하여 같은 수가 전혀 없으면 낫싱이다.")
    void nothing() {
        //given
        Player pitcher = new Player(Inning.createInning(Arrays.asList(1, 2, 3)));
        Player batter = new Player(Inning.createInning(Arrays.asList(4, 5, 6)));

        //when
        inningScore.compare(pitcher.getBalls(), batter.getBalls());

        //then
        assertThat(inningScore.getStrike()).isZero();
        assertThat(inningScore.getBall()).isZero();
    }
}
