package beta;
import beta.enums.*;
import beta.components.*;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TetrisView extends JFrame {
	private TetrisController controller;
	private TetrisModel model;
	private JPanel panel;

	public TetrisView(TetrisController c) {
		this.controller = c;
	}

	public void hasInput() {
		
	}
	
	public void initWindow() {
		this.setTitle("Tetris");
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.requestFocus();
	}

	public void changeScene(SceneRoute scene) {
		this.controller.getView(scene);
	}

	public void changeView(JPanel view) {
		this.panel = view;
		this.getContentPane().removeAll();
		this.getContentPane().add(view, BorderLayout.CENTER);
		this.setVisible(true);
		this.panel.setFocusable(true);
		this.panel.requestFocus();
	}
}
