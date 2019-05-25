import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
	public int w, h;
	String str;

	public Graph(int w, int h) {
		this.w = w;
		this.h = h;
		this.str = "";
	}

	public void initGraph() {
		this.str = "<?xml version = \"1.0\" encoding = \"utf-8\"?> \n"
				+ "<svg  xmlns = \"http://www.w3.org/2000/svg\"  version = \"1.1\"  width = \"" + this.w
				+ "\"  height = \"" + this.h + "\" > \n" + "  <title> Exemple titre </title> \n" + "  <desc>\n"
				+ "    Exemple desc\n" + "  </desc> \n" + this.str;
		this.ajouterLi(5, this.h - 50, this.w, this.h - 50, "black");
		this.ajouterLi(5, this.h - 50, 5, 5, "black");
	}

	public void prepareGround() {
		int d = this.h - 50;
		for (int i = 1; i <= 10; i++) {
			d -= ((this.h - 55) / 10);
			while (d % 5 != 0) {
				d = d + 1;
			}
			if (d < this.h - 55) {
				this.ajouterLi(5, d, this.w, d, "grey");
				this.ajouterText("" + (((this.h - 50)) - d), 5, d, 10);
			}

		}

	}

	private void ajouterLi(int x1, int y1, int x2, int y2, String clr) {
		this.str += new Line(x1, y1, x2, y2, clr).toString();
	}

	public void ajouterText(String text, int x, int y, int size) {
		this.str += new Text(text, x, y, size).toString();
	}

	public void terminGraph() {
		this.str += "</svg>";
	}

	public void createFile(String s) throws IOException {
		FileWriter fw = new FileWriter(s + ".svg");
		fw.write(str);
		fw.flush();
		fw.close();
	}

	public void addID(String[][] a, ArrayList<String> b) {
		int initCX = (this.w / (4 * b.size()));
		int initCY = 20;
		for (int i = 0; i < b.size(); i++) {
			this.str += new Circle(initCX, initCY + 5, 6, b.get(i)).toString();
			this.str += new Text(a[0][i + 1], initCX + 8, initCY + 10, 15);
			initCX += (this.w / (3 * b.size()));

		}

	}

	public void setW(int w) {
		this.w = w;
	}

	public void setH(int h) {
		this.h = h;
	}

}
