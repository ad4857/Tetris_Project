package beta;

import beta.components.TetrisEngine;
import beta.enums.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.Timer;

public class TetrisModel {
	private TetrisView view;
	private GameState state;
	private Timer timer;
	private TetrisEngine engine;
	private Dictionary<String, String> db;

	public TetrisModel(TetrisView v) {
		this.view = v;
		this.db = new Hashtable<String, String>();
	}

	public void setState(GameState state) {
		this.state = state;
		switch (this.state) {
		case Idle:
			this.engine = new TetrisEngine(20, 16);
			timer = new Timer(300, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (!engine.updateArr()) {
						view.updateView();
						db.put("normal", engine.score + "");
					} else {
						if (db.get("max") != null) {
							int s = Integer.parseInt(db.get("max"));
							if (engine.score > s) {
								db.put("max", engine.score + "");
							}
						} else {
							db.put("max", engine.score + "");
						}
						setState(GameState.Gameover);

					}

				}
			});
			timer.setRepeats(true);
			break;
		case Playing:
			timer.start();
			break;
		case Paused:
			timer.stop();
			break;
		case Stop:
			timer.stop();
			setState(GameState.Idle);
			break;
		case Gameover:
			timer.stop();
			this.view.stateHasChanged(this, state);
			this.state = GameState.Idle;
			this.engine = new TetrisEngine(20, 16);
			timer = new Timer(300, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (!engine.updateArr()) {
						view.updateView();
						db.put("normal", engine.score + "");
					} else {
						if (db.get("max") != null) {
							int s = Integer.parseInt(db.get("max"));
							if (engine.score > s) {
								db.put("max", engine.score + "");
							}
						} else {
							db.put("max", engine.score + "");
						}
						setState(GameState.Gameover);

					}

				}
			});
			timer.setRepeats(true);
			break;
		case ViewDeveloper:
			timer.stop();
			this.view.stateHasChanged(this, this.state);
			return;
		}
		this.view.stateHasChanged(this, this.state);

	}

	public Color[][] getArr() {
		if (this.engine != null) {
			return engine.SquareArr;
		}
		return null;
	}

	public void setAction(KeyEvent e) {
		// TODO Auto-generated method stub

		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			engine.move(-1);
			break;
		case KeyEvent.VK_UP:
			engine.move(0);
			break;
		case KeyEvent.VK_LEFT:
			engine.move(1);
			break;
		case KeyEvent.VK_RIGHT:
			engine.move(2);
			break;
		case KeyEvent.VK_DOWN:
			engine.move(3);
			break;
		}
		view.updateView();
	}

	public GameState getGameState() {
		return this.state;
	}

	public String getScore(String query) {
		if (db.get(query) != null) {
			return db.get(query);
		}
		return 0 + "";
	}

}
