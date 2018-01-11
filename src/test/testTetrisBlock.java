package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import beta.components.*;

class testTetrisBlock {
	static Color color = Color.BLACK;
	static Color[][] ShapeI = { { null, null, null, null }, { color, color, color, color }, { null, null, null, null },
			{ null, null, null, null } };
	static Color[][] ShapeL = { { null, null, null }, { color, color, color }, { color, null, null } };
	static Color[][] ShapeJ = { { color, null, null }, { color, color, color }, { null, null, null } };
	static Color[][] ShapeO = { { color, color }, { color, color } };
	static Color[][] ShapeS = { { null, color, color }, { color, color, null }, { null, null, null } };
	static Color[][] ShapeZ = { { color, color, null }, { null, color, color }, { null, null, null } };
	static Color[][] ShapeT = { { null, color, null }, { color, color, color }, { null, null, null } };

	@Test
	void testShapeI() {
		TetrisBlock block = new TetrisBlock('I', color);
		assertArrayEquals(ShapeI, block.BlockArr);
	}

	@Test
	void testShapeL() {
		TetrisBlock block = new TetrisBlock('L', color);
		assertArrayEquals(ShapeL, block.BlockArr);
	}

	@Test
	void testShapeJ() {
		TetrisBlock block = new TetrisBlock('J', color);
		assertArrayEquals(ShapeJ, block.BlockArr);
	}

	@Test
	void testShapeO() {
		TetrisBlock block = new TetrisBlock('O', color);
		assertArrayEquals(ShapeO, block.BlockArr);
	}

	@Test
	void testShapeS() {
		TetrisBlock block = new TetrisBlock('S', color);
		assertArrayEquals(ShapeS, block.BlockArr);
	}

	@Test
	void testShapeZ() {
		TetrisBlock block = new TetrisBlock('Z', color);
		assertArrayEquals(ShapeZ, block.BlockArr);
	}

	@Test
	void testShapeT() {
		TetrisBlock block = new TetrisBlock('T', color);
		assertArrayEquals(ShapeT, block.BlockArr);
	}

	@Test
	void testRotate() {
		Random rand = new Random();
		int n = rand.nextInt();
		char s = randomShape();
		TetrisBlock block1 = new TetrisBlock(s, color, n);
		TetrisBlock block2 = new TetrisBlock(s, color, n + 4);
		assertArrayEquals(block1.BlockArr, block2.BlockArr);
	}

	char randomShape() {
		Random rand = new Random();
		int n = rand.nextInt(7);
		switch (n) {
		case 0:
			return 'I';
		case 1:
			return 'L';
		case 2:
			return 'J';
		case 3:
			return 'S';
		case 4:
			return 'Z';
		case 5:
			return 'O';
		case 6:
			return 'T';
		}
		return 'T';
	}
}
