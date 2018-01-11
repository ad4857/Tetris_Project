package beta.components;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

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
			if (move(3)) {

			} else {
				checkRows();
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
				System.out.println("finish!!");
				fallBlock = null;
				return true;
			} else {
				for (Point p : fallBlock.getPoints()) {
					SquareArr[p.y][p.x] = fallBlock.color;
				}
			}
		}
		return false;
	}

	public boolean move(int d) {
		if (fallBlock != null) {
			for (Point p : fallBlock.getPoints()) {
				SquareArr[p.y][p.x] = null;
			}
			boolean flag = true;
			switch (d) {
			case -1:// put
				while (!checkCollision()) {
					fallBlock.top++;
				}
				fallBlock.top--;
				flag = false;
				break;
			case 0:// rotate
				fallBlock.rotate(true);
				if (checkCollision()) {
					fallBlock.rotate(false);
					flag = false;
				}
				break;
			case 1:// left
				fallBlock.left--;
				if (checkCollision()) {
					fallBlock.left++;
					flag = false;
				}
				break;
			case 2:// right
				fallBlock.left++;
				if (checkCollision()) {
					fallBlock.left--;
					flag = false;
				}
				break;
			case 3:// down
				fallBlock.top++;
				if (checkCollision()) {
					fallBlock.top--;
					flag = false;
				}
				break;
			}
			for (Point p : fallBlock.getPoints()) {
				SquareArr[p.y][p.x] = fallBlock.color;
			}
			return flag;
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
			int r = points.get(i).y;
			int c = points.get(i).x;
			if (r >= row || c >= col || c < 0) {
				return true;
			}
			if (SquareArr[r][c] != null) {
				System.out.println(r + "," + c + ":collision");
				return true;
			}
		}

		return false;
	}

	private void checkRows() {
		Stack<Color[]> cache = new Stack<Color[]>();
		int t = 0;
		for (int i = 0; i < SquareArr.length; i++) {
			boolean escape = false;
			for (Color c : SquareArr[i]) {
				if (c != null) {
					t = i;
					escape = true;
					break;
				}
			}
			if (escape) {
				break;
			}
		}
		//
		int clearRows = 0;
		for (int i = t; i < row; i++) {
			boolean clear = true;
			Color[] rr = new Color[col];
			for (int j = 0; j < col; j++) {
				Color c = SquareArr[i][j];
				if (c == null) {
					clear = false;

				}
				rr[j] = SquareArr[i][j];
				SquareArr[i][j] = null;
			}
			if (!clear) {
				cache.push(rr.clone());
			} else {
				clearRows++;
			}
		}
		//
		for (int i = row - 1; i >= t; i--) {
			if (!cache.empty()) {
				SquareArr[i] = cache.pop().clone();
			}
		}
		score += clearRows * 100;
	}

}
