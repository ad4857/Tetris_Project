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

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GameRightPanel extends JPanel {
	public JLabel ScoreLabel;
	public JButton StateButton,developerBtn;

	public GameRightPanel() {
		this.setLayout(new GridLayout(3, 1));
		ScoreLabel = new JLabel("分數:");
		ScoreLabel.setFont(new Font(ScoreLabel.getFont().getFontName(), Font.PLAIN, 50));
		this.add(ScoreLabel);
		StateButton = new JButton("開始");
		this.add(StateButton);

		developerBtn = new JButton("開發者");
		this.add(developerBtn);

		this.setBackground(Color.white);
	}
}
