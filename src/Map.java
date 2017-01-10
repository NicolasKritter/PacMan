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
	 public Map(){

		  largeur = Main.WIN_WIDTH;
		  longeur = Main.WIN_HEIGHT;
		   lon = longeur/(2*Main.taille);
		   lar = largeur/(2*Main.taille);
		  nbcookies = 1;
		  
		  xRSpawn = largeur/2;
		  yRSpawn = longeur/4;
		  xOSpawn = largeur -2*lar;
		  yOSpawn = longeur-2*lon;
		  xBSpawn = 2*lon;
		  yBSpawn = longeur-2*lon;
		  xPSpawn = 2*lar;
		  yPSpawn = 2*lon;
		  xStart = largeur -2*lar;
		  yStart = 2*lon;
		  
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
		 listemur = new Mur(1,-1,largeur,(longeur/lon));
		 //Mur.addMur(listemur, new  Mur(1,(lon)*(largeur/lar),largeur-10,(longeur/lon) ));
		 Mur.addMur(listemur, new Mur(largeur/2,0+10,largeur/2 -10,5));
		 Mur.addMur(listemur, new Mur(largeur/2,longeur-5,largeur/2,10));
		 Mur.addMur(listemur, new Mur(-1,1,(longeur/lon),longeur-10));
			Mur.addMur(listemur, new Mur(largeur,(lon)*(largeur/lar),(longeur/lon),longeur-10));
		 for(int x = 1;x<lar;x = x+1) {			
			 coord[x][0] = 2;
			 coord[x][lon] = 2;
		 }
				
		 for(int y = 1;y<lon;y++) {
			 coord[0][y] = 2;
			 coord[lar][y] = 2;
			}
		
		
//TODO 	ajouter des mus verticalement ?
		for(int x = 2;x<lar-2;x = x+2) {
			for(int y = 4;y<lon-2;y = y+4) {
				if(Main.random.nextInt(10)<8){
					 Mur.addMur(listemur, new Mur(x*(largeur/lar),y*(longeur/lon),(longeur/lon),(longeur/lon)));
					 //taillex = Main.random.nextInt(largeur-x)/6 + 20;
					 coord[x][y] = 2;
				  	}
			}
		}
		/* for (int x =taillex+Main.taille;x<largeur-taillex-Main.taille;x = x+2*taillex){
			  for (int y=3*Main.taille+Main.taille;y<longeur;y = y+4*Main.taille){
				  	if(Main.random.nextInt(10)<7){
					 listemur = Mur.addMur(listemur, new Mur(x,y,taillex-Main.taille-1,Main.taille));
					 //taillex = Main.random.nextInt(largeur-x)/6 + 20;
				  	}
				  	
				  
					  	
				  
				  
			  }
		 }
		 // longueur des mrus verticaux
		 //création des murs verticaux
		 for (int y = tailley+Main.taille;y<longeur-tailley-Main.taille;y = y+2*tailley){
			  for (int x=3*Main.taille+Main.taille;x<longeur-Main.taille-Main.taille;x = x+2*taillex+4*Main.taille){
				  if (Main.random.nextInt(10)<7){
					 listemur = Mur.addMur(listemur, new Mur(x,y,Main.taille,tailley-Main.taille-1));
					 //tailley = Main.random.nextInt(largeur -y)/6 + 10;
				  }
					 
				  
			  }
		 } */
			  

		 /* Mur wall = listemur;
		  //Impression des murs sur  la carte
			  while(wall!=null){
			 
			  for (int a = wall.x-wall.large;a<=wall.x+wall.large;a++){
				  for (int b = wall.y-wall.longe;b<=wall.y+wall.longe;b++){
					  
					  coord[a][b] = 2;
				  }
				  
			  }
			 
				  wall =  wall.suivant;
		  }*/
		 
	 }
	 public void generatecookie(){
		 listcookie = new Cookie(xBSpawn,yBSpawn,xBSpawn*(lar/largeur) ,yBSpawn*(lon/longeur) );
		 for(int x = 2;x<lar-1;x = x+2) {
				for(int y = 2;y<lon-1;y = y+2) {
					 if(coord[x][y]!=2){
					  		
					  		Cookie nouveau =new Cookie(x*(largeur/lar),y*(longeur/lon),x,y);
					  		Cookie.addCookie(listcookie, nouveau);
					  		this.coord[x][y] = 1;
					  		this.coordcookie[x][y] = nouveau; 
					  		System.out.println(this.coordcookie[x][y]+ " "+x +" "+y);
					  	}
				}
		 }
		
	 }
	 //TODO si marche: parcourir la liste et supprimer direct sans tableau
		public  void  deleteCookie(Cookie Cookie){
			

			Cookie courant = this.listcookie;
			int k = 0;
					
			while(!courant.equals(Cookie) && courant.suivant != null){
				courant = courant.suivant;
			
				k =k+1;
				
			}
			
			if(courant!=null){
				Cookie reste = courant.suivant;
				courant.visible = "non";
				System.out.println(courant);
			courant = reste;
			
			System.out.println(courant);
			
			}
			while(courant!=null){
				k = k+1;
				courant = courant.suivant;
			}
			
			//return this.listcookie;
			System.out.println(k);
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
