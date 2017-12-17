package alpha;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private TetrisController controller;

	public GamePanel(TetrisController c) {
		this.controller = c;
		this.setLayout(new GridLayout(1, 2));
		GameRightPanel rightPanel = new GameRightPanel(c);
		GameLeftPanel leftPanel = new GameLeftPanel(c);
		this.add(leftPanel);
		this.add(rightPanel);
	}
}
