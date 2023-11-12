package christmas.domain;

import christmas.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Order {
	private String menuName;
	private Map<String, Integer> orders = new HashMap<String, Integer>();

	public Order(String menuName) {
		this.menuName = menuName;
	}
	public void splitOrders(){
		String[] menus = menuName.split(",");
		for(String menu : menus) {
			String[] order = menu.split("-");
			orders.put(order[0], Integer.parseInt(order[1]));
			}
	}

	public String getOrders(){
		Set<String> menus = orders.keySet();
		StringBuilder orderLine = new StringBuilder();
		for (String menu : menus) {
			orderLine.append(menu).append(" ").append(orders.get(menu)).append("개\n");
		}
		return orderLine.toString();
	}

	public int getTotalPrice(Map<String, Integer> menuPrice) {
		int totalPrice = 0;
		Set<String> menus = orders.keySet();
		for (String menu : menus) {
			totalPrice += menuPrice.get(menu) * orders.get(menu);
		}
		return totalPrice;
	}

}
