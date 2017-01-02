
public class Coockie {
	int x;
	int y;
	int taille;
	Coockie suivant;
	public Coockie(int x0, int y0){
		x = x0;
		y = y0;
		suivant = null;
		taille = Main.taille/2;
	}
	public static Coockie addCoockie(Coockie liste ,Coockie next) {
		Coockie courant = liste;
		if (courant.suivant==null){
			courant.suivant = next;
		}
		else{
			addCoockie(courant.suivant,next);
		}
		
		
		return liste;
	
		
	}
	//TODO mettre le coockie a la fin et le mettre null?
	public static Coockie deleteCoockie(Coockie coockie,Coockie liste){
		Coockie courant  = liste;
		while(courant != coockie){
			courant = courant.suivant;
		}
		courant = courant.suivant;
		coockie = null;
		return liste;
	}

}
