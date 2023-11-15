package christmas.view;

public class OutputView {
	static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.%n" +
			"12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)%n";
	static final String ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)%n";
	public static final String REVIEW_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n";
	public static final String ORDERS = "<주문 메뉴>%n";
	public static final String BEFORE_DISCOUNT = "<할인 전 총주문 금액>%n";
	public static final String GIFT_MESSAGE = "<증정 메뉴>%n";
	public static final String BENEFITS = "<혜택 내역>%n";
	public static final String CHRISTMAS_DDAY = "크리스마스 디데이 할인: ";
	public static final String WEEKEND_DISCOUNT_MESSAGE = "주말 할인: ";
	public static final String WEEKDAY_DISCOUNT = "평일 할인: ";
	public static final String SPECIAL_DISCOUNT_MESSAGE = "특별 할인: ";
	public static final String GIFT_DISCOUNT_MESSAGE = "증정 이벤트: ";
	public static final String TOTAL_DISCOUNT_MESSAGE = "<총혜택 금액>%n";
	public static final String EXPECTED_PRICE = "<할인 후 예상 결제 금액>%n";
	public static final String BADGE_MESSAGE = "<12월 이벤트 배지>%n";
	public static void printMessage(String message) {
		System.out.printf(message);
	}

	public static void printIntegers(int number) {
		System.out.printf("%,d원\n\n", number);
	}
}
