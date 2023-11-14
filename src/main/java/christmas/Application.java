package christmas;

import christmas.controller.ChristmasContoller;
import christmas.domain.Order;
import christmas.view.InputView;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ChristmasContoller christmasContoller = new ChristmasContoller();
        christmasContoller.run();
    }
}
