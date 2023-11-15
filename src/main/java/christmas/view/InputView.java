package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static christmas.ErrorMessage.*;
public class InputView {
	private static String line;
	public static int getDate() {
		System.out.println("방문 날짜를 입력해 주세요.");
		line = Console.readLine();
		while (!validateDate(line)) {
			line = Console.readLine().trim();
		}
		return Integer.parseInt(line);
	}

	public static String getOrders(Map<String, Integer> menuPrice) {
		System.out.println("메뉴를 입력해 주세요.");
		line = Console.readLine().trim();
		while (!validateOrders(line, menuPrice)) {
			line = Console.readLine();
		}
		return line;
	}

	private static boolean validateDate(String line) {
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

	private static boolean validateOrders(String line, Map<String, Integer> menuPrice) {
		try {
			checkErrors(line, menuPrice);
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(NOT_EXIST_ORDER.getMessage() + e.getMessage());
			return false;
		}
		return true;
	}

	private static void checkErrors(String line, Map<String, Integer> menuPrice) {
		if (line.isEmpty())
			throw new IllegalStateException(EMPTY.getMessage());
		String[] menus = line.split(",");
		List<String> menuList = new ArrayList<>();
		for (String menu : menus) {
			String[] order = menu.split("-");
			if (menuList.contains(order[0]))
				throw new IllegalArgumentException(DUPLICATE.getMessage());
			if (!menuPrice.containsKey(order[0]))
				throw new IllegalArgumentException(NOT_EXIST_MENU.getMessage());
			menuList.add(order[0]);
			int menuCount = Integer.parseInt(order[1]);
			if (menuCount < 1 | menuCount > 20)
				throw new IllegalArgumentException(RANGE.getMessage());
		}
	}
}
