package baseball;

import baseball.controller.BaseballGameController;

public class Application {
    public static final BaseballGameController baseballGameController = new BaseballGameController();

    public static void main(String[] args) {
        baseballGameController.run();
    }
}
