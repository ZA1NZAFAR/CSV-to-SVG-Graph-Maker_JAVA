public class BarGraph extends Graph {
    public BarGraph(int w, int h) {
        super(w, h);
    }

    public void ajouterBar(int height, String color, int numColTot, int numVal, String lineName) {
    	int centre = (int) numColTot/2;
    	if(centre == numVal) {numVal=1;}else {numVal=0;}
        this.str += new Bar(height, this.h, color, numVal, lineName).toString();

    }
    
    
    public int getMaxWidth() {
    	return Bar.getDistanceFromLast();
    }
    public void addSpace(int s) {
        Bar.addSpace(s);
    }


}
