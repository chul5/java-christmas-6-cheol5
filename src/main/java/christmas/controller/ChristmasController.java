package christmas.controller;

import christmas.domain.Order;
import christmas.domain.User;
import christmas.service.Appetizer;
import christmas.service.Dessert;
import christmas.service.Drink;
import christmas.service.MainDish;
import christmas.view.InputView;

import java.util.HashMap;
import java.util.Map;

public class ChristmasController implements MainDish, Drink, Dessert, Appetizer {
	private final Map<String, Integer> menuPrice;
	private final Map<String, Integer> drinkMenuPrice;
	private int date;
	public ChristmasController(){
		this.menuPrice = getMenuPrice();
		this.drinkMenuPrice = getDrinks();
	}
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
			drinkMenuPrice.put(order[0], Integer.parseInt(order[1].replace(")", "")));
		}
		return drinkMenuPrice;
	}

	public void run() {
		InputView inputView = new InputView(menuPrice, drinkMenuPrice);
		User user = new User(inputView.getDate(), inputView.getOrders(), menuPrice);
		user.userOrderRun();
	}
}
