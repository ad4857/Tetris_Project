package alpha;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

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

	public void setCanvas() {
		
	}
}
