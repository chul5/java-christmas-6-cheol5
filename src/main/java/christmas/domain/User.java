package christmas.domain;

import java.util.Map;

public class User {
	private String grade;
	private int totalMoney;
	private Order order;

	public User(String order, Map<String, Integer> menuPrice) {
		this.order = new Order(order);
		this.totalMoney = this.order.getTotalPrice(menuPrice);
		setGrade();
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
