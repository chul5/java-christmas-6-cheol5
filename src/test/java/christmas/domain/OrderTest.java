package christmas.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
	@Test
	void 문자열_구분하는_기능()  {
		Order order = new Order("chicken-1,coke-2");
		order.splitOrders();
		assertThat(order.getOrders()).isEqualTo("chicken 1개\ncoke 2개\n");
	}

	@Test
	void 총금액을_계산하는_기능(){

	}
}