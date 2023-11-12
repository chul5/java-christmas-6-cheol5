package christmas.domain;

import christmas.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Order implements Food, Drink {
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

	public String printOrder(){
		Set<String> menus = orders.keySet();
		String orderLine = "";
		for (String menu : menus) {
			System.out.println(menu + " " + orders.get(menu) + "개");
			orderLine = orderLine + menu + " " + orders.get(menu) + "개\n";
		}
		return orderLine;
	}

	public void menu() {
		System.out.println("메뉴 이름: " + menuName);
	}

}
