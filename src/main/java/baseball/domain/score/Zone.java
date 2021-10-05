package baseball.domain.score;

public enum Zone {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String name;

    Zone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
