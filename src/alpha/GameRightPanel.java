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
	private TetrisView view;
	private JLabel ScoreLabel;
	private JButton StateButton;
	private GameState NextState;

	public GameRightPanel(TetrisView v) {
		this.view = v;
		this.setLayout(new GridLayout(3, 1));
		ScoreLabel = new JLabel("分數:");
		ScoreLabel.setFont(new Font(ScoreLabel.getFont().getFontName(), Font.PLAIN, 50));
		this.add(ScoreLabel);
		this.NextState = GameState.Playing;
		StateButton = new JButton("開始");
		StateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controller.ChangeView(ViewsEnum.gameView);
				System.out.println("change");
				view.changeState(NextState);
			}
		});
		this.add(StateButton);

		JButton developerBtn = new JButton("開發者");
		developerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// controller.ChangeView(ViewsEnum.gameView);
				System.out.println("change");
				view.changeScene(SceneRoute.Developer);
			}
		});

		this.add(developerBtn);

		this.setBackground(Color.white);
	}

	public void updateStateText(String state) {
		StateButton.setText(state);
	}

	public void setNextState(GameState state) {
		this.NextState = state;
	}

	public void updateScore(int score) {
		ScoreLabel.setText("分數:" + score);
	}
}
