package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import beta.TetrisController;
import beta.TetrisModel;
import beta.TetrisView;
import beta.enums.GameState;

class testTetrisVIew {
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
	void test() {
		view.initWindow();
	}

	@Test
	void testStarupView() {
		view.initWindow();
		view.stateHasChanged(null, GameState.ViewStartup);
	}

	@Test
	void testGameView() {
		view.initWindow();
		view.stateHasChanged(model, GameState.Idle);
		view.stateHasChanged(model, GameState.Playing);
		view.stateHasChanged(model, GameState.Paused);
		view.stateHasChanged(model, GameState.Stop);
	}

}
