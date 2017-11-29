package test;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class gameView  extends JPanel {
	private StateController controller;

	public gameView(StateController controller) {
		this.controller = controller;
		this.setView();
	}

	public void setView() {
		JButton button = new JButton("離開");
		JLabel label = new JLabel("遊戲畫面", SwingConstants.CENTER);
		JTextArea textarea = new JTextArea("JTextArea");
	
		label.setPreferredSize(new Dimension(100, 25));
		label.setFont(new Font(label.getFont().getFontName(), Font.PLAIN, 50));	
		textarea.setEditable(false);
		textarea.setFont(new Font(label.getFont().getFontName(), Font.PLAIN, 30));	
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ChangeView(ViewsEnum.developerView);
			}
		});
		this.setLayout(new GridLayout(3, 1));		
		this.add(label);
		this.add(textarea);
		this.add(button);
	
		this.setBorder(BorderFactory.createEtchedBorder());
	}
}
