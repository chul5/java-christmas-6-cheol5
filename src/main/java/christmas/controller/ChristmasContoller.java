package christmas.controller;

import christmas.domain.Order;
import christmas.domain.User;
import christmas.view.InputView;

import java.util.HashMap;
import java.util.Map;

public class ChristmasContoller {
	private Map<String, Integer> menuPrice;
	private Map<String, Integer> drinkMenuPrice;
	private int date;
	private static final String appetizer = "양송이수프(6000), 타파스(5500), 시저샐러드(8000)";
	private static final String maindish = "티본스테이크(55000), 바비큐립(54000), 해산물파스타(35000), 크리스마스파스타(25000)";
	private static final String dessert = "초코케이크(15000), 아이스크림(5000)";
	private static final String drink = "제로콜라(3000), 레드와인(60000), 샴페인(25000)";
	public Map<String, Integer> getMenuPrice(){
		Map<String, Integer> menuPrice = new HashMap<>();
		String line = appetizer + "," + maindish + "," + dessert + "," + drink;
		String[] menus = line.split(",");
		for(String menu : menus) {
			String[] order = menu.trim().split("\\(");
			menuPrice.put(order[0], Integer.parseInt(order[1].replace(")", "")));
		}
		return menuPrice;
	}

	public Map<String, Integer> getDrinks(){
		Map<String, Integer> drinkMenuPrice = new HashMap<>();
		String[] menus = drink.split(",");
		for(String menu : menus) {
			String[] order = menu.trim().split("\\(");
			menuPrice.put(order[0], Integer.parseInt(order[1].replace(")", "")));
		}
		return drinkMenuPrice;
	}

	public void run() {
		InputView inputView = new InputView(getMenuPrice(), getDrinks());
		date = inputView.getDate();
		User user = new User(inputView.getOrders(), menuPrice);

	}
}
