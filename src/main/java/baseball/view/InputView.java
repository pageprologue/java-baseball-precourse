package baseball.view;

import baseball.parser.InputParser;
import nextstep.utils.Console;

import java.util.List;

public class InputView {

    private InputView() {
    }

    public static List<Integer> getBatterBalls() {
        String input = getInput();
        return InputParser.splitAndParseInt(input);
    }

    public static int inputState() {
        String input = getInput();
        int stateCode = InputParser.parseInputToInt(input);
        validateStateCode(stateCode);
        return stateCode;
    }

    private static String getInput() {
        String input = Console.readLine();
        validateNullOrEmpty(input);
        return input;
    }

    public static void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값을 다시 확인해 주세요.");
        }
    }

    public static void validateStateCode(int stateCode) {
        if (stateCode != 1 && stateCode != 2) {
            throw new IllegalArgumentException("게임을 시작하려면 1, 종료하려면 2를 입력해야 합니다.");
        }
    }
}
