package beta;
import beta.enums.*;

import java.util.Timer;

public class TetrisModel {
	private TetrisView view;
	private GameState state;
	private int Score;
	private Timer timer;

	public TetrisModel(TetrisView v) {
		this.view = v;
		this.timer = new Timer();
		this.state = GameState.Idle;
	}

	public GameState getState(GameState state) {	
		return this.state;
	}

}
