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
	public GameArea gameArea;
	public JLabel nowScore, maxScore;
	public JButton startButton, pauseButton, stopButton, developerButton;
	public GameState state;

	public GamePanel() {
		this.setLayout(new GridLayout(1, 2));
		gameArea = new GameArea();
		JPanel ScorePanel = new JPanel();
		JPanel RightPanel = new JPanel();
		RightPanel.setLayout(new GridLayout(3, 1));
		ScorePanel.setLayout(new GridLayout(2, 1));
		nowScore = new JLabel("目前分數");
		nowScore.setFont(new Font(nowScore.getFont().getFontName(), Font.PLAIN, 30));
		maxScore = new JLabel("最高分");
		maxScore.setFont(new Font(maxScore.getFont().getFontName(), Font.PLAIN, 20));
		ScorePanel.add(nowScore);
		ScorePanel.add(maxScore);
		RightPanel.add(ScorePanel);

		JPanel ButtonsPanel = new JPanel();
		ButtonsPanel.setLayout(new GridLayout(3, 1));
		startButton = new JButton("開始");
		pauseButton = new JButton("暫停");
		stopButton = new JButton("結束遊戲");
		pauseButton.setEnabled(false);
		stopButton.setEnabled(false);
		ButtonsPanel.add(startButton);
		ButtonsPanel.add(pauseButton);
		ButtonsPanel.add(stopButton);
		RightPanel.add(ButtonsPanel);

		JPanel OtherPanel = new JPanel();
		OtherPanel.setLayout(new GridLayout(1, 1));
		developerButton = new JButton("開發者");
		OtherPanel.add(developerButton);
		RightPanel.add(OtherPanel);

		this.add(gameArea);
		this.add(RightPanel);
		state = GameState.Idle;
	}

	public void update(Color[][] model) {
		this.gameArea.setArr(model);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("Pressed:" + e.getKeyCode() + ":" + e.getKeyChar());
		// switch (e.getKeyCode()) {
		// case KeyEvent.VK_SPACE:
		// engine.move(-1);
		// break;
		// case KeyEvent.VK_UP:
		// engine.move(0);
		// break;
		// case KeyEvent.VK_LEFT:
		// engine.move(1);
		// break;
		// case KeyEvent.VK_RIGHT:
		// engine.move(2);
		// break;
		// case KeyEvent.VK_DOWN:
		// engine.move(3);
		// break;
		// }
		// gameArea.setArr(engine.SquareArr);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
