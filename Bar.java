public class Bar extends UsableObjects{
    public static int distanceFromLast = 10;
    public int w, h, graphH, posT;
    public String optionalText;

    public Bar(int h, int gh, String color, int pos, String optionalTe) {
        super(color);
    	this.w = 15;
        this.h = h;
        this.graphH = gh;
        this.posT = pos;
        this.optionalText = optionalTe;
    }

    public static void addSpace(int s) {
        distanceFromLast += s;
    }

    public static int getDistanceFromLast() {
		return distanceFromLast;
	}

	@Override
    public String toString() {
        if (this.posT == 1) {
            return "<rect  width = \"" + this.w + "\"  height = \"" + this.h + "\"  x = \"" + (distanceFromLast) + "\"  y = \"" + (this.graphH - h - 50) + "\"  fill = \"" + color + "\"  /> \n" +
                    new Text(this.optionalText, distanceFromLast, this.graphH - 35, 15).toString();
        }
        return "<rect  width = \"" + this.w + "\"  height = \"" + this.h + "\"  x = \"" + (distanceFromLast) + "\"  y = \"" + (this.graphH - h - 50) + "\"  fill = \"" + color + "\"  /> \n";
    }
}
