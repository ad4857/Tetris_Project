package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beta.TetrisController;

class testTetrisController {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		TetrisController controller = new TetrisController();
		controller.start();
	}

}
