package baseball.domain.state;

import baseball.domain.baseball.Inning;

import java.util.List;

public class Ready implements GameState {
    @Override
    public GameState start(List<Integer> numbers) {
        return new Start(numbers);
    }

    @Override
    public GameState playing(List<Integer> numbers) {
        throw new UnsupportedOperationException();
    }

    @Override
    public GameState end() {
        throw new UnsupportedOperationException();
    }

    @Override
    public GameState restart() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Inning getInning() {
        throw new UnsupportedOperationException();
    }
}
