package alpha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TetrisView extends JFrame implements KeyListener{
	private TetrisController controller;
	private TetrisModel model;

	public TetrisView(TetrisController c) {
		this.controller = c;
	}

	public void initWindow() {
		this.setTitle("Tetris");
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(Color.green);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.controller.getView("startup");
	}

	public void changeView(JPanel view) {
		this.getContentPane().removeAll();
		this.getContentPane().add(view, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public void getInput() {
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
