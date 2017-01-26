
public class Mur {
	int x;
	int y;
	int large;
	int longe;
	Mur suivant;
	public Mur(int x0,int y0,int la,int lo){
		 x= x0;
		 y = y0;
		 large = la-1;
		 longe = lo-1;
		 suivant = null;
	}

	public static Mur addMur(Mur liste ,Mur next) {

		Mur courant = liste;
		if(courant==null){
			liste  = next;
			
			
		}
		else if (courant.suivant==null){
			
			courant.suivant = next;
		}
		else{
			addMur(courant.suivant,next);
		}
		

		return liste;
	
		
	}

	/*public static Mur addMur(Mur mur,Mur next) {
		Mur courant = mur;
		if (mur==null){
			mur  = next;
			return mur;
		}
		if (courant.suivant==null){
			courant.suivant = next;
		}
		else{
			addMur(courant.suivant,next);
		}
		
		
		return mur;
	
		
	}*/
	
}