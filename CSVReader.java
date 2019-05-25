import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public int nbLi, nbCol, height;
    public String[][] astr;
    String path,nomFich;
	private Scanner sknr;
	ArrayList<String> arColor = new ArrayList<String>();

    public CSVReader(String path) throws IOException {
        this.path = path;
        Scanner sknr = new Scanner(new File(path));
        String temp = sknr.nextLine();
        int x = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == ',') {
                x++;
            }
        }
        int y = 0;
        try {
            while (sknr.nextLine() != null) {
                y++;
            }
        } catch (Exception e) {
        }
        sknr.close();
        this.nbCol = x + 1;
        this.nbLi = y + 1;
        this.astr = new String[nbLi][nbCol];
        this.getData();
        this.height = this.maxVal() + 100;
        this.addColordArrayLst();
    }


    public String[][] getData() throws FileNotFoundException {
        sknr = new Scanner(new File(this.path));
        int ind = 0;
        String tempL;
        try {
            while ((tempL = sknr.nextLine()) != null) {
                String[] tempAr = tempL.split(",");
                if (tempAr.length != this.nbCol) {
                    throw new Error("Data not correctly formatted!");
                }
                this.astr[ind] = tempAr;
                ind++;
            }

        } catch (Exception e) {
        }
        sknr.close();
        return this.astr;
    }


    public int maxVal() {
        int max = Integer.parseInt(this.astr[1][1]);
        for (int i = 1; i < this.nbLi; i++) {
            for (int j = 1; j < this.nbCol; j++) {
                max = Math.max(max, Integer.parseInt(this.astr[i][j]));
            }
        }
        return max;
    }

    public void createBarGraph(String s) throws IOException {
        while (height % 5 != 0) {height = height + 1;}
        this.height = height + 100;
        BarGraph og = new BarGraph(0, (this.height));
        
        og.addSpace(20);
        for (int i = 1; i < this.nbLi; i++) {
            for (int j = 1; j < this.nbCol; j++) {
                String optionalName = this.astr[i][0];
                og.ajouterBar(Integer.parseInt(this.astr[i][j]), arColor.get(j - 1), nbCol, j, optionalName);
                og.addSpace(20);
            }
            og.addSpace(30);
        }
        og.setW(og.getMaxWidth());
        og.initGraph();
        og.prepareGround();
        og.addID(this.astr, arColor);
        og.terminGraph();
        og.createFile(s);
    }


    public void createLineGraph(String s) throws IOException {
        while (height % 5 != 0) {height = height + 1;}
        LineGraph og = new LineGraph((this.nbLi * this.nbCol * 10), (this.height), this.nbLi, this.nbCol);
               
        int tt = ((this.nbLi * this.nbCol * 10) / (this.nbLi * this.nbCol))+10;
        Circle[][] points = new Circle[this.nbLi][this.nbCol];
        for (int i = 1; i < this.nbLi; i++) {
        	og.ajouterText(this.astr[i][0], tt - 6, this.height - 40, 5);
            for (int j = 1; j < this.nbCol; j++) {
                points[i][j] = new Circle(tt, (this.height - 50) - Integer.parseInt(this.astr[i][j]), 1, "black");
                og.ajouterPoint(points[i][j]);
            }
            tt += (this.nbLi * this.nbCol * 20) / (this.nbLi * this.nbCol);
        }
        og.setW(tt);
        og.initGraph();
        og.prepareGround(); 
        og.ajouterLines(points, arColor);
        og.addID(this.astr, arColor);
        og.terminGraph();
        og.createFile(s);
    }
    
    public void addColordArrayLst() {
    	for (int i = 1; i < this.nbCol; i++) {
            this.arColor.add(Tools.getRandomRGB());
        }
    }


}
