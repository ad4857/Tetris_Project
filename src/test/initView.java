package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //事件

public class initView extends JPanel {
	private StateController controller;

	public initView(StateController controller) {
		this.controller = controller;
		this.setView();
	}

	public void setView() {
		JButton button = new JButton("進入遊戲");
		JLabel label = new JLabel("俄羅斯方塊", SwingConstants.CENTER);
		JTextArea textarea = new JTextArea("操作說明");
	
		label.setPreferredSize(new Dimension(100, 25));
		label.setFont(new Font(label.getFont().getFontName(), Font.PLAIN, 50));	
		textarea.setEditable(false);
		textarea.setFont(new Font(label.getFont().getFontName(), Font.PLAIN, 30));	
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ChangeView(ViewsEnum.gameView);
			}
		});
		this.setLayout(new GridLayout(3, 1));		
		this.add(label);
		this.add(textarea);
		this.add(button);
	
		this.setBorder(BorderFactory.createEtchedBorder());
	}
}
