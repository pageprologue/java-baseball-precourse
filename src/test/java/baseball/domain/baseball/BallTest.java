package baseball.domain.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallTest {
    @Test
    @DisplayName("랜덤한 숫자로 야구공을 생성한다.")
    void random() {
        //given
        List<Integer> rangeNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //when
        Ball ball = Ball.random();

        //then
        assertThat(rangeNumbers).contains(ball.getNumber());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("입력받은 숫자로 야구공을 생성한다.")
    void create(int number) {
        //given
        Ball ball = Ball.of(number);

        //when //then
        assertThat(ball).isEqualTo(Ball.of(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("야구공 숫자가 1 ~ 9 사이의 값이 아니면 예외가 발생한다.")
    void validateRange(int number) {
        //given //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ball.of(number))
                .withMessage("야구공의 숫자는 1 ~ 9 사이의 값이어야 합니다.");
    }
}
