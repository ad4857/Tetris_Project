package test;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class StateController {
	private MainWindow view;
	private ViewsEnum nowView = null;

	public StateController(MainWindow window) {
		this.view = window;
		this.view.initWindow();
	}

	public void ChangeView(ViewsEnum type) {
		System.out.println(type);
		if (nowView != null) {
			this.view.getContentPane().removeAll();
		}
		nowView = type;
		if (type == ViewsEnum.initView) {
			initView scene = new initView(this);
			this.view.getContentPane().add(scene, BorderLayout.CENTER);
			this.view.setVisible(true);
		}
		if (type == ViewsEnum.gameView) {
			gameView scene = new gameView(this);
			this.view.getContentPane().add(scene, BorderLayout.CENTER);
			this.view.setVisible(true);
		}
		if (type == ViewsEnum.developerView) {
			developerView scene = new developerView(this);
			this.view.getContentPane().add(scene, BorderLayout.CENTER);
			this.view.setVisible(true);
		}
	}

	public void HasInput(String input) {
		System.out.println(input);
	}
}