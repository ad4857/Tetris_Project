package alpha;

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
	private TetrisController controller;

	public StartupPanel(TetrisController c) {
		this.controller = c;
		JButton button = new JButton("進入遊戲");
		JLabel label = new JLabel("俄羅斯方塊", SwingConstants.CENTER);
		JTextArea textarea = new JTextArea("操作說明");
		label.setFont(new Font(label.getFont().getFontName(), Font.PLAIN, 50));
		textarea.setEditable(false);
		textarea.setFont(new Font(label.getFont().getFontName(), Font.PLAIN, 30));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controller.ChangeView(ViewsEnum.gameView);
				System.out.println("change");
				controller.getView("game");
			}
		});
		this.setLayout(new GridLayout(3, 1));
		this.add(label);
		this.add(textarea);
		this.add(button);
		this.setBorder(BorderFactory.createEtchedBorder());
	}

}
