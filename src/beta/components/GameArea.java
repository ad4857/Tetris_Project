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
		}
	}
}
