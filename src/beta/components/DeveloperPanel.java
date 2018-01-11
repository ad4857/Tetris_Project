package beta.components;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class DeveloperPanel extends JPanel {
	public JButton exitButton;
	public JLabel title;
	public JTextArea description;

	public DeveloperPanel() {
		exitButton = new JButton("回到遊戲");
		title = new JLabel("開發者名單", SwingConstants.CENTER);
		description = new JTextArea("B10232009 卓韋辰");
		title.setFont(new Font(title.getFont().getFontName(), Font.PLAIN, 50));
		description.setEditable(false);
		description.setFont(new Font(description.getFont().getFontName(), Font.PLAIN, 30));
		this.setLayout(new GridLayout(3, 1));
		this.add(title);
		this.add(description);
		this.add(exitButton);
		this.setBorder(BorderFactory.createEtchedBorder());
	}

}
