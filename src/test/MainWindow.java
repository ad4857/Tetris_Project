package test;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	public MainWindow() {
		
	}
	public void initWindow() {
		this.setTitle("Tetris");
		this.setSize(800,600);
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(Color.green);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}