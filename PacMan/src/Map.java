//true mur false vide
// case: 1 cookie, 2 mur, 0 vide
public class Map {

	 int xRSpawn;
	 int yRSpawn;
	 int xOSpawn;
	 int yOSpawn;
	 int xBSpawn;
	 int yBSpawn;
	 int xPSpawn;
	 int yPSpawn;
	 int xStart;
	 int yStart;
	 int largeur;
	 int longeur;
	 Mur listemur;
	 Cookie listcookie;
	 
	 boolean [][] coord;
	 int lon;
	 int lar;
	 Cookie[][] coordcookie;
	 int nbcookie;
	 public Map(){
		 
		 //échelle de l'écran d'affichage
		  largeur = Main.WIN_WIDTH;
		  longeur = Main.WIN_HEIGHT;
		  
		  //echelle de la carte
		   lon = longeur/(2*Main.taille);
		   lar = largeur/(2*Main.taille);

		 //nombre de cookie sur la carte
		  nbcookie = 0;
		  
		  //création de la carte vide
		  coord = new boolean[lar +1][lon+1];
		  
		  //carte où se trouvent les cookies 
		  //(pour savoir lequel est à effacer quand on marche dessus)
		  coordcookie = new Cookie[lar][lon];
		  

		 generateWall();
		  
		 generatecookie();
		  //placement des endroit d'apparition des personnages
		 
		 //(lon/2 +2)*(longeur/lon) : milieu de la map +1
		 int milieu = (int)((lon/2 +2)*(longeur/lon));
		  xRSpawn = largeur/2;
		  yRSpawn = milieu;
		  xOSpawn =  largeur/2 +4*lon +10;
		  yOSpawn = milieu;
		  xBSpawn =  largeur/2 +10;
		  yBSpawn =  milieu ;
		  xPSpawn =  largeur/2 -10; 
		  yPSpawn = milieu;
		  xStart = largeur -lar-10+2;
		  yStart = lon+10-2;
		  
		  //coord(toCase(xRSpawn,yRSpawn));
		 
	 }
	 
	 public int[] toCase(Double x, Double y){
		int nx = (int)(Math.round(((x/Main.WIN_WIDTH)*lar)));
		 int ny = (int)(Math.round(((y/Main.WIN_WIDTH)*lon)));
		 int[]res = {nx,ny};
		 return res;
	 }
	 
	 public void generateWall(){
		 //TODO possibilité de passer d'un coté à l'autre ?

		 //Création des bords
		 //listemur = new Mur(Main.WIN_WIDTH/2,Main.WIN_HEIGHT/2,(Main.WIN_WIDTH/2-(largeur/lar)/2 -2),(Main.WIN_HEIGHT/2 -(longeur/lon)/2 -2));
		 //On met des murs sur les bordures de la carte
		 for(int x = 1;x<lar;x = x+1) {			
			 coord[x][0] = true;
			 coord[x][lon] = true;
		 }
				
		 for(int y = 1;y<lon;y++) {
			 coord[0][y] = true;
			 coord[lar][y] = true;
			}
		
		 listemur = null;
		 //On place des murs sur la carte et on crée la liste des murs à afficher
		for(int x = 4;x<lar-2;x = x+2) {
			for(int y = 4;y<lon-2;y = y+4) {
				if(Main.random.nextInt(10)<8){
					 listemur = Mur.addMur(listemur,  new Mur(x*(largeur/lar),y*(longeur/lon),(longeur/lon),(longeur/lon)));
					 
					 coord[x][y] = true;
				  	}
			}
		}
		//ajout de murs "verticalement"
		for(int y = 6;y<lon-2;y = y+4) {
				if(y!=lon/2 +2){
				if(Main.random.nextInt(10)<10){
					//On ajoute un mur par ligne sur la ligne de passage à un endroit aléatoire
					int x = 2*Main.random.nextInt(lar/2 -4)+4;
					 listemur = Mur.addMur(listemur, new Mur(x*(largeur/lar),y*(longeur/lon),(longeur/lon),(longeur/lon)));
					 
					 coord[x][y] = true;
				  	}
				}
			
		}
	 }
	
	 public void generatecookie(){
		 listcookie = null;
		 for(int x = 2;x<lar-1;x = x+2) {
				for(int y = 2;y<lon-1;y = y+2) {
				
						if(!coord[x][y]){
					  		
					  		Cookie nouveau =new Cookie(x*(largeur/lar),y*(longeur/lon),x,y);
					  		nbcookie=  nbcookie+1;
					  		
					  		listcookie = Cookie.addCookie(listcookie, nouveau);
					  		
					  		this.coordcookie[x][y] = nouveau;				  	
					  		
						}
				}
		 }
			int xb; int yb;
			for(int i= 0; i< 4; i++){
				
	  			xb = Main.random.nextInt(lar-4)+2;
	  			yb = Main.random.nextInt(lon-4)+2;
	  			while(coordcookie[xb][yb]==null || coordcookie[xb][yb].bonus){
	                xb = Main.random.nextInt(lar-4)+2;
	                yb = Main.random.nextInt(lar-4)+2;
	            }
	            coordcookie[xb][yb].bonus = true;
	  		}
		
	 }

	 
		public  void  deleteCookie(Cookie cookie){
			
			
			Cookie courant = listcookie;
			//règle le problème de si le cookie est au début de la liste
			if (courant.equals(cookie)){
				listcookie = listcookie.suivant;
				
			}else{
				while(courant.suivant !=null){
					if (courant.suivant.equals(cookie)){
						courant.suivant = courant.suivant.suivant;
						break;
					}else{
						courant = courant.suivant;
					}
					
				}
			}

			
			
		}
	 

	//check si le joueur toucche un fantôme en regardant la distance entre les 2
	 public void checkhitghost(Joueur perso,Ghost ghost){
		 double distance = Math.abs(perso.x-ghost.x)+Math.abs(perso.y-ghost.y);
		 if (distance <= perso.taille *2+2){
			 perso.vie = perso.vie-1;
			 if(perso.vie>0){
			 Main.init();
			 }else{
				 Main.fin();
			 }
			 
			 
			 }
		 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	       
	
	  
	 
	 
}
