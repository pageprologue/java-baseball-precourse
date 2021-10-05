package baseball.parser;

import java.util.LinkedList;
import java.util.List;

public class InputParser {
    private static final String DELIMITER = "";

    private InputParser() {
    }

    public static List<Integer> splitAndParseInt(String input) {
        List<Integer> inningNumbers = new LinkedList<>();
        for (String i : input.split(DELIMITER)) {
            inningNumbers.add(parseInputToInt(i));
        }
        return inningNumbers;
    }

    public static int parseInputToInt(String input) {
        try {
            return Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 숫자입니다.");
        }
    }
}
