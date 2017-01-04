
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
	 Mur muraille;
	 Cookie listcookie;
	 int [][] coord;
	 public Map(){
		  nbcookies = 1;
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
		 

		  generateWall(this);
		  
		  generatecookie(this);
		 
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
	 public void generatecookie(Map map){
		 map.listcookie = new Cookie(map.xBSpawn,map.yBSpawn);
		 int x,y;
		 for(int k=0;k<map.nbcookies-1;k++){
			 x = Main.random.nextInt(Main.WIN_WIDTH-10)+5;
			 y = Main.random.nextInt(Main.WIN_WIDTH-10)+5;
			 while(map.coord[x][y]!=0){
				 x = Main.random.nextInt(Main.WIN_WIDTH-10)+5;
				 y = Main.random.nextInt(Main.WIN_WIDTH-10)+5;
			 }
			 map.listcookie.suivant = new Cookie(x,y);
			 map.coord[x][y] = 1;
			 //TODO faire un algo reccursif qui parcour la map et dépose des cookie
		 }
		

	 }
	 
	 //TODO passer les check hit dans la classe correspondante;
	 //teste si un perso touche un mur

		 	
	 //TODO passer dans la classe perso?

	//check si le joueur toucche un fantôme
	 public void checkhitghost(Joueur perso,Ghost ghost,Map map){
		 double distance = Math.abs(perso.x-ghost.x)+Math.abs(perso.y-ghost.y);
		 if (distance <= Main.taille *2){
			 Main.init(map);
			 perso.vie = perso.vie-1;
			 
			 
			 }
		 }
		 
	 public void checkhitcookie(Joueur perso,Map map){
		 //TODO trouver le cookie touché et le retirer
		 if(map.coord[(int) perso.x][(int) perso.y]==1){
			 perso.score = perso.score+2;
			 map.coord[(int) perso.x][(int) perso.y]=0;
		 }
	 }
	 
	 
}
