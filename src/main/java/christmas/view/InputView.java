package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static christmas.ErrorMessage.*;

public class InputView {
	private static String line;
	private final Map<String, Integer> drinks;
	private final Map<String, Integer> menuPrice;

	public InputView(Map<String, Integer> menuPrice, Map<String, Integer> drinks) {
		this.drinks = drinks;
		this.menuPrice = menuPrice;
	}

	public int getDate() {
		System.out.println("방문 날짜를 입력해 주세요.");
		line = Console.readLine();
		while (!validateDate(line)) {
			line = Console.readLine().trim();
		}
		return Integer.parseInt(line);
	}

	public String getOrders() {
		System.out.println("메뉴를 입력해 주세요.");
		line = Console.readLine().trim();
		while (!validateOrders(line)) {
			line = Console.readLine();
		}
		return line;
	}

	private boolean validateDate(String line) {
		try {
			int date = Integer.parseInt(line);
			if (date < 1 || date > 31)
				throw new IllegalArgumentException(RANGE.getMessage());
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(NOT_EXIST_DATE.getMessage() + e.getMessage());
			return false;
		}
		return true;
	}

	private boolean validateOrders(String line) {
		try {
			checkErrors(line);
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(NOT_EXIST_ORDER.getMessage() + e.getMessage());
			return false;
		}
		return true;
	}

	private void checkErrors(String line) {
		if (line.isEmpty())
			throw new IllegalStateException(EMPTY.getMessage());
		String[] menus = line.split(",");
		List<String> menuList = new ArrayList<>();
		for (String menu : menus) {
			String[] order = menu.trim().split("-");
			if (menuList.contains(order[0].trim()))
				throw new IllegalArgumentException(DUPLICATE.getMessage());
			if (!menuPrice.containsKey(order[0].trim()))
				throw new IllegalArgumentException(NOT_EXIST_MENU.getMessage());
			menuList.add(order[0].trim());
			int menuCount = Integer.parseInt(order[1]);
			if (menuCount < 1 | menuCount > 20)
				throw new IllegalArgumentException(RANGE.getMessage());
		}
		if (isDrinkOnly(menuList))
			throw new IllegalArgumentException(DRINK_ONLY.getMessage());
	}

	private boolean isDrinkOnly(List<String> menuList) {
		for (String menu : menuList) {
			if (!drinks.containsKey(menu))
				return false;
		}
		return true;
	}
}
