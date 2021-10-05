package baseball.domain.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @Test
    @DisplayName("랜덤으로 중복되지 않는 3개의 야구공을 가진 투수(Pitcher)를 생성한다.")
    void createPitcher() {
        //given //when
        Player pitcher = Player.pitcher();

        //then
        assertThat(pitcher.getBalls()).hasSize(3);
    }

    @Test
    @DisplayName("입입력받은 값으로 중복되지 않는 3개의 야구공을 가진 타자(Batter)를 생성한다.")
    void createBatter() {
        //given //when
        Player batter = Player.batter(Arrays.asList(1, 2, 3));

        //then
        assertThat(batter.getBalls()).hasSize(3);
        assertThat(batter.getBalls()).containsExactly(Ball.of(1), Ball.of(2), Ball.of(3));
    }

    @Test
    @DisplayName("입력받은 값으로 타자의 야구공을 변경한다.")
    void changeInning() {
        //given
        Player batter = Player.batter(Arrays.asList(1, 2, 3));

        //when
        batter.changeBalls(Arrays.asList(4, 5, 6));

        //then
        assertThat(batter.getBalls()).containsExactly(Ball.of(4), Ball.of(5), Ball.of(6));
    }
}
