package alpha;

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

import javax.swing.JPanel;
import javax.swing.JLabel;

public class GameLeftPanel extends Canvas {
	private TetrisView view;
	private Color[][] SquareArr;

	public GameLeftPanel(TetrisView v) {
		this.view = v;
		this.setArr(new Color[24][16]);
	}

	public void setArr(Color[][] arr) {
		this.SquareArr = arr;
		this.SquareArr[1][5] = Color.RED;
		this.SquareArr[4][7] = Color.RED;
		this.validate();
	}

	public void paint(Graphics g) {
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
		// for (int i = 1; i < this.SquareArr.length; i++) {
		// Shape l = new Line2D.Double(0, h * i, this.SquareArr[0].length * w, h * i);
		// g2.draw(l);
		// }
		// for (int j = 1; j < this.SquareArr[0].length; j++) {
		// Shape l = new Line2D.Double(w * j, 0, w * j, this.SquareArr.length * h);
		// g2.draw(l);
		// }

		System.out.println(this.getWidth() + "," + this.getHeight() + ":" + w + "," + h);
	}
}
