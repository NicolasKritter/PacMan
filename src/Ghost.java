public class Ghost extends Perso{

public Ghost(int x0, int y0, int dir0, String nom) {
	super(x0, y0, dir0, nom);
	
}
// teste si un fantôme touche un mur
public void bounchehitwall(Map map){
	int[] newdir = new int[3];
	 int oldir  =this.dir;
	 switch(oldir){
	 case 0:
		newdir = new int[]{1,2,3};
		 break;
	 case 1:
		 newdir = new int[]{0,2,3};
		 break;
	 case 2:
		 newdir = new int[]{1,0,3};
		 break;
 	case 3:
 		newdir = new int[]{1,0,2};
	 break;
	 
	 }
	this.dir = newdir[Main.random.nextInt(2)];
	this.buffer = this.dir;
	 }
}
