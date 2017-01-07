
public class Cookie {
	int x;
	int y;
	int taille;
	Cookie suivant;
	public Cookie(int x0, int y0){
		x = x0;
		y = y0;
		suivant = null;
		taille = Main.taille/2;
	}
	public static Cookie addCookie(Cookie liste ,Cookie next) {
		Cookie courant = liste;
		if (courant.suivant==null){
			courant.suivant = next;
		}
		else{
			addCookie(courant.suivant,next);
		}
		
		
		return liste;
	
		
	}
	//TODO mettre le Cookie a la fin et le mettre null?
	public static Cookie deleteCookie(Cookie Cookie,Cookie liste){
		Cookie courant  = liste;
		while(courant != Cookie){
			courant = courant.suivant;
		}
		courant = courant.suivant;
		Cookie = null;
		return liste;
	}

}
