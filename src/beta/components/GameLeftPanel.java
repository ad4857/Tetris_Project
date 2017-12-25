package beta.components;

import beta.*;
import beta.enums.*;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class GameLeftPanel extends Canvas {
	private TetrisView view;
	private Color[][] SquareArr;

	public GameLeftPanel(TetrisView v) {
		this.view = v;
		// this.setArr(new Color[24][16]);
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
		this.setFocusable(true);
	}

	public void setArr(Color[][] arr) {
		this.SquareArr = arr;
		System.out.println("set");
		this.repaint();
	}

	public void paint(Graphics g) {
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
