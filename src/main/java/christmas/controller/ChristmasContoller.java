package christmas.controller;

import java.util.HashMap;
import java.util.Map;

public class ChristmasContoller {
	private Map<String, Integer> menuPrice;
	private final String appetizer = "양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)";
	private final String maindish = "티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)";
	private final String dessert = "초코케이크(15,000), 아이스크림(5,000)";
	private final String drink = "제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)";
	private String menuName;
	Map<String, Integer> menuInit(){
		Map<String, Integer> menuPrice = new HashMap<>();
		String line = appetizer + "," + maindish + "," + dessert + "," + drink;
		String[] menus = line.split(",");
		for(String menu : menus) {
			String[] order = menu.split("\\(");
			menuPrice.put(order[0], Integer.parseInt(order[1].replace(")", "")));
		}
		return menuPrice;
	}
}
