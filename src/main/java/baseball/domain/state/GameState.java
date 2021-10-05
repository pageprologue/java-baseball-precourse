package baseball.domain.state;

import baseball.domain.baseball.Inning;

import java.util.List;

public interface GameState {

    GameState start(List<Integer> numbers);

    GameState playing(List<Integer> numbers);

    GameState end();

    GameState restart();

    Inning getInning();

}
