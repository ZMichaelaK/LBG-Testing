package testing.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import testing.Calculator;

public class CalcTest {
	private Calculator calc = new Calculator();
	@Test
	void testAdd() {
			Assertions.assertEquals(8, this.calc.add(4, 4));
	}
	@Test
	void testSubtract() {
		Assertions.assertEquals(15, this.calc.subtract(30, 15));
}
	@Test
	void testDivide() {
		Assertions.assertEquals(25, this.calc.divide(50, 2));
}
	@Test
	void testMultiply() {
		Assertions.assertEquals(64, this.calc.multiply(8, 8));
}
}
