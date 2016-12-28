
public class Coockie {
	int x;
	int y;
	boolean visible;
	int taille;
	Coockie suivant;
	public Coockie(int x0, int y0){
		x = x0;
		y = y0;
		visible = true;
		suivant = null;
		taille = Main.taille;
	}
	public static Coockie addCoockie(Coockie coockie,Coockie next) {
		Coockie courant = coockie;
		if (courant.suivant==null){
			courant.suivant = next;
		}
		else{
			addCoockie(courant.suivant,next);
		}
		
		
		return coockie;
	
		
	}
	//TODO mettre le coockie a la fin et le mettre null?
	public static void deleteCoockie(Coockie coockie){
		coockie.visible = false;
	}

}
