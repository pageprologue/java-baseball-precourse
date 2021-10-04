package baseball.domain.game;

import baseball.domain.baseball.Ball;
import baseball.domain.baseball.Inning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @Test
    @DisplayName("입력받은 값으로 3개의 야구공을 가진 플레이어를 생성한다.")
    void create() {
        //given //when
        Player pitcher = new Player(Inning.randomInning());
        Player batter = new Player(Inning.createInning(Arrays.asList(1, 2, 3)));

        //then
        assertThat(pitcher.getBalls()).hasSize(3);
        assertThat(batter.getBalls()).hasSize(3);
        assertThat(batter.getBalls()).containsExactly(Ball.of(1), Ball.of(2), Ball.of(3));
    }

    @Test
    @DisplayName("입력받은 값으로 3개의 야구공을 변경한다.")
    void changeInning() {
        //given
        Player batter = new Player(Inning.createInning(Arrays.asList(1, 2, 3)));

        //when
        batter.changeInning(Arrays.asList(4, 5, 6));

        //then
        assertThat(batter.getBalls()).containsExactly(Ball.of(4), Ball.of(5), Ball.of(6));
    }
}
