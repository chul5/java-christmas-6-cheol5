package christmas;

public enum ErrorMessage {

	NOT_EXIST_MENU("[ERROR]:존재하지 않는 메뉴입니다."),
	NOT_EXIST_GRADE("[ERROR]:존재하지 않는 등급입니다."),
	NOT_EXIST_NUMBER("[ERROR]:존재하지 않는 번호입니다."),
	NOT_EXIST_ORDER("[ERROR]:존재하지 않는 주문입니다."),
	NOT_EXIST_ORDERED_MENU("[ERROR]:존재하지 않는 주문 메뉴입니다."),
	NOT_NUMBER("[ERROR]:It's not a number.");
	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
