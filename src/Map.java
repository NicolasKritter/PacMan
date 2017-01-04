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
	 Mur muraille;
	 Cookie listcookie;
	 int [][] coord;
	 boolean[][] carte;
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
		  //carte =  generer(9,9);
		  
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
		 
	 /*
	  * 
	  * 
	  * 
	  * 
	  */
		static int xposA;
		 static int yposA;
		 static int xposD;
		 static int yposD;
		 static int xr;
		 static int yr;
		 static int xb;
		 static int yb;
		 
		//Classe interne repr�sentant une case libre, utilis�e pour la g�n�ration du labyrinthe
	    private static class Cell {
	        boolean north=false,
	                south=false,
	                east=false,
	                west=false,
	                visited =false;

	    }
	    static Random random = new Random(System.currentTimeMillis());

	 private static boolean [][] generer(int largeur, int longueur)
	    {
	        Cell [][] laby = new Cell[largeur][longueur];
	        for(int i=0;i<laby.length;i++)
	            for (int j=0;j<laby[i].length;j++)
	                laby[i][j]=new Cell();

	        int startX = random.nextInt(largeur);
	        int startY = random.nextInt(longueur);
	        creuser(startX,startY,laby);
	        yposA = 2*longueur;
	        xposA = random.nextInt(2*largeur+1);
	        yposD =0;
	        xposD =startX;
	       
	        return toBoolean(laby);

	    }

	    /**
	     * Fait un labyrinthe al�atoirement
	     * @param x
	     * @param y
	     * @param laby
	     */
	    private static void creuser(int x, int y, Cell [][] laby)
	    {
	        if(x < 0 || y < 0 || x >= laby.length || y >=laby[0].length) {
	            return;
	        } else if(laby[x][y]==null) {
	            laby[x][y] = new Cell();
	        }

	        if (!laby[x][y].visited)
	        {

	            if (!laby[x][y].west && random.nextBoolean()) {
	                laby[x][y].west = true;
	                creuser(x,y-1, laby);
	            }
	            if (!laby[x][y].east && random.nextBoolean()) {
	                laby[x][y].east = true;
	                creuser(x,y+1, laby);
	            }
	            if (!laby[x][y].north && random.nextBoolean()) {
	                laby[x][y].north = true;
	                creuser(x-1,y, laby);
	            }
	            if (!laby[x][y].south && random.nextBoolean()) {
	               laby[x][y].south = true;
	                creuser(x+1,y, laby);
	            }
	            laby[x][y].visited = true;
	        }
	    }

	   public static boolean [][] toBoolean(Cell [][] array) {
	        boolean [][] out = new boolean[(array.length*2)+1][(array[0].length*2)+1];

	        for(int i=0;i<array.length;i++)
	        {
	            for(int j=0;j < array[i].length;j++)
	            {
	                int x = (i*2)+1, y = (j*2)+1;
	                out[x][y] = true;
	                if(array[i][j].west) out[x][y-1] = true;
	                if(array[i][j].east) out[x][y+1] = true;
	                if(array[i][j].south) out[x+1][y] = true;
	                if(array[i][j].north) out[x-1][y] = true;
	            }
	        }
	        
	       return out;
	    }
	    public void printLabyrinthe(boolean [][] laby) {

	        
	        for(int i =0;i<laby.length;i++) {
	            for(int j=0;j<laby.length;j++){
	            	
	            	if(!laby[i][j]){
	            	StdDraw.setPenColor(StdDraw.GRAY);
	       	    	 StdDraw.filledRectangle(Main.WIN_WIDTH/19 *i,Main.WIN_HEIGHT/19*j,Main.WIN_WIDTH/40,Main.WIN_WIDTH/40);
	            	}
	            	
	            }
	            	
	            
	        }

	       
	    }
	  
	 
	 
}
