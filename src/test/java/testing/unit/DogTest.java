package testing.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import testing.Dog;

public class DogTest {
	private Dog dog = new Dog();
	@Test
	void TestNoise() {
		Assertions.assertEquals("Woof", dog.makeNoise());
	}
}
