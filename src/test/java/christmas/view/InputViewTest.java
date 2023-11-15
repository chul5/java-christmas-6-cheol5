package christmas.view;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.controller.ChristmasContoller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
	InputView inputView;
	ChristmasContoller christmasContoller;

	@BeforeEach
	void setUp() {
		christmasContoller = new ChristmasContoller();
		inputView = new InputView(christmasContoller.getMenuPrice(), christmasContoller.getDrinks());
	}

	@ParameterizedTest
	@CsvSource({" ,[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.", "a,[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.", "0,[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."})
	void 입력날짜_에러체크(String input, String expected) {
		assertSimpleTest(() -> {
			runException(input);
			assertThat(output()).contains(expected);
		});
	}

	@ParameterizedTest
	@CsvSource({"1, ,[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", "1,,[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.",
			"1,티본스테이크-21,[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", "1,시저샐러드-0,[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."})
	void 주문입력에러체크(String input1, String input2, String expected) {
		assertSimpleTest(() -> {
			runException(input1, input2);
			assertThat(output()).contains(expected);
		});
	}



	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}