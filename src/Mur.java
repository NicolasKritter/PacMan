
public class Mur {
	int x;
	int y;
	int large;
	int longe;
	Mur suivant;
	public Mur(int x0,int y0,int la,int lo){
		 x= x0;
		 y = y0;
		 large = la;
		 longe = lo;
		 suivant = null;
	}

	

	public static Mur addMur(Mur mur,Mur next) {
		Mur courant = mur;
		if (courant.suivant==null){
			courant.suivant = next;
		}
		else{
			addMur(courant.suivant,next);
		}
		
		
		return mur;
	
		
	}
	
}