package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beta.TetrisController;
import beta.TetrisModel;
import beta.TetrisView;
import beta.enums.GameState;

class testTetrisModel {
	TetrisController controller;
	TetrisModel model;
	TetrisView view;

	@BeforeEach
	void setUp() throws Exception {
		controller = new TetrisController();
		view = new TetrisView(controller);
		model = new TetrisModel(view);
	}

	@Test
	void testIdle() {
		model.setState(GameState.Idle);
	}

	@Test
	void testPlaying() {
		model.setState(GameState.Idle);
		model.setState(GameState.Playing);
		assertTrue("clear error", model.getArr() != null);
	}
}
