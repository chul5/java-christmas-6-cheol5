package christmas.service;

import christmas.view.OutputView;

import java.util.Map;
import java.util.Set;

import static christmas.service.Number.*;
import static christmas.view.OutputView.*;

public class Event implements Dessert, MainDish {
	private int mainDishes = 0;
	private int desserts = 0;
	Map<String, Integer> menuPrice;
	Map<String, Integer> orders;
	public Event(Map<String, Integer> menuPrice, Map<String, Integer> orders){
		this.menuPrice = menuPrice;
		this.orders = orders;
		setMenuTypeCount();
	}

	public void setMenuTypeCount(){
		Set<String> orderSet = orders.keySet();
		for (String menu : orderSet){
			if (dessert.contains(menu))
				desserts++;
			if (maindish.contains(menu))
				mainDishes++;
		}
	}

	public int calculateDiscount(int date, int totalMoney){
		int totalDiscount = 0;
		int remainder = date % 7;
		totalDiscount += checkTotalMoney(totalMoney);
		OutputView.printMessage(BENEFITS);
		totalDiscount += checkChristmasDday(date);
		totalDiscount += checkRemainder(remainder, date);
		if (totalMoney >= GIFT.getValue()) {
			OutputView.printMessage(GIFT_DISCOUNT_MESSAGE);
			OutputView.printIntegers(-menuPrice.get("샴페인"));
		}
		return totalDiscount;
	}

	private int checkRemainder(int remainder, int date){
		int tempDiscount = 0;
		if ((4 <= remainder || remainder == 0) && desserts > 0) {
			tempDiscount += desserts * WEEK_DISCOUNT.getValue();
			OutputView.printMessage(WEEKDAY_DISCOUNT);
			OutputView.printIntegers(-tempDiscount);
		}
		if ((remainder == 1 || remainder == 2) && mainDishes > 0){
			tempDiscount += mainDishes * WEEK_DISCOUNT.getValue();
			OutputView.printMessage(WEEKEND_DISCOUNT_MESSAGE);
			OutputView.printIntegers(-tempDiscount);
		}
		if (remainder == 3 || date == 25) {
			tempDiscount += SPECIAL_DISCOUNT.getValue();
			OutputView.printMessage(SPECIAL_DISCOUNT_MESSAGE);
			OutputView.printIntegers(-SPECIAL_DISCOUNT.getValue());
		}
		return tempDiscount;
	}
	private int checkTotalMoney(int totalMoney){
		OutputView.printMessage(GIFT_MESSAGE);
		if (totalMoney >= GIFT.getValue()) {
			OutputView.printMessage("샴페인 1개%n%n");
			return menuPrice.get("샴페인");
		}
		OutputView.printMessage("없음%n%n");
		return 0;
	}
	private int checkChristmasDday(int date){
		int tempDiscount = 0;
		if (date <= 25){
			tempDiscount = 1000 + (date - 1) * 100;
			OutputView.printMessage(CHRISTMAS_DDAY);
			OutputView.printIntegers(-tempDiscount);
		}
		return tempDiscount;
	}

	public boolean isApplyEvent(int totalMoney){
		return totalMoney >= SET_EVENT_MONEY.getValue();
	}
}
