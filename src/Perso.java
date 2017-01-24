import edu.princeton.cs.introcs.StdDraw;

public class Perso {
	double x;
	double y;
	//direction
	int dir;
	int buffer;
	String name;
	String image;
	double taille;
	double taille2;
	//sert a la direction de l'image
	boolean imgdir;
	public Perso (int x0, int y0,int dir0, String nom, String pic){
		x = x0;
		y = y0;
		name = nom;
		dir = dir0;
		buffer = dir0;
		taille2 = Main.taille;
		taille = Main.taille*1.3;
		image = pic;
	}
	// 0: bas 1: haut 2: gauche 3: droite
	 public  void move (){
		//Efface la précédente occurence
		 
		 effacer();
		 
		 switch(this.dir){
		 case 0:
			 
			 this.y = this.y-Main.STEP;
			
			 break;
		 case 1:
			 
			 this.y = this.y+Main.STEP;
			 
			 break;
		 case 2:
			 //sert pour l'affichage de l'image, définit si la dernière direction est droite ou gauche(false)
			 imgdir = false;
			 this.x = this.x-Main.STEP;
			
			 break;
		 case 3:
			 imgdir = true;
			 this.x = this.x+Main.STEP; 
			 break;
		default:
			break;
		 }
		 
	 }

	 public boolean checkhitwall(Map map){
		 //On passe la coordonnée du personnage en numéro de case du tableau de la carte
			int[]coordcase = map.toCase(this.x, this.y);
			int x = coordcase [0];
			int y = coordcase[1];
		 int ntaille = (int)(Math.round((((this.taille2)/Main.WIN_WIDTH)*map.lon)));
		
		
		 	//On regarde si le perso touche un mur dans la direction dans laquelle il se déplace
				 switch(this.dir){
				 case 0:
					//On prend en compte la taille/épaisseur (+ - taille)
					 if (map.coord[x][y-ntaille]==2 || map.coord[x-ntaille][y-ntaille]==2 || map.coord[x+ntaille][y-ntaille]==2){
						 //on fait rebondir le perso si il touche un mur
						 this.y = this.y+2*Main.STEP;
						
						 return true;
					 }
					 break;
				 case 1:
					 if (map.coord[x][y+ntaille]==2 || map.coord[x-ntaille][y+ntaille]==2 || map.coord[x+ntaille][y+ntaille]==2){
						 this.y = this.y-2*Main.STEP;
						 return true;
					 }
					 break;
				 case 2:
					 if (map.coord[x-ntaille][y]==2 || map.coord[x-ntaille][y+ntaille]==2 || map.coord[x-ntaille][y-ntaille]==2){
						 this.x = this.x+2*Main.STEP;
						 return true;
					 }
					 break;
				 case 3:
					 if (map.coord[x+ntaille][y]==2 || map.coord[x+ntaille][y+ntaille]==2 || map.coord[x+ntaille][y-ntaille]==2){
						 this.x = this.x-2*Main.STEP;
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
		int[]coordcase = map.toCase(this.x, this.y);
		int x = coordcase [0];
		int y = coordcase[1];

		 int ntaille = (int)(Math.round((((this.taille2)/Main.WIN_WIDTH)*map.lon)));
		 //int step = (int)(Math.round(Main.STEP));

		 int step = (int)(Math.round((((Main.STEP*this.taille2)/Main.WIN_WIDTH)*map.lon)));

		// 0: bas 1: haut 2: gauche 3: droite
		
		 //On vérifie si la prochaine direction (celle dans le buffer ) est libre
				 switch(direc){
				 //y
				 case 0:
					 //On prend en compte la taille/épaisseur (+ - taille) du perso ainsi que ça prochaine position (+ - step)
					 if (map.coord[x-(ntaille)][y-(ntaille)-step]==2 || map.coord[x+(ntaille)][y-(ntaille)-step]==2 || map.coord[x][y-(ntaille)-step]==2){
						 // la prochaine direction n'est pas libre
						 
				
						 return true;

					 }
					 break;
				 case 1:
					 if (map.coord[x-(ntaille)][y+(ntaille)+step]==2 || map.coord[x+(ntaille)][y+(ntaille)+step]==2 || map.coord[x][y+(ntaille)+step]==2){
					
						 return true;
						 
					 }
					 break;
					 //x
				 case 2:
					 if (map.coord[x-(ntaille)-step][y+(ntaille)]==2 || map.coord[x-(ntaille)-step][y-(ntaille)]==2 || map.coord[x-(ntaille)-step][y]==2){
						 			
						 return true;
						
					 }
					 break;
				 case 3:
					 if (map.coord[x+(ntaille)+step][y+(ntaille)]==2 || map.coord[x+(ntaille)+step][y-(ntaille)]==2 || map.coord[x+(ntaille)+step][y]==2){
						 				
						 return true;
						 
					 }
					 break;
				 } 
				 return false;
	}
	 
	//afficher le personnage par une image
	public void afficher(){		
		if (this.imgdir){
			//dessine l'image du fantome avec la bonne direction
			StdDraw.picture(this.x, this.y, Main.dossierImage+this.image+"d"+".png",this.taille*2,this.taille*2);
		}else{
			StdDraw.picture(this.x, this.y, Main.dossierImage+this.image+"l"+".png",this.taille*2,this.taille*2);
		}
		
	}
	//repeint la position du perso
	public void effacer(){
		StdDraw.setPenColor(StdDraw.BLACK);
		//+1 due au décalage
    	StdDraw.filledSquare(x,y,taille+1);
	}
	 
}