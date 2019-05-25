public class Line extends UsableObjects{
    public int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2, String clr) {
    	super(clr);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }






    @Override
    public String toString() {
        return "<line  x1 = \"" + this.x1 + "\"  y1 = \"" + this.y1 + "\"  x2 = \"" + this.x2 + "\"  y2 = \"" + this.y2 + " \"  stroke = \" " + this.color + " \" /> \n";
    }
}
