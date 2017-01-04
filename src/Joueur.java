
public class Joueur extends Perso{
	int score;
	int vie;
	public Joueur(int x0, int y0, int dir0, String nom) {
		super(x0, y0, dir0, nom);
		score = 0;
		vie = 3;
		
	}
	
	 public void checkhitwall(Map map){
		 int x = (int)(this.x);
		 int y = (int)(this.y);
		 int taille = (int)(Main.taille);
		
			 
		 
		//TODO Ne pas prendre en compte la direction
				 switch(this.dir){
				 case 0:
					 if (map.coord[x][y-taille]==2){
						 this.y = this.y+Main.STEP;
						 this.dir =-1;
					 }
					 break;
				 case 1:
					 if (map.coord[x][y+taille]==2){
						 this.y = this.y-Main.STEP;
						 this.dir =-1;
					 }
					 break;
				 case 2:
					 if (map.coord[x-taille][y]==2){
						 this.x = this.x+Main.STEP;
						 this.dir =-1;
					 }
					 break;
				 case 3:
					 if (map.coord[x+taille][y]==2){
						 this.x = this.x-Main.STEP;
						 this.dir =-1;
					 }
					 break;
				 } 
			 
	}
	 
	 public void checkhitcookie(Map map){
		 //TODO trouver le cookie touché et le retirer
		 //TODO etendre la zone de recherche
		 if(map.coord[(int) this.x][(int) this.y]==1){
			 this.score = this.score+2;
			 map.coord[(int) this.x][(int) this.y]=0;
		 }
	 }

}
