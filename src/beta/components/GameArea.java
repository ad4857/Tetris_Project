package beta.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import beta.TetrisView;

public class GameArea extends JPanel {
	private Color[][] SquareArr;
	public Timer timer;
	public boolean isCollision = false;
	public TetrisBlock nowDowning;
	public TetrisBlock bottom;

	public GameArea() {
		init();
		setTimer();
	}

	public void setTimer() {
		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color[][] arr = new Color[20][12];
				Random rand = new Random();
				int r = rand.nextInt(20);
				int c = rand.nextInt(12);
				arr[r][c] = Color.RED;
				setArr(arr);
			}
		});
		timer.setRepeats(true);
	}

	public void init() {
		setArr(new Color[20][12]);
		isCollision = false;
	}

	public void start() {
		timer.start();
	}

	public void resume() {
		timer.start();
	}

	public void pause() {
		timer.stop();
	}

	public void stop() {
		timer.stop();

	}

	public void setArr(Color[][] arr) {
		this.SquareArr = arr;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (SquareArr != null) {
			Graphics2D g2 = (Graphics2D) g;
			double h = this.getHeight() / (double) this.SquareArr.length;
			double w = this.getWidth() / (double) this.SquareArr[0].length;
			for (int i = 0; i < this.SquareArr.length; i++) {
				for (int j = 0; j < this.SquareArr[0].length; j++) {
					Shape s = new Rectangle2D.Double(j * w, i * h, w, h);
					if (this.SquareArr[i][j] != null) {
						g2.setColor(this.SquareArr[i][j]);
						g2.fill(s);

					}
					g2.setColor(Color.BLACK);
					g2.draw(s);
				}
			}
			System.out.println(this.getWidth() + "," + this.getHeight() + ":" + w + "," + h);
		}
	}
}
