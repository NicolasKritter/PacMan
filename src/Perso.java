
public class Perso {
	double x;
	double y;
	//direction
	int dir;
	int score;
	int vie;
	String name;
	
	public Perso (int x0, int y0,int dir0, String nom){
		x = x0;
		y = y0;
		name = nom;
		dir = dir0;
		vie = 3;
	}
	
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

