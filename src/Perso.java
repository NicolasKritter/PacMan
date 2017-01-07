
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

	
	public boolean checkhitwall(Map map, int direc){
		 int x = (int)(this.x);
		 int y = (int)(this.y);
		 int taille = (int)(this.taille);
		 int step = (int)(Math.round(Main.STEP));
			 //TODO Hitbox de suppression
		// 0: bas 1: haut 2: gauche 3: droite
		 //TODO oasser le + en math.round
		
				 switch(direc){
				 case 0:
					 if (map.coord[x-(taille)][y-(taille)-step]==2 || map.coord[x+(taille)][y-(taille)-step]==2){//|| map.coord[x-taille][y-taille]==2 || map.coord[x+taille][y-taille]==2){
						 
						 return true;
					 }
					 break;
				 case 1:
					 if (map.coord[x-(taille)][y+(taille)+step]==2 || map.coord[x+(taille)][y+(taille)+step]==2){// || map.coord[x-taille][y+taille]==2 || map.coord[x+taille][y+taille]==2){
						
						 return true;
					 }
					 break;
				 case 2:
					 if (map.coord[x-(taille)-step][y+(taille)]==2 || map.coord[x-(taille)-step][y-(taille)]==2){//|| map.coord[x-taille][y+taille]==2 || map.coord[x-taille][y-taille]==2){
						 
						 return true;
					 }
					 break;
				 case 3:
					 if (map.coord[x+(taille)+step][y+(taille)]==2 || map.coord[x+(taille)+step][y-(taille)]==2 ){//|| map.coord[x+taille][y+taille]==2 || map.coord[x+taille][y-taille]==2){
						
						 return true;
					 }
					 break;
				 } 
				 return false;
			 //TODO expliquer méthode des cases
			//TODO optimiser méthode de shannon
	}
	 
	 
	 
}

