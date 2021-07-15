package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSize() {
		fail("Not yet implemented");
	}

	@Test
	void testArrayList() {
		fail("Not yet implemented");
	}

	@Test
	void testAddE() {
		fail("Not yet implemented");
	}

	@Test
	void testEnsureCapacity() {
		int actual = ArrayList.ensureCapacity(9);
		int expected = 10;
		assertEquals(actual,expected);
	}

	@Test
	void testEnsureCapacityInternal() {
		fail("Not yet implemented");
	}

	@Test
	void testEnsureExplicitCapacity() {
		fail("Not yet implemented");
	}

	@Test
	void testGrow() {
		int actual = ArrayList.grow(11);
		int expected = 13;
		assertEquals(actual,expected);
	}

	@Test
	void testHugeCapacity() {
		long actual = ArrayList.hugeCapacity(4456);
		long expected = 2147483627;
		assertEquals(actual,expected);
	}

	@Test
	void testGetInt() {
		fail("Not yet implemented");
	}

}
