public class Ghost extends Perso{

public Ghost(int x0, int y0, int dir0, String nom) {
	super(x0, y0, dir0, nom);
	
}
// teste si un fantôme touche un mur
public void checkhitwall(Map map){
	 int x = (int)(this.x);
	 int y = (int)(this.y);
	 int taille = (int)(Main.taille);
	 int oldir  =this.dir;
	 boolean hit = false;
	 
	 
			 switch(oldir){
			 case 0:
				 if (map.coord[x][y-taille]==2){
					 this.y = this.y+Main.STEP;
					 hit = true;
				 }
				 break;
			 case 1:
				 if (map.coord[x][y+taille]==2){
					 this.y = this.y-Main.STEP;
					 hit = true;
				 }
				 break;
			 case 2:
				 if (map.coord[x-taille][y]==2){
					 this.x = this.x+Main.STEP;
					 hit = true;
				 }
				 break;
			 case 3:
				 if (map.coord[x+taille][y]==2){
					 this.x = this.x-Main.STEP;
					 hit = true;
				 }
				 break;
			 }
			 while (this.dir==oldir && hit==true){
				 this.dir = Main.random.nextInt(4);
			 }
	 }
}
