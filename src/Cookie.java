
public class Cookie {
	double x;
	double y;

	int taille;
	Cookie suivant;
	int tabx;
	int taby;
	String visible;
	public Cookie(int x0, int y0, int tx, int ty){
		x = x0;
		y = y0;
		tabx = tx;
		taby = ty;
		taille = Main.taille/2;

	}
	public static Cookie addCookie(Cookie liste ,Cookie next) {

		Cookie courant = liste;
		if(courant==null){
			courant = next;
			return courant;
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

	//TODO mettre le Cookie a la fin et le mettre null?


}
