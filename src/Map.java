
public class Map {
	 int nbfromage;
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
	 Mur[] listmur;
	 int[] coordMurx;
	 int[] coordMury;
	 int [][] coord;
	 public Map(){
		  xRSpawn = Main.WIN_WIDTH/2;
		  yRSpawn = Main.WIN_HEIGHT/4;
		  xOSpawn = Main.WIN_WIDTH/2;
		  yOSpawn = Main.WIN_HEIGHT/3;
		  xBSpawn = Main.WIN_WIDTH/3;
		  yBSpawn = Main.WIN_HEIGHT/2;
		  xPSpawn = Main.WIN_WIDTH/4;
		  yPSpawn = Main.WIN_HEIGHT/3;
		  xStart = Main.WIN_WIDTH/4;
		  yStart = Main.WIN_HEIGHT/5;
		  largeur = Main.WIN_WIDTH;
		  longeur = Main.WIN_HEIGHT;
		  listmur=  new Mur[7];
		  coord = new int[largeur+1][longeur+1];
		  
		  for (int k = 0; k<coord.length;k++){
			  for (int j = 0; j<coord[0].length;j++){
				  coord[k][j] = 0;
			  }
		  }
		 
		  generateWall(this);
		  
		 
		 
	 }
	 public void generateWall(Map map){
		 int j = 0;
		 //Création des bords, de largeur 5
		 map.listmur[0] = new Mur(0+5,map.longeur/2,5,map.longeur/2);
		 map.listmur[1] = new Mur(map.largeur-5,map.longeur/2,5,map.longeur/2);
		 map.listmur[2] = new Mur(map.largeur/2,0+5,map.largeur/2,5);
		 map.listmur[3] = new Mur(map.largeur/2,map.longeur-5,map.largeur/2,5);
		 //
		  for (int k=4;k<7;k++){
			  map.listmur[k]  = new Mur(34+j,25,10,20);
			  j = j+20;
		  }
		  for (int k = 0;k<map.listmur.length;k++){
			  Mur mur = listmur[k];
			  
			  for (int a = mur.x-mur.large;a<=mur.x+mur.large;a++){
				  for (int b = mur.y-mur.longe;b<=mur.y+mur.longe;b++){
					  map.coord[a][b] = 2;
				  }
			  }
			  
		  }
		 
	 }
	 public void generateCoockie(Map map){
		 
	 }
	 
	 public void checkhitwall(Perso perso,Map map){
		 //TODO prendre en compte la taille
			 if(map.coord[(int)(perso.x)][(int)(perso.y)]==2){
				 switch(perso.dir){
				 case 0:
					 perso.y = perso.y+Main.STEP;
					 break;
				 case 1:
					 perso.y = perso.y-Main.STEP;
					 break;
				 case 2:
					 perso.x = perso.x+Main.STEP;
					 break;
				 case 3:
					 perso.x = perso.x-Main.STEP;
					 break;
				 }
				 perso.dir =-1;
			 }
	}
		 
	 
	 public void checkhitwall(Ghost ghost,Map map){
		 if(map.coord[(int)(ghost.x)][(int)(ghost.y)]==2){
			 int oldir = ghost.dir;
			 switch(ghost.dir){
			 case 0:
				 ghost.y = ghost.y+Main.STEP;
				 break;
			 case 1:
				 ghost.y = ghost.y-Main.STEP;
				 break;
			 case 2:
				 ghost.x = ghost.x+Main.STEP;
				 break;
			 case 3:
				 ghost.x = ghost.x-Main.STEP;
				 break;
			 }
			 
			 while (ghost.dir==oldir){
				 ghost.dir = Main.random.nextInt(3);
			 }
		 }
		 
	 }
	 public void checkhitghost(Perso perso,Ghost ghost){
		 double distance = Math.abs(perso.x-ghost.x)+Math.abs(perso.y-ghost.y);
		 if (distance <= Main.taille *2){
			 perso.vie = perso.vie-1;
			 
			 
			 }
		 }
		 
	 
	 
	 
}
