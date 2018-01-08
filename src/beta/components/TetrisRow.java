package beta.components;

import java.awt.Color;

public class TetrisRow {
	public TetrisRow(Color[] cols) {
		this.content=cols.clone();
	}
	public Color[] content;
}
