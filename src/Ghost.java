public class Ghost extends Perso{

public Ghost(int x0, int y0, int dir0, String nom) {
	super(x0, y0, dir0, nom);
	
}
// teste si un fantôme touche un mur
public void bounchehitwall(Map map){

	 int oldir  =this.dir;
	 switch(oldir){
	 case 0:
		 
		 break;
	 case 1:
		 
		 break;
	 case 2:
		 
		 break;
 	case 3:
	 
	 break;
	 
	 }
	
			 
			 while (this.dir==oldir && checkhitwall(map)){
				 this.dir = Main.random.nextInt(4);
				 
			 }
	 }
}
