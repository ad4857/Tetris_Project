package beta.components;

import beta.*;
import beta.enums.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
	private TetrisView view;
	private GameRightPanel rightPanel;
	private GameArea gameArea;
	private GameState NextState;
	private Timer timer;
	private TetrisEngine engine;

	public GamePanel(TetrisView v) {
		this.view = v;
		this.setLayout(new GridLayout(1, 2));
		NextState = GameState.Playing;
		rightPanel = new GameRightPanel();
		rightPanel.developerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.changeScene(SceneRoute.Developer);
			}
		});
		rightPanel.StateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateState();
				requestFocus();
			}
		});
		gameArea = new GameArea();
		engine = new TetrisEngine(20, 16);

		timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!engine.updateArr()) {
					gameArea.setArr(engine.SquareArr);
				} else {
					System.out.println("timer stop");
					timer.stop();
					JOptionPane.showMessageDialog(null, "遊戲結束");
					NextState = GameState.Idle;
					updateState();
				}
				rightPanel.ScoreLabel.setText("分數:" + engine.score);
			}
		});

		timer.setRepeats(true);
		gameArea.setFocusable(false);
		this.add(gameArea);
		this.add(rightPanel);
		this.addKeyListener(this);
	}

	public void updateState() {
		System.out.println("update " + NextState.toString());
		switch (NextState) {
		case Idle:
			this.rightPanel.StateButton.setText("開始");
			NextState = GameState.Playing;
			engine = new TetrisEngine(20, 16);
			break;
		case Playing:

			this.rightPanel.StateButton.setText("暫停");
			NextState = GameState.Paused;
			timer.start();
			break;
		case Paused:
			this.rightPanel.StateButton.setText("繼續");
			NextState = GameState.Playing;
			timer.stop();
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Pressed:" + e.getKeyCode() + ":" + e.getKeyChar());
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
		gameArea.setArr(engine.SquareArr);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
