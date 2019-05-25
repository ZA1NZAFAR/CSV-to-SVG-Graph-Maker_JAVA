import java.util.ArrayList;


public class LineGraph extends Graph {
    public LineGraph(int w, int h, int nbLin, int nbCol) {
        super(w, h);
    }

    public void ajouterPoint(Circle c) {
        this.str += c.toString();
    }

    public void ajouterLines(Circle[][] a, ArrayList<String> b) {
        try {
            for (int i = 1; i < a[0].length; i++) {
                for (int j = 1; j < a.length - 1; j++) {

                    this.str += new Line(a[j][i].getCx(), a[j][i].getCy(), a[j + 1][i].getCx(),
                            a[j + 1][i].getCy(), b.get(i - 1)).toString();

                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

    }
}
