package baseball.domain.score;

import baseball.domain.baseball.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {
    private Score score;

    @BeforeEach
    void before() {
        score = new Score();
    }

    @Test
    @DisplayName("투수와 타자의 야구공 숫자를 비교하여 같은 수가 같은 자리에 있으면 스트라이크이다.")
    void strike() {
        //given
        Player pitcher = Player.batter(Arrays.asList(1, 2, 3));
        Player batter = Player.batter(Arrays.asList(1, 4, 5));

        //when
        score.compare(pitcher.getBalls(), batter.getBalls());

        //then
        assertThat(score.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("투수와 타자의 야구공 숫자를 비교하여 같은 수가 다른 자리에 있으면 볼이다.")
    void ball() {
        //given
        Player pitcher = Player.batter(Arrays.asList(1, 2, 3));
        Player batter = Player.batter(Arrays.asList(3, 1, 2));

        //when
        score.compare(pitcher.getBalls(), batter.getBalls());

        //then
        assertThat(score.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("투수와 타자의 야구공 숫자를 비교하여 같은 수가 전혀 없으면 낫싱이다.")
    void nothing() {
        //given
        Player pitcher = Player.batter(Arrays.asList(1, 2, 3));
        Player batter = Player.batter(Arrays.asList(4, 5, 6));

        //when
        score.compare(pitcher.getBalls(), batter.getBalls());

        //then
        assertThat(score.getStrike()).isZero();
        assertThat(score.getBall()).isZero();
    }
}
