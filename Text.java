public class Text extends UsableObjects {
	public String text;
	public int posX, posY, fontSize;

	public Text(String text, int posX, int posY, int fontSize) {
		super("Black");
		this.text = text;
		this.posX = posX;
		this.posY = posY;
		this.fontSize = fontSize;
	}

	@Override
	public String toString() {
		return "<text  x = \" " + this.posX + " \"  y = \"" + this.posY + "\" font-size = \"" + this.fontSize
				+ "\" fill = \"" + this.color + "\" > " + this.text + " </text> \n";
	}
}
