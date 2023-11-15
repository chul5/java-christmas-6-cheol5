package christmas.controller;



import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

class ChristmasContollerTest extends NsTest{

	private ChristmasController christmasContoller;

	@BeforeEach
	void setUp() {
		christmasContoller = new ChristmasController();
	}

	@ParameterizedTest
	@CsvSource({"양송이수프, 6000", "시저샐러드, 8000", "타파스, 5500"})
	void getMenuPrice테스트(String input1, int expected) {
		Map<String, Integer> menu = christmasContoller.getMenuPrice();
		assertThat(menu.get(input1)).isEqualTo(expected);
	}

	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}