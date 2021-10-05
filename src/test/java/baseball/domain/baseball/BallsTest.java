package baseball.domain.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallsTest {
    @Test
    @DisplayName("랜덤으로 중복되지 않는 3개의 야구공을 생성한다.")
    void randomInning() {
        //when
        List<Integer> rangeNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Balls pitcherBalls = Balls.random();

        // then
        assertThat(pitcherBalls.getBalls()).hasSize(3);
        pitcherBalls.getBalls()
                .forEach(ball -> assertThat(rangeNumbers).contains(ball.getNumber()));
    }

    @Test
    @DisplayName("입력받은 값으로 중복되지 않는 3개의 야구공을 생성한다.")
    void createInning() {
        //given
        List<Integer> input = Arrays.asList(1, 2, 3);

        //when
        Balls batterBalls = Balls.create(input);

        //then
        assertThat(batterBalls.getBalls()).hasSize(3);
        assertThat(batterBalls.getBalls()).containsExactly(Ball.of(1), Ball.of(2), Ball.of(3));
    }


    @Test
    @DisplayName("입력 받은 숫자가 중복되는 경우 예외가 발생한다.")
    void validateDuplicate() {
        //given
        List<Integer> invalidInput = Arrays.asList(1, 2, 2);

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Balls.create(invalidInput))
                .withMessage("야구 게임 한 회에는 중복되지 않는 숫자 3개가 있어야 합니다.");
    }

    @Test
    @DisplayName("입력 받은 목록의 길이가 3개가 아닌 경우 예외가 발생한다.")
    void validateSize() {
        //given
        List<Integer> invalidInput = Arrays.asList(1, 2);

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Balls.create(invalidInput))
                .withMessage("야구 게임 한 회에는 중복되지 않는 숫자 3개가 있어야 합니다.");
    }
}
