package christmas.domain;

import christmas.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order implements Food, Drink {
	private String menuName;
	private int price;

	public Order(String menuName, int price) {
		this.menuName = menuName;
		this.price = price;
	}

	public Map<String, Integer> splitOrders(){
		Map<String, Integer> orders = new HashMap<String, Integer>();
		String[] menus = menuName.split(",");
		for(String menu : menus) {
			String[] order = menu.split("-");
			orders.put(order[0], Integer.parseInt(order[1]));
			}
		return orders;
		//System.out.println("주문 내역: " + menuName + ", " + price + "원");
	}

	public int getPrice() {
		return price;
	}

	public void menu() {
		System.out.println("메뉴 이름: " + menuName);
	}

}
