import edu.princeton.cs.introcs.StdDraw;

public class Button extends Component{
	public Button (int x0,int y0, int w, int h, String t){
		super( x0, y0,  w,  h,  t);
		
		
	}

	//changement visuel qui montre que la souris est sur le bouton
	public void hooverDraw(){
		StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		hoovered = true;
		StdDraw.rectangle(x, y, width-6, height-4);
		StdDraw.text(x, y, text);
		StdDraw.show();
		
	}
	//check si la souris est dessus
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
