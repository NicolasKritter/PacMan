import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;


// case: 1 cookie, 2 mur, 0 vide
public class Map {
	 int nbcookies;
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
	 int [][] coord;
	 int lon;
	 int lar;
	 Cookie[][] coordcookie;
	 int nbcookie;
	 public Map(){
		 	//TODO enlever le 2*taille ?
		  largeur = Main.WIN_WIDTH;
		  longeur = Main.WIN_HEIGHT;
		   lon = longeur/(2*Main.taille);
		   lar = largeur/(2*Main.taille);
		  nbcookies = 1;
		  
		  xRSpawn = largeur/2;
		  yRSpawn = longeur/4;
		  xOSpawn = largeur -lar;
		  yOSpawn = longeur-lon;
		  xBSpawn = lon;
		  yBSpawn = longeur-lon;
		  xPSpawn = lar;
		  yPSpawn = lon;
		  xStart = largeur -lar;
		  yStart = lon;
		  nbcookie = 0;
		  
		  //coord = new int[largeur+1][longeur+1];
		  coord = new int[lar+1 ][lon+1 ];
		  coordcookie = new Cookie[lar+1 ][lon+1 ];
		  for (int k = 0; k<coord.length;k++){
			  for (int j = 0; j<coord[0].length;j++){
				  coord[k][j] = 1;
			  }
		  }
		  //carte =  generer(lar,lon);
		  
		 generateWall();
		  
		 generatecookie();
		 
	 }
	 //TODO fantome tracking si pas de mur entre
	 //TODO taille des mur variable ?
	 //TODO MOuvement overlap dir != hit
	 
	 public void generateWall(){
		 //TODO possibilité de passer d'un coté à l'autre ?
		 
		 //TODO refaire les murs de bord de façon plus propre largeur /2 ect...
		 //Création des bords
		 listemur = new Mur(Main.WIN_WIDTH/2,Main.WIN_HEIGHT/2,(Main.WIN_WIDTH/2-(largeur/lar)/2 -1),(Main.WIN_HEIGHT/2 -(longeur/lon)/2 -1));
		 //Mur.addMur(listemur, new  Mur(1,(lon)*(largeur/lar),largeur-10,(longeur/lon) ));
		 /*Mur.addMur(listemur, new Mur(largeur/2,0+10,largeur/2 -10,5));
		 Mur.addMur(listemur, new Mur(largeur/2,longeur-5,largeur/2,10));
		 Mur.addMur(listemur, new Mur(-1,1,(longeur/lon),longeur-10));
			Mur.addMur(listemur, new Mur(largeur,(lon)*(largeur/lar),(longeur/lon),longeur-10));*/
		 for(int x = 1;x<lar;x = x+1) {			
			 coord[x][0] = 2;
			 coord[x][lon] = 2;
		 }
				
		 for(int y = 1;y<lon;y++) {
			 coord[0][y] = 2;
			 coord[lar][y] = 2;
			}
		
		
//TODO 	ajouter des mus verticalement ?
		for(int x = 4;x<lar-2;x = x+2) {
			for(int y = 4;y<lon-2;y = y+4) {
				if(Main.random.nextInt(10)<8){
					 Mur.addMur(listemur, new Mur(x*(largeur/lar),y*(longeur/lon),(longeur/lon),(longeur/lon)));
					 
					 coord[x][y] = 2;
				  	}
			}
		}
		
		 
	 }
	 public void generatecookie(){
		 listcookie = null;
		 for(int x = 2;x<lar-1;x = x+2) {
				for(int y = 2;y<lon-1;y = y+2) {
					 if(coord[x][y]!=2){
					  		
					  		Cookie nouveau =new Cookie(x*(largeur/lar),y*(longeur/lon),x,y);
					  		nbcookie=  nbcookie+1;
					  		listcookie = Cookie.addCookie(listcookie, nouveau);
					  		this.coord[x][y] = 1;
					  		this.coordcookie[x][y] = nouveau; 
					  		System.out.println(this.coordcookie[x][y]+ " "+x +" "+y);
					  	}
				}
		 }
		
	 }
		public  void  deleteCookie(Cookie Cookie){
			

			Cookie courant = this.listcookie;
					
			while(!courant.equals(Cookie) && courant.suivant != null){
				courant = courant.suivant;
			
				
			}
			
			if(courant!=null){
				Cookie reste = courant.suivant;
			courant.visible = "non";
				System.out.println(courant);
			courant = reste;
			
			
			}
			
		}
	 

	//check si le joueur toucche un fantôme
	 public void checkhitghost(Joueur perso,Ghost ghost,Map map){
		 double distance = Math.abs(perso.x-ghost.x)+Math.abs(perso.y-ghost.y);
		 if (distance <= Main.taille *2){
			 perso.vie = perso.vie-1;
			 Main.init(map);		
			 
			 
			 }
		 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	       
	
	  
	 
	 
}
