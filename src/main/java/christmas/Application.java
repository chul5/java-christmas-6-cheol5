package christmas;

import christmas.domain.Order;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Order order = new Order("chicken-1,coke-2");
        order.splitOrders();
    }
}
