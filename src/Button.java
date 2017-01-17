import edu.princeton.cs.introcs.StdDraw;

public class Button {
	int x;
	int y;
	int width;
	int height;
	String text;
	boolean hoovered;
	
	
	public Button(int x0,int y0, int w, int h, String t){
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
	public void hooverDraw(){
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		 //TODO décalage pour rendre plus "joli" ?
		hoovered = true;
		StdDraw.rectangle(x, y, width-6, height-4);
		StdDraw.text(x, y, text);
		StdDraw.show();
		
	}
	public boolean hoover(){
		 if(StdDraw.mouseX()>x-width && StdDraw.mouseX()<x+width && StdDraw.mouseY()>y-height && StdDraw.mouseY() <y+height){
 		
			 hooverDraw();
			 return true;
		 }else if(hoovered){
			 dessiner();
		 }
		 return false;
	}

}
