package beta;

import beta.enums.*;
import beta.components.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TetrisView extends JFrame implements KeyListener {
	private TetrisController controller;
	private TetrisModel model;
	private JPanel panel;
	private GameState state;

	public TetrisView(TetrisController c) {
		this.controller = c;
	}

	public void initWindow() {
		this.setTitle("Tetris");
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(this);
	}

	public void stateHasChanged(TetrisModel m, GameState state) {
		this.model = m;
		this.state = state;
		if (state != null) {
			switch (state) {
			case ViewStartup:
				StartupPanel StartupPanel = new StartupPanel();
				StartupPanel.enterButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.userHasInput(Command.EnterGame);
					}
				});
				this.changeView(StartupPanel);
				break;
			case Idle:
				GamePanel GamePanel = new GamePanel();
				GamePanel.startButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("start");
						controller.userHasInput(Command.StartGame);
						requestFocus();
					}
				});
				GamePanel.pauseButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("pause");
						controller.userHasInput(Command.PauseGame);
						requestFocus();
					}
				});
				GamePanel.stopButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("pause");
						controller.userHasInput(Command.StopGame);
						requestFocus();
					}
				});
				this.changeView(GamePanel);
				GamePanel.gameArea.setArr(m.getArr());
				GamePanel.nowScore.setText("ヘ玡だ计:" + model.getScore("normal"));
				GamePanel.maxScore.setText("程蔼だ计:" + model.getScore("max"));
				break;
			case Playing:
				GamePanel P1 = (GamePanel) this.panel;
				P1.startButton.setEnabled(false);
				P1.pauseButton.setEnabled(true);
				P1.stopButton.setEnabled(true);
				break;
			case Paused:
				GamePanel P2 = (GamePanel) this.panel;
				P2.startButton.setEnabled(true);
				P2.pauseButton.setEnabled(false);
				P2.stopButton.setEnabled(true);
				break;
			case Stop:
				GamePanel P3 = (GamePanel) this.panel;
				P3.startButton.setEnabled(true);
				P3.pauseButton.setEnabled(false);
				P3.stopButton.setEnabled(false);
				break;
			case Gameover:
                JOptionPane.showMessageDialog(null, "笴栏挡");            
				break;
			}
		}
	}

	public void updateView() {
		GamePanel GamePanel = (GamePanel) this.panel;
		GamePanel.gameArea.setArr(model.getArr());
		GamePanel.nowScore.setText("ヘ玡だ计:" + model.getScore("normal"));
		GamePanel.maxScore.setText("程蔼だ计:" + model.getScore("max"));
	}

	private void changeView(JPanel view) {
		this.panel = view;
		this.getContentPane().removeAll();
		this.getContentPane().add(view, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		controller.keyboardInput(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
