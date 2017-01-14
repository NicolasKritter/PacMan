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
	 public  void move (){
		//Efface le précédent
		 
		 Main.effaceur(this.x, this.y, this.taille);
		 
		 switch(this.dir){
		 case 0:
			 
			 this.y = this.y-Main.STEP;
			
			 break;
		 case 1:
			 
			 this.y = this.y+Main.STEP;
			 
			 break;
		 case 2:
			
			 this.x = this.x-Main.STEP;
			
			 break;
		 case 3:
			
			 this.x = this.x+Main.STEP; 
			 break;
		default:
			break;
		 }
		 
	 }

	 public boolean checkhitwall(Map map){
		 //On passe la coordonnée du personnage en numéro de case du tableau de la carte
		 int x = (int)(Math.round(((this.x/Main.WIN_WIDTH)*map.lar)));
		 int y = (int)(Math.round(((this.y/Main.WIN_WIDTH)*map.lon)));
		 int taille = (int)(Math.round(((this.taille/Main.WIN_WIDTH)*map.lon)));
		
		
		 	//On regarde si le perso touche un mur dans la direction dans laquelle
		 // il se déplace
				 switch(this.dir){
				 case 0:
					 if (map.coord[x][y-taille]==2 || map.coord[x-taille][y-taille]==2 || map.coord[x+taille][y-taille]==2){
						 //on fait rebondir le perso si il touche un mur
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
	}

	
	public boolean checkhitwall(Map map, int direc){
		
		//on transcrit la position du perso en case sur le tableau de la carte
		//Pour savoir dans quel case de la carte il se trouve
		 int x = (int)(Math.round(((this.x/Main.WIN_WIDTH)*map.lar)));
		 int y = (int)(Math.round(((this.y/Main.WIN_WIDTH)*map.lon)));
		 int taille = (int)(Math.round(((this.taille/Main.WIN_WIDTH)*map.lon)));
		 //int step = (int)(Math.round(Main.STEP));
		 //TODO  changer le Math.round ?
		 int step = (int)(Math.round(1));

		// 0: bas 1: haut 2: gauche 3: droite
		
		 //On vérifie si la prochaine direction (celle dans le buffer ) est libre
				 switch(direc){
				 case 0:
					 if (map.coord[x-(taille)][y-(taille)-step]==2 || map.coord[x+(taille)][y-(taille)-step]==2 || map.coord[x][y-(taille)-step]==2){//|| map.coord[x-taille][y-taille]==2 || map.coord[x+taille][y-taille]==2){
						 // la prochaine direction n'est pas libre
						 return true;
					 }
					 break;
				 case 1:
					 if (map.coord[x-(taille)][y+(taille)+step]==2 || map.coord[x+(taille)][y+(taille)+step]==2 || map.coord[x][y+(taille)+step]==2){// || map.coord[x-taille][y+taille]==2 || map.coord[x+taille][y+taille]==2){
						
						 return true;
					 }
					 break;
				 case 2:
					 if (map.coord[x-(taille)-step][y+(taille)]==2 || map.coord[x-(taille)-step][y-(taille)]==2 || map.coord[x-(taille)-step][y]==2){//|| map.coord[x-taille][y+taille]==2 || map.coord[x-taille][y-taille]==2){
						 
						 return true;
					 }
					 break;
				 case 3:
					 if (map.coord[x+(taille)+step][y+(taille)]==2 || map.coord[x+(taille)+step][y-(taille)]==2 || map.coord[x+(taille)+step][y]==2){//|| map.coord[x+taille][y+taille]==2 || map.coord[x+taille][y-taille]==2){
						
						 return true;
					 }
					 break;
				 } 
				 return false;
	}
	 
	 
}