package alpha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TetrisView extends JFrame {
	private TetrisController controller;
	private TetrisModel model;
	private JPanel panel;

	public TetrisView(TetrisController c) {
		this.controller = c;
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Typed:" + e.getKeyCode());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Pressed:" + e.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Released:" + e.getKeyCode());
			}
		});
		setFocusable(true);
		requestFocusInWindow();
	}

	public void initWindow() {
		this.setTitle("Tetris");
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void changeScene(SceneRoute scene) {
		this.controller.getView(scene);
	}

	public void changeView(JPanel view) {
		this.panel = view;
		this.getContentPane().removeAll();
		this.getContentPane().add(view, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void changeState(GameState state) {
		if (this.controller.getScene() == SceneRoute.Game) {
			GamePanel game = (GamePanel) this.panel;
			game.updateState(state);
		}
	}
}
