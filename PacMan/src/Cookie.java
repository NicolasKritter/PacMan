import edu.princeton.cs.introcs.StdDraw;

public class Cookie {
	double x;
	double y;
	boolean bonus;
	int taille;
	Cookie suivant;
	int tabx;
	int taby;
	public Cookie(int x0, int y0, int tx, int ty){
		x = x0;
		y = y0;
		tabx = tx;
		taby = ty;
		taille = Main.taille*2;
		bonus = false;

	}
	public static Cookie addCookie(Cookie liste ,Cookie next) {

		Cookie courant = liste;
		if(courant==null){
			liste = next;
			
		}
		else if (courant.suivant==null){
			
			courant.suivant = next;
		}
		else{
			addCookie(courant.suivant,next);
		}
		
		
		return liste;
	
		
	}
	//TODO a faire en réccursif ?

	public void effacer(){
		StdDraw.setPenColor(StdDraw.BLACK);
    	StdDraw.filledSquare(x,y,taille);
	}


}
