package christmas;

public enum ErrorMessage {

	NOT_EXIST_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
	NOT_EXIST_MENU("That menu does not exist."),
	RANGE("Rnage is out of bounds."),
	EMPTY("Empty error is occurred"),
	DRINK_ONLY("Drink only error is occurred"),
	DUPLICATE("Duplicate error is occurred"),
	NOT_EXIST_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
