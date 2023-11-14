package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.ErrorMessage.NOT_NUMBER;

public class InputView {
	private String line;

	public int getDate() {
		System.out.println("방문 날짜를 입력해 주세요.");
		line = Console.readLine();
		while (!validateDate(line)) {
			System.out.println("방문 날짜를 다시 입력해 주세요.");
			line = Console.readLine();
		}
		return Integer.parseInt(line);
	}

	public String getOrders() {
		System.out.println("메뉴를 입력해 주세요.");
		line = Console.readLine();
		while (!validateOrders(line)) {
			System.out.println("메뉴를 다시 입력해 주세요.");
			line = Console.readLine();
		}
		return line;
	}

	private boolean validateDate(String line) {
		try {
			int date = Integer.parseInt(line);
			if(date < 1 || date > 31)
				throw new IllegalArgumentException(NOT_NUMBER.getMessage());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(NOT_NUMBER.getMessage();
			return false;
		}
		return true;
	}
	private boolean validateOrders(String line) {
		try{
			String[] menus = line.split(",");
			for(String menu : menus) {
				String[] order = menu.split("-");
				if(order.length != 2) {
					return false;
				}
				Integer.parseInt(order[1]);
			}
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}
}
