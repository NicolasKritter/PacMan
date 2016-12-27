
public class Perso {
	double x;
	double y;
	//direction
	int dir;
	
	String name;
	
	public Perso (int x0, int y0,int dir0, String nom){
		x = x0;
		y = y0;
		name = nom;
		dir = dir0;
	}
	// 0: bas 1: haut 2: gauche 3: droite
	 public static void move (Perso perso){
		 switch(perso.dir){
		 case 0:
			 perso.y = perso.y-Main.STEP;
			 break;
		 case 1:
			 perso.y = perso.y+Main.STEP;
			 break;
		 case 2:
			 perso.x = perso.x-Main.STEP;
			 break;
		 case 3:
			 perso.x = perso.x+Main.STEP;
			 break;
		default:
			break;
		 }
	 }

}

