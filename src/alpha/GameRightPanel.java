package alpha;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GameRightPanel extends JPanel {
	private TetrisController controller;

	public GameRightPanel(TetrisController c) {
		this.controller = c;
		this.setLayout(new GridLayout(3, 1));
		JLabel RLabel1 = new JLabel("難度設定或記分板");
		RLabel1.setFont(new Font(RLabel1.getFont().getFontName(), Font.PLAIN, 50));
		this.add(RLabel1);

		this.add(new JButton("start,pause,resume"));

		JButton developerBtn = new JButton("開法者");
		developerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controller.ChangeView(ViewsEnum.gameView);
				System.out.println("change");
				controller.getView("developer");
			}
		});
		this.add(developerBtn);

		this.setBackground(Color.white);
	}
}
