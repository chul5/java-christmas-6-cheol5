package christmas.service;

public enum Number {
	WEEK_DISCOUNT(2023),
	SET_EVENT_MONEY(10000),
	SPECIAL_DISCOUNT(1000),
	GIFT(120000);

	private int price;

	Number(int price){
		this.price = price;
	}

	public int getValue() {
		return price;
	}
}
