package christmas.service;
import christmas.service.Number.*;

import static christmas.service.Number.*;

public class Discount {
	private int dicountMoney;

	public int weekdayDiscount(int totalPrice){
		return totalPrice - WEEK_DISCOUNT.getValue();
	}

	public boolean isApplyEvent(int totalMoney){
		return totalMoney >= 10000;
	}
}
