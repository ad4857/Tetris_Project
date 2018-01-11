package beta.components;

import beta.*;
import beta.enums.*;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class StartupPanel extends JPanel {
	public JButton enterButton;
	public JLabel title;
	public JTextArea description;

	public StartupPanel() {
		enterButton = new JButton("進入遊戲");
		title = new JLabel("俄羅斯方塊", SwingConstants.CENTER);
		description = new JTextArea("操作說明");
		title.setFont(new Font(title.getFont().getFontName(), Font.PLAIN, 50));
		description.setEditable(false);
		description.setFont(new Font(description.getFont().getFontName(), Font.PLAIN, 30));
		this.setLayout(new GridLayout(3, 1));
		this.add(title);
		this.add(description);
		this.add(enterButton);
		this.setBorder(BorderFactory.createEtchedBorder());
	}

}
