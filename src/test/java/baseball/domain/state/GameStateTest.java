package baseball.domain.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameStateTest {
    private List<Integer> numbers;
    private GameState ready;
    private GameState start;
    private GameState playing;
    private GameState finish;

    @BeforeEach
    void beforeEach() {
        numbers = Arrays.asList(1, 2, 3);
        ready = new Ready();
        start = ready.start(numbers);
        playing = start.playing(numbers);
        finish = new Finish();
    }

    @Test
    @DisplayName("게임 상태가 Ready 일 때 게임을 시작할 수 있다.")
    void gameStart() {
        //then
        assertThat(ready.start(numbers)).isInstanceOf(Start.class);
        assertThrows(UnsupportedOperationException.class, () -> start.start(numbers));
        assertThrows(UnsupportedOperationException.class, () -> playing.start(numbers));
        assertThrows(UnsupportedOperationException.class, () -> finish.start(numbers));
    }

    @Test
    @DisplayName("게임 상태가 Start 일 때 게임을 진행할 수 있다.")
    void gamePlaying() {
        //then
        assertThat(start.playing(numbers)).isInstanceOf(Playing.class);
        assertThat(playing.playing(numbers)).isInstanceOf(Playing.class);
        assertThrows(UnsupportedOperationException.class, () -> ready.playing(numbers));
        assertThrows(UnsupportedOperationException.class, () -> finish.playing(numbers));
    }

    @Test
    @DisplayName("게임 상태가 Start 또는 Playing 일 때 게임을 종료할 수 있다.")
    void gameEnd() {
        //then
        assertThat(start.end()).isInstanceOf(Finish.class);
        assertThat(playing.end()).isInstanceOf(Finish.class);
        assertThrows(UnsupportedOperationException.class, () -> ready.end());
        assertThrows(UnsupportedOperationException.class, () -> finish.end());
    }

    @Test
    @DisplayName("게임 상태가 Finish 일 때 게임을 다시 시작(준비)할 수 있다.")
    void gameReady() {
        //then
        assertThat(finish.restart()).isInstanceOf(Ready.class);
        assertThrows(UnsupportedOperationException.class, () -> ready.restart());
        assertThrows(UnsupportedOperationException.class, () -> start.restart());
        assertThrows(UnsupportedOperationException.class, () -> playing.restart());
    }
}