package alpha;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private TetrisView view;
	private GameRightPanel rightPanel;
	private GameLeftPanel leftPanel;

	public GamePanel(TetrisView v) {
		this.view = v;
		this.setLayout(new GridLayout(1, 2));
		rightPanel = new GameRightPanel(v);
		leftPanel = new GameLeftPanel(v);
		this.add(leftPanel);
		this.add(rightPanel);
	}

	public void updateState(GameState state) {
		switch (state) {
		case Idle:
			this.rightPanel.updateStateText("¶}©l");
			this.rightPanel.setNextState(GameState.Playing);
			break;
		case Playing:
			this.rightPanel.updateStateText("¼È°±");
			this.rightPanel.setNextState(GameState.Paused);
			break;
		case Paused:
			this.rightPanel.updateStateText("Ä~Äò");
			this.rightPanel.setNextState(GameState.Playing);
			break;
		}
	}
}
