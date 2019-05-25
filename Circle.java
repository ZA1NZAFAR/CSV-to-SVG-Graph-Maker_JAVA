public class Circle extends UsableObjects {
	int cx, cy, r;

	public Circle(int cx, int cy, int r, String color) {
		super(color);
		this.cx = cx;
		this.cy = cy;
		this.r = r;
	}

	public int getCx() {
		return cx;
	}

	public int getCy() {
		return cy;
	}

	@Override
	public String toString() {
		return " <circle  cx = \" " + this.cx + "\"  cy = \" " + this.cy + " \"  r = \" " + this.r + " \"  fill = \" "
				+ this.color + " \"  /> \n";
	}
}
