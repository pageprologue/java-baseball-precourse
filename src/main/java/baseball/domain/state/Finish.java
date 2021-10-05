package baseball.domain.state;

import baseball.domain.baseball.Inning;

import java.util.List;

public class Finish implements GameState {
    @Override
    public GameState start(List<Integer> numbers) {
        throw new UnsupportedOperationException();
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
        return new Ready();
    }

    @Override
    public Inning getInning() {
        throw new UnsupportedOperationException();
    }
}
