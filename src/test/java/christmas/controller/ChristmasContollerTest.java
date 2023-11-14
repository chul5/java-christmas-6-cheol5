package christmas.controller;



import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
class ChristmasContollerTest extends NsTest{

	private ChristmasContoller christmasContoller;

	@BeforeEach
	void setUp() {
		christmasContoller = new ChristmasContoller();
	}

	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}