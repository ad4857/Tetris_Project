package alpha;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class GameLeftPanel extends JPanel {
	private TetrisController controller;

	public GameLeftPanel(TetrisController c) {
		this.controller = c;
		JLabel LLabel = new JLabel("¹CÀ¸°Ï°ì");
		LLabel.setFont(new Font(LLabel.getFont().getFontName(), Font.PLAIN, 50));
		this.add(LLabel);
	}
}
