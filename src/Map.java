
// case: 1 coockie, 2 mur, 0 vide
public class Map {
	 int nbcoockies;
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
	 Mur muraille;
	 Coockie[] listcoockie;
	 int [][] coord;
	 public Map(){
		  xRSpawn = Main.WIN_WIDTH/2;
		  yRSpawn = Main.WIN_HEIGHT/4;
		  xOSpawn = Main.WIN_WIDTH-Main.taille-10;
		  yOSpawn = Main.WIN_HEIGHT-Main.taille-10;
		  xBSpawn =Main.taille+10;
		  yBSpawn = Main.WIN_HEIGHT-Main.taille-10;
		  xPSpawn = Main.taille+10;
		  yPSpawn = Main.taille+10;
		  xStart = Main.WIN_WIDTH-Main.taille-10;
		  yStart = Main.taille+10;
		  largeur = Main.WIN_WIDTH;
		  longeur = Main.WIN_HEIGHT;
		  coord = new int[largeur+1][longeur+1];
		  
		  for (int k = 0; k<coord.length;k++){
			  for (int j = 0; j<coord[0].length;j++){
				  coord[k][j] = 1;
			  }
		  }
		 
		  generateCoockie(this);
		  generateWall(this);
		  
		 
		 
	 }
	 //TODO fantome tracking si pas de mur entre
	 //TODO taille des mur variable ?
	 //TODO MOuvement overlap dir != hit
	 
	 public void generateWall(Map map){
		 //TODO possibilité de passer d'un coté à l'autre ?
		 //Création des bords, de largeur 5
		 map.muraille = new Mur(0+5,map.longeur/2,5,map.longeur/2);
		 Mur.addMur(muraille, new Mur(map.largeur-5,map.longeur/2,5,map.longeur/2));
		 Mur.addMur(muraille, new Mur(map.largeur/2,0+5,map.largeur/2,5));
		 Mur.addMur(muraille, new Mur(map.largeur/2,map.longeur-5,map.largeur/2,5));
		 
		
		 //teste de création de murs
		 
		 int taillex = 50;//largeur des murs horizontaux
		 
		 //Création des murs 
		 for (int x =taillex+2*Main.taille+10;x<map.largeur-10-taillex-Main.taille;x = x+2*taillex+2*Main.taille){
			  for (int y=3*Main.taille+10;y<map.longeur-10-2*Main.taille;y = y+4*Main.taille){
				  	if(Main.random.nextInt(10)<7){
					 map.muraille = Mur.addMur(map.muraille, new Mur(x,y,taillex,Main.taille));
					 //taillex = Main.random.nextInt(map.largeur-x)/6 + 20;
				  	}
				  	
				  
					  	
				  
				  
			  }
		 }
		 int tailley =50;// longueur des mrus verticaux
		 //création des murs verticaux
		 for (int y = tailley+2*Main.taille+10;y<map.longeur-10-tailley-Main.taille;y = y+2*tailley+2*Main.taille){
			  for (int x=3*Main.taille+10;x<map.longeur-10-2*Main.taille;x = x+2*taillex+4*Main.taille){
				  if (Main.random.nextInt(10)<7){
					 map.muraille = Mur.addMur(map.muraille, new Mur(x,y,Main.taille,tailley));
					 //tailley = Main.random.nextInt(map.largeur -y)/6 + 10;
				  }
					 
				  
			  }
		 }
		

		  
		  
		  
		  Mur wall = map.muraille;
		  //Impression des murs sur  la carte
			  while(wall!=null){
			 
			  for (int a = wall.x-wall.large;a<=wall.x+wall.large;a++){
				  for (int b = wall.y-wall.longe;b<=wall.y+wall.longe;b++){
					  
					  map.coord[a][b] = 2;
				  }
				  
			  }
			 
				  wall =  wall.suivant;
		  }
		 
	 }
	 public void generateCoockie(Map map){
		 
		 int xStart = 0;
		 int yStart = 0;
		 while (xStart <5 || xStart>map.largeur-5){
			 xStart =map.largeur/2;
		 }
		 while (yStart <5 || yStart>map.largeur-5){
			 yStart =map.longeur/2;
		 }
		

		 /*creuser(xStart,yStart,map);
		 creuser(map.xBSpawn,map.xBSpawn,map);
		 creuser(map.xPSpawn,map.xPSpawn,map);
		 creuser(map.xRSpawn,map.xRSpawn,map);
		 creuser(map.xOSpawn,map.xOSpawn,map);*/
	 }
	 private static void creuser(int x, int y,Map map){
		 int [][]coord = map.coord;
		 int taille = Main.taille;
		 if(x < taille || y < taille || x >= map.largeur-taille|| y >=map.longeur-taille) {
	            return;
	        }else{
	        	imprimer(x,y,map,taille);
	        	creuser(x+2*taille,y+2*taille,map);
	        }
		 /*
	        if (coord[x][y]==2 )
	        {
	        	
	        		System.out.println(x +"\t"+y);
	        	
	            if (coord[x-taille][y]==2 && Main.random.nextBoolean()) {
	            	imprimer(x-2*taille, y,map,taille);
	                
	                creuser(x,y-taille, map);
	            }
	            if (coord[x+taille][y]==2 && Main.random.nextBoolean()) {
	            	imprimer(x+2*taille, y,map,taille);
	                creuser(x,y+taille, map);
	            }
	            if (coord[x][y+taille]==2 && Main.random.nextBoolean()) {
	            	imprimer(x, y+2*taille,map,taille);
	                creuser(x+taille,y, map);
	            }
	            if (coord[x][y-taille]==2 && Main.random.nextBoolean()) {
	            	imprimer(x, y-taille,map,taille);
	                creuser(x-taille,y, map);
	            }
	            
	            
	        }*/
	 }
	 
	 private static void imprimer(int x, int y,Map map,int taille){
		 for (int k=0;k<2*taille;k++){
     		for (int j=0; j<2*taille;j++){
     			map.coord[x-taille+k][y-taille+j] = 1;
     		}
		 }
	 }
	 public void checkhitwall(Joueur perso,Map map){
		 int x = (int)(perso.x);
		 int y = (int)(perso.y);
		 int taille = (int)(Main.taille);
		
			 
		 
		//TODO Ne pas prendre en compte la direction
				 switch(perso.dir){
				 case 0:
					 if (map.coord[x][y-taille]==2){
					 perso.y = perso.y+Main.STEP;
					 perso.dir =-1;
					 }
					 break;
				 case 1:
					 if (map.coord[x][y+taille]==2){
					 perso.y = perso.y-Main.STEP;
					 perso.dir =-1;
					 }
					 break;
				 case 2:
					 if (map.coord[x-taille][y]==2){
					 perso.x = perso.x+Main.STEP;
					 perso.dir =-1;
					 }
					 break;
				 case 3:
					 if (map.coord[x+taille][y]==2){
					 perso.x = perso.x-Main.STEP;
					 perso.dir =-1;
					 }
					 break;
				 }
				 
				 
			 
	}
		 
	 
	 public void checkhitwall(Ghost ghost,Map map){
		 int x = (int)(ghost.x);
		 int y = (int)(ghost.y);
		 int taille = (int)(Main.taille);
		 int oldir  =ghost.dir;
		 boolean hit = false;
		 
		 
				 switch(oldir){
				 case 0:
					 if (map.coord[x][y-taille]==2){
						 ghost.y = ghost.y+Main.STEP;
						 hit = true;
					 }
					 break;
				 case 1:
					 if (map.coord[x][y+taille]==2){
						 ghost.y = ghost.y-Main.STEP;
						 hit = true;
					 }
					 break;
				 case 2:
					 if (map.coord[x-taille][y]==2){
						 ghost.x = ghost.x+Main.STEP;
						 hit = true;
					 }
					 break;
				 case 3:
					 if (map.coord[x+taille][y]==2){
						 ghost.x = ghost.x-Main.STEP;
						 hit = true;
					 }
					 break;
				 }
				 while (ghost.dir==oldir && hit==true){
					 ghost.dir = Main.random.nextInt(4);
				 }
		 }
	//TODO return boolean ?	 
	 public void checkhitghost(Joueur perso,Ghost ghost,Map map){
		 double distance = Math.abs(perso.x-ghost.x)+Math.abs(perso.y-ghost.y);
		 if (distance <= Main.taille *2){
			 Main.init(map);
			 perso.vie = perso.vie-1;
			 
			 
			 }
		 }
		 
	 
	 
	 
}
