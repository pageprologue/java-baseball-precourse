package baseball.domain.state;

import baseball.domain.baseball.Inning;

import java.util.List;

public class Start implements GameState {
    private final Inning inning;

    public Start(List<Integer> numbers) {
        this.inning = Inning.initialize(numbers);
    }

    @Override
    public GameState start(List<Integer> numbers) {
        throw new UnsupportedOperationException();
    }

    @Override
    public GameState playing(List<Integer> numbers) {
        return new Playing(inning.tryInning(numbers));
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
