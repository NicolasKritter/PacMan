import edu.princeton.cs.introcs.StdDraw;

public class Component {
	int x;
	int y;
	int width;
	int height;
	String text;
	boolean hoovered;
	
	
	public Component(int x0,int y0, int w, int h, String t){
		x = x0;
		y = y0;
		width = w;
		height = h;
		text = t;
		
		
	}
	public void dessiner(){
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(x, y, width, height);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.rectangle(x, y, width, height);
		StdDraw.text(x, y, text);
		hoovered = false;
		StdDraw.show();
	}
	

}