package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beta.components.TetrisBlock;
import beta.components.TetrisEngine;

class testTetrisEngine {

	@Test
	void testGameover() {
		TetrisEngine engine = new TetrisEngine(20, 16);
		while (!engine.updateArr()) {
		}
		assertEquals(null, engine.fallBlock);
	}

	@Test
	void testBorderCollision() {
		TetrisEngine engine = new TetrisEngine(20, 16);
		while (!engine.updateArr()) {
			Random rand = new Random();
			int n = rand.nextInt(4) - 1;
			int count = rand.nextInt(20);
			for (int i = 0; i < count; i++) {
				engine.move(n);
			}
		}
		assertEquals(null, engine.fallBlock);
	}

	@Test
	void testRowclear() {
		TetrisEngine engine = new TetrisEngine(20, 16);
		ArrayList<TetrisBlock> blocks = new ArrayList<TetrisBlock>();
		for (int i = 0; i < 4; i++) {
			TetrisBlock b = new TetrisBlock('I', Color.BLACK);
			b.left = i * 4;
			engine.fallBlock = b;
			engine.move(-1);
			engine.updateArr();
		}
		assertTrue("clear error", engine.score == 100);
	}

}
