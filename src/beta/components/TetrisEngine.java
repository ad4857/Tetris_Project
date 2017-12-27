package beta.components;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TetrisEngine {
	public Color[][] SquareArr;
	public int row, col;
	public List<TetrisBlock> blocks;
	public TetrisBlock fallBlock;
	public int score = 0;

	public TetrisEngine(int rows, int cols) {
		row = rows;
		col = cols;
		SquareArr = new Color[row][col];
		blocks = new ArrayList<TetrisBlock>();
	}

	public boolean updateArr() {
		if (fallBlock != null) {
			List<Point> points = fallBlock.getPoints();
			for (int i = 0; i < points.size(); i++) {
				int row = points.get(i).y;
				int col = points.get(i).x;
				SquareArr[row][col] = null;
			}
			fallBlock.top++;
			if (!checkCollision()) {
				points = fallBlock.getPoints();
				for (int i = 0; i < points.size(); i++) {
					int r = points.get(i).y;
					int c = points.get(i).x;
					SquareArr[r][c] = fallBlock.color;
				}
			} else {
				fallBlock.top--;

				points = fallBlock.getPoints();
				for (int i = 0; i < points.size(); i++) {
					int r = points.get(i).y;
					int c = points.get(i).x;
					SquareArr[r][c] = fallBlock.color;
				}
				blocks.add(fallBlock);
				fallBlock = null;
			}
		} else {
			Random rand = new Random();
			int r = rand.nextInt(255);
			int g = rand.nextInt(255);
			int b = rand.nextInt(255);
			Color color = new Color(r, g, b);
			char c = randomShape();
			System.out.println(c);
			fallBlock = new TetrisBlock(c, color);
			fallBlock.left = (col - fallBlock.BlockArr.length) / 2;
			if (checkCollision()) {
				return true;
			}
		}
		return false;
	}

	private char randomShape() {
		Random rand = new Random();
		int n = rand.nextInt(7);
		switch (n) {
		case 0:
			return 'I';
		case 1:
			return 'L';
		case 2:
			return 'J';
		case 3:
			return 'S';
		case 4:
			return 'Z';
		case 5:
			return 'O';
		case 6:
			return 'T';
		}
		return 'T';
	}

	private boolean checkCollision() {
		List<Point> points = fallBlock.getPoints();
		for (int i = 0; i < points.size(); i++) {
			int row = points.get(i).y;
			int col = points.get(i).x;
			if (row >= SquareArr.length || col >= SquareArr[0].length || col < 0) {
				return true;
			}
			if (SquareArr[points.get(i).y][points.get(i).x] != null) {
				return true;
			}
		}
		return false;
	}

	private int checkClear() {
		for (int i = row - 1; i >= 0; i--) {
			boolean flag = true;
			while (flag && i >= 0) {
				for (int j = 0; j < col; j++) {
					if (SquareArr[i][j] == null) {
						flag = false;
						break;
					}
				}
			}

			if (flag) {

			}
		}
	}

	public void move(int d) {
		switch (d) {
		case -1:// put
			break;
		case 0:// rotate
			break;
		case 1:// left
			fallBlock.left--;
			break;
		case 2:// right
			fallBlock.left++;
			break;
		case 3:// down
			fallBlock.top++;
			break;
		}
	}
}
