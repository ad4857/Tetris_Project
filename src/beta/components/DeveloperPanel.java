package beta.components;
import beta.TetrisView;
import beta.enums.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DeveloperPanel extends JPanel {
	private TetrisView view;

	public DeveloperPanel(TetrisView v) {
		this.view = v;
		this.setLayout(new GridLayout(2, 1));
		JLabel RLabel3 = new JLabel("開發者1", SwingConstants.CENTER);
		RLabel3.setFont(new Font(RLabel3.getFont().getFontName(), Font.PLAIN, 50));
		JButton backBtn = new JButton("返回遊戲");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controller.ChangeView(ViewsEnum.gameView);
				System.out.println("change");
				view.changeScene(SceneRoute.Game);
			}
		});
		this.add(RLabel3);
		this.add(backBtn);
	}
}
