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
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private TetrisView view;
	private GameRightPanel rightPanel;
	// private GamegameArea gameArea;
	private GameArea gameArea;
	private GameState NextState;

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
			}
		});

		gameArea = new GameArea();
		this.add(gameArea);
		this.add(rightPanel);
		
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Typed:" + e.getKeyCode());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Pressed:" + e.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Released:" + e.getKeyCode());
			}
		});

	}

	public void updateState() {
		System.out.println("update " + NextState.toString());
		switch (NextState) {
		case Idle:
			this.rightPanel.StateButton.setText("¶}©l");
			NextState = GameState.Playing;
			break;
		case Playing:
			this.rightPanel.StateButton.setText("¼È°±");
			NextState = GameState.Paused;
			gameArea.start();
			break;
		case Paused:
			this.rightPanel.StateButton.setText("Ä~Äò");
			NextState = GameState.Playing;
			gameArea.pause();
			break;
		}
	}
}
