package beta.components;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class TetrisBlock {
	public Color[][] BlockArr;
	public int RotateCount = 0;
	public Color color;
	public TetrisEngine engine;
	public int left = 0, top = 0;

	public TetrisBlock(char type, Color c) {
		setColor(c);
		setArr(type);
	}

	public TetrisBlock(char type, Color c, int rotate) {
		setColor(c);
		setArr(type);
		setRotate(rotate);
	}

	public List<Point> getPoints() {
		List<Point> points = new ArrayList<Point>();
		for (int i = 0; i < BlockArr.length; i++) {
			for (int j = 0; j < BlockArr.length; j++) {
				if (BlockArr[i][j] != null) {
					points.add(new Point(j + left, i + top));
				}
			}
		}
		return points;

	}

	public void setColor(Color c) {
		color = c;
	}

	public void setArr(char type) {
		switch (type) {
		case 'I':
			BlockArr = new Color[4][4];
			BlockArr[1][0] = color;
			BlockArr[1][1] = color;
			BlockArr[1][2] = color;
			BlockArr[1][3] = color;
			break;
		case 'L':
			BlockArr = new Color[3][3];
			BlockArr[1][0] = color;
			BlockArr[1][1] = color;
			BlockArr[1][2] = color;
			BlockArr[2][0] = color;
			break;
		case 'J':
			BlockArr = new Color[3][3];
			BlockArr[0][0] = color;
			BlockArr[1][0] = color;
			BlockArr[1][1] = color;
			BlockArr[1][2] = color;
			break;
		case 'O':
			BlockArr = new Color[2][2];
			BlockArr[0][0] = color;
			BlockArr[0][1] = color;
			BlockArr[1][0] = color;
			BlockArr[1][1] = color;
			break;
		case 'S':
			BlockArr = new Color[3][3];
			BlockArr[0][1] = color;
			BlockArr[0][2] = color;
			BlockArr[1][0] = color;
			BlockArr[1][1] = color;
			break;
		case 'Z':
			BlockArr = new Color[3][3];
			BlockArr[0][0] = color;
			BlockArr[0][1] = color;
			BlockArr[1][1] = color;
			BlockArr[1][2] = color;
			break;
		case 'T':
			BlockArr = new Color[4][4];
			BlockArr[0][1] = color;
			BlockArr[1][0] = color;
			BlockArr[1][1] = color;
			BlockArr[1][2] = color;
			break;
		}
	}

	public void setRotate(int n) {
		for (int i = 0; i < n % 4; i++) {
			rotate(true);
		}
	}

	// true:¶¶®É°w,false:°f®É°w
	public void rotate(boolean direction) {
		Color[][] tmp = new Color[BlockArr.length][BlockArr.length];
		if (!direction) {
			for (int i = 0; i < BlockArr.length; i++) {
				for (int j = 0; j < BlockArr.length; j++) {
					tmp[i][j] = BlockArr[j][BlockArr.length - 1 - i];
				}
			}
		} else {
			for (int i = 0; i < BlockArr.length; i++) {
				for (int j = 0; j < BlockArr.length; j++) {
					tmp[i][j] = BlockArr[BlockArr.length - 1 - j][i];
				}
			}
		}
		print();
		System.out.println("______________");
		BlockArr = tmp;
	}

	public void print() {
		for (int i = 0; i < BlockArr.length; i++) {
			String str = "";
			for (int j = 0; j < BlockArr.length; j++) {
				if (BlockArr[i][j] != null) {
					str += "1 ";
				} else {
					str += "0 ";
				}

			}
			System.out.println(str);
		}
	}

}
