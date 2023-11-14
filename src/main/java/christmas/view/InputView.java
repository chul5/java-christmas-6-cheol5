package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

import static christmas.ErrorMessage.*;
public class InputView {
	private String line;

	public int getDate() {
		System.out.println("방문 날짜를 입력해 주세요.");
		line = Console.readLine();
		while (!validateDate(line)) {
			line = Console.readLine();
		}
		return Integer.parseInt(line);
	}

	public String getOrders(Map<String, Integer> menuPrice) {
		System.out.println("메뉴를 입력해 주세요.");
		line = Console.readLine();
		while (!validateOrders(line, menuPrice)) {
			line = Console.readLine();
		}
		return line;
	}

	private boolean validateDate(String line) {
		try {
			int date = Integer.parseInt(line);
			if(date < 1 || date > 31)
				throw new IllegalArgumentException(RANGE.getMessage());
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(NOT_EXIST_DATE.getMessage() + e.getMessage());
			return false;
		}
		return true;
	}
	private boolean validateOrders(String line, Map<String, Integer> menuPrice) {
		try{
			if (line.isEmpty())
				throw new IllegalStateException(EMPTY.getMessage());
			String[] menus = line.split(",");
			for(String menu : menus) {
				String[] order = menu.split("-");
				if(!menuPrice.containsKey(order[0]))
					throw new IllegalArgumentException(NOT_EXIST_MENU.getMessage());
				Integer.parseInt(order[1]);
			}
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(NOT_EXIST_ORDER.getMessage() + e.getMessage());
			return false;
		}
		return true;
	}
}
