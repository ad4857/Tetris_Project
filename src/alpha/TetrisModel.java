package alpha;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import test.ViewsEnum;

public class TetrisModel {
	private TetrisView view;

	public TetrisModel(TetrisView v) {
		this.view = v;
	}

	public void setState(String scene) {
		System.out.println(scene);
		switch (scene) {
		case "startup":
			JPanel panel = new JPanel();
			JButton button = new JButton("�i�J�C��");
			JLabel label = new JLabel("�Xù�����", SwingConstants.CENTER);
			JTextArea textarea = new JTextArea("�ާ@����");

			label.setFont(new Font(label.getFont().getFontName(), Font.PLAIN, 50));
			textarea.setEditable(false);
			textarea.setFont(new Font(label.getFont().getFontName(), Font.PLAIN, 30));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// controller.ChangeView(ViewsEnum.gameView);
					System.out.println("change");
				}
			});
			panel.setLayout(new GridLayout(3, 1));
			panel.add(label);
			panel.add(textarea);
			panel.add(button);
			panel.setBorder(BorderFactory.createEtchedBorder());
			this.view.changeView(panel);
			break;
		case "game":
			JPanel gamePanel = new JPanel();
			JPanel leftPanel = new JPanel();
			JPanel rightPanel = new JPanel();

			JLabel LLabel = new JLabel("�C���ϰ�");
			LLabel.setFont(new Font(LLabel.getFont().getFontName(), Font.PLAIN, 50));
			leftPanel.add(LLabel);

			rightPanel.setLayout(new GridLayout(3, 1));
			JLabel RLabel1 = new JLabel("���׳]�w�ΰO���O");
			RLabel1.setFont(new Font(RLabel1.getFont().getFontName(), Font.PLAIN, 50));
			rightPanel.add(RLabel1);

			rightPanel.add(new JButton("start,pause,resume"));

			rightPanel.add(new JButton("�}�o��"));

			gamePanel.setLayout(new GridLayout(1, 2));
			rightPanel.setBackground(Color.white);
			gamePanel.add(leftPanel);
			gamePanel.add(rightPanel);
			this.view.changeView(gamePanel);
			break;
		case "developer":
			JPanel developer = new JPanel();
			developer.setLayout(new GridLayout(1, 1));
			JLabel RLabel3 = new JLabel("�}�o��", SwingConstants.CENTER);
			RLabel3.setFont(new Font(RLabel3.getFont().getFontName(), Font.PLAIN, 50));
			developer.add(RLabel3);
			this.view.changeView(developer);
			break;
		}
	}
}
