package baseball.domain.state;

import baseball.domain.baseball.Inning;

import java.util.List;

public class Playing implements GameState {
    private Inning inning;

    public Playing(Inning inning) {
        this.inning = inning;
    }

    @Override
    public GameState start(List<Integer> numbers) {
        throw new UnsupportedOperationException();
    }

    @Override
    public GameState playing(List<Integer> numbers) {
        this.inning = inning.tryInning(numbers);
        return this;
    }

    @Override
    public GameState end() {
        return new Finish();
    }

    @Override
    public GameState restart() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Inning getInning() {
        return inning;
    }
}
