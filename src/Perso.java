
public class Perso {
	double x;
	double y;
	//direction
	int dir;
	int buffer;
	String name;
	double taille;
	public Perso (int x0, int y0,int dir0, String nom){
		x = x0;
		y = y0;
		name = nom;
		dir = dir0;
		buffer = dir0;
		taille = Main.taille;
	}
	// 0: bas 1: haut 2: gauche 3: droite
	 public static void move (Perso perso){
		//Efface le précédent
		 
		 
		 
		 switch(perso.dir){
		 case 0:
			 Main.effaceur(perso.x, perso.y, perso.taille);
			 perso.y = perso.y-Main.STEP;
			
			 break;
		 case 1:
			 Main.effaceur(perso.x, perso.y, Main.taille);
			 perso.y = perso.y+Main.STEP;
			 
			 break;
		 case 2:
			 Main.effaceur(perso.x, perso.y, Main.taille);
			 perso.x = perso.x-Main.STEP;
			
			 break;
		 case 3:
			 Main.effaceur(perso.x,perso.y, Main.taille);
			 perso.x = perso.x+Main.STEP; 
			 break;
		default:
			break;
		 }
		 
	 }

	 public boolean checkhitwall(Map map){
		 int x = (int)(this.x);
		 int y = (int)(this.y);
		 int taille = (int)(this.taille);
		
			 
		 
		//TODO Ne pas prendre en compte la taille de la hitbox
				 switch(this.dir){
				 case 0:
					 if (map.coord[x][y-taille]==2 || map.coord[x-taille][y-taille]==2 || map.coord[x+taille][y-taille]==2){
						 this.y = this.y+Main.STEP;
						
						 return true;
					 }
					 break;
				 case 1:
					 if (map.coord[x][y+taille]==2 || map.coord[x-taille][y+taille]==2 || map.coord[x+taille][y+taille]==2){
						 this.y = this.y-Main.STEP;
						 return true;
					 }
					 break;
				 case 2:
					 if (map.coord[x-taille][y]==2 || map.coord[x-taille][y+taille]==2 || map.coord[x-taille][y-taille]==2){
						 this.x = this.x+Main.STEP;
						 return true;
					 }
					 break;
				 case 3:
					 if (map.coord[x+taille][y]==2 || map.coord[x+taille][y+taille]==2 || map.coord[x+taille][y-taille]==2){
						 this.x = this.x-Main.STEP;
						 return true;
					 }
					 break;
				 } 
				 return false;
			 //TODO expliquer méthode des cases
			//TODO optimiser méthode de shannon
	}

	/* 
	 public boolean checkhitwall(Map map, int direc){
		 int x = (int)(this.x+Main.STEP);
		 int y = (int)(this.y+Main.STEP);
		 int taille = (int)(this.taille);
		
			 
		 
		//TODO Ne pas prendre en compte la taille de la hitbox
				 switch(direc){
				 case 0:
					 if (map.coord[x][y-taille]==2 ){//|| map.coord[x-taille][y-taille]==2 || map.coord[x+taille][y-taille]==2){
						 
						 return true;
					 }
					 break;
				 case 1:
					 if (map.coord[x][y+taille]==2){// || map.coord[x-taille][y+taille]==2 || map.coord[x+taille][y+taille]==2){
						
						 return true;
					 }
					 break;
				 case 2:
					 if (map.coord[x-taille][y]==2 ){//|| map.coord[x-taille][y+taille]==2 || map.coord[x-taille][y-taille]==2){
						 
						 return true;
					 }
					 break;
				 case 3:
					 if (map.coord[x+taille][y]==2 ){//|| map.coord[x+taille][y+taille]==2 || map.coord[x+taille][y-taille]==2){
						
						 return true;
					 }
					 break;
				 } 
				 return false;
			 //TODO expliquer méthode des cases
			//TODO optimiser méthode de shannon
	}*/
	public boolean checkhitwall(Map map, int direc){
		 int x = (int)(this.x+Main.STEP);
		 int y = (int)(this.y+Main.STEP);
		 int taille = (int)(2*this.taille-1);
		
			 
		 
		//TODO Ne pas prendre en compte la taille de la hitbox
				 switch(direc){
				 case 0:
					 if (map.coord[x-taille][y-taille]==2 && map.coord[x+taille][y-taille]==2){//|| map.coord[x-taille][y-taille]==2 || map.coord[x+taille][y-taille]==2){
						 
						 return true;
					 }
					 break;
				 case 1:
					 if (map.coord[x-taille][y+taille]==2 && map.coord[x+taille][y+taille]==2){// || map.coord[x-taille][y+taille]==2 || map.coord[x+taille][y+taille]==2){
						
						 return true;
					 }
					 break;
				 case 2:
					 if (map.coord[x-taille][y+taille]==2 && map.coord[x-taille][y-taille]==2){//|| map.coord[x-taille][y+taille]==2 || map.coord[x-taille][y-taille]==2){
						 
						 return true;
					 }
					 break;
				 case 3:
					 if (map.coord[x+taille][y+taille]==2 && map.coord[x+taille][y-taille]==2 ){//|| map.coord[x+taille][y+taille]==2 || map.coord[x+taille][y-taille]==2){
						
						 return true;
					 }
					 break;
				 } 
				 return false;
			 //TODO expliquer méthode des cases
			//TODO optimiser méthode de shannon
	}
	 
	 
	 
}

