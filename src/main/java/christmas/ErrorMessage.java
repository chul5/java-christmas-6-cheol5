package christmas;

public enum ErrorMessage {

	NOT_EXIST_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
	NOT_NUMBER("[ERROR] It's not a number."),
	RANGE("범위를 벗어났습니다."),
	EMPTY("[ERROR] 입력이 없습니다."),
	NOT_EXIST_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
