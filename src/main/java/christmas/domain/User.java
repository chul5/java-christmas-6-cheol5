package christmas.domain;

import christmas.service.Event;
import christmas.view.OutputView;

import java.util.Map;

import static christmas.view.OutputView.*;

public class User {
	private String grade;
	private Map<String, Integer> menuPrice;
	private int totalMoney;
	private Order order;
	private final int date;

	public User(int date, String order, Map<String, Integer> menuPrice) {
		this.order = new Order(order);
		this.totalMoney = this.order.getTotalPrice(menuPrice);
		this.date = date;
		this.menuPrice = menuPrice;
		setGrade();
	}
	public void userOrderRun(){
		int discount = 0;
		OutputView.printMessage(REVIEW_MESSAGE);
		OutputView.printMessage(ORDERS);
		OutputView.printMessage(this.order.getOrdersString());
		OutputView.printMessage(BEFORE_DISCOUNT);
		OutputView.printIntegers(totalMoney);
		Event event = new Event(menuPrice, this.order.getOrders());
		if (event.isApplyEvent(totalMoney))
			discount = event.calculateDiscount(date, totalMoney);
		if (!event.isApplyEvent(totalMoney))
			OutputView.printMessage(BENEFITS + "없음%n");
		OutputView.printMessage(TOTAL_DISCOUNT_MESSAGE);
		OutputView.printIntegers(-discount);
		OutputView.printMessage(EXPECTED_PRICE);
		OutputView.printIntegers(totalMoney - discount);
		OutputView.printMessage(BADGE_MESSAGE);
		OutputView.printMessage(this.grade);
	}

	private void setGrade() {
		if (totalMoney >= 5000)
			this.grade = "별";
		if (totalMoney >= 10000)
			this.grade = "트리";
		if (totalMoney >= 20000)
			this.grade = "산타";
	}
}
