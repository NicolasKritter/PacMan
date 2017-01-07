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
	 int lon;
	 int lar;
	 boolean[][] carte;
	 public Map(){

		  largeur = Main.WIN_WIDTH;
		  longeur = Main.WIN_HEIGHT;
		   lon = longeur/(2*Main.taille);
		   lar = largeur/(2*Main.taille);
		  nbcookies = 1;
		  /*xRSpawn = largeur/2;
		  yRSpawn = longeur/4;
		  xOSpawn = largeur -Main.taille-11;
		  yOSpawn = longeur-Main.taille-11;
		  xBSpawn = Main.taille+11;
		  yBSpawn = longeur-Main.taille-11;
		  xPSpawn = Main.taille+11;
		  yPSpawn = Main.taille+11;
		  xStart = largeur -Main.taille-12;
		  yStart = Main.taille+12;*/
		  
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
		  for (int k = 0; k<coord.length;k++){
			  for (int j = 0; j<coord[0].length;j++){
				  coord[k][j] = 1;
			  }
		  }
		  //carte =  generer(lar/2,lon/2);
		  
		 generateWall();
		  
		 generatecookie();
		 
	 }
	 //TODO fantome tracking si pas de mur entre
	 //TODO taille des mur variable ?
	 //TODO MOuvement overlap dir != hit
	 
	 public void generateWall(){
		 //TODO possibilité de passer d'un coté à l'autre ?
		 //Création des bords, de largeur 5
		 this.muraille = new Mur(0+5,this.longeur/2,5,this.longeur/2);
		 Mur.addMur(muraille, new Mur(this.largeur-5,this.longeur/2,5,this.longeur/2));
		 Mur.addMur(muraille, new Mur(this.largeur/2,0+5,this.largeur/2,5));
		 Mur.addMur(muraille, new Mur(this.largeur/2,this.longeur-5,this.largeur/2,5));
		 for(int x = 0;x<lar+1;x++) {
			 this.coord[x][0] = 2;
			 this.coord[x][lon] = 2;
			 this.muraille = Mur.addMur(this.muraille, new Mur(x*(largeur/lar),0*(longeur/lon),(longeur/lon)/2,(longeur/lon)/2));
			 this.muraille = Mur.addMur(this.muraille, new Mur(x*(largeur/lar),lon*(longeur/lon),(longeur/lon)/2,(longeur/lon)/2));
		 }
		 for(int y = 0;y<lar+1;y++) {
			 this.coord[0][y] = 2;
			 this.coord[lar][y] = 2;
			 this.muraille = Mur.addMur(this.muraille, new Mur(0*(largeur/lar),y*(longeur/lon),(longeur/lon)/2,(longeur/lon)/2));
			 this.muraille = Mur.addMur(this.muraille, new Mur(lar*(largeur/lar),y*(longeur/lon),(longeur/lon)/2,(longeur/lon)/2));
		 }
		
		 //teste de création de murs
		 
		int taillex = (int) (0.1*Main.WIN_WIDTH);
		int tailley = (int) (0.1*Main.WIN_HEIGHT);
		
		
		//TODO coord[(x/Lain.WIDTH)*longueur]
		//TODO Display wall  constrcu  = milieux ->a changer
		for(int x = 2;x<lar-2;x = x+2) {
			for(int y = 2;y<lon-2;y = y+2) {
				if(Main.random.nextInt(10)<5){
					 this.muraille = Mur.addMur(this.muraille, new Mur(x*(largeur/lar),y*(longeur/lon),(longeur/lon),(longeur/lon)));
					 //taillex = Main.random.nextInt(this.largeur-x)/6 + 20;
					 this.coord[x][y] = 2;
				  	}
			}
		}
		/* for (int x =taillex+Main.taille;x<this.largeur-taillex-Main.taille;x = x+2*taillex){
			  for (int y=3*Main.taille+Main.taille;y<this.longeur;y = y+4*Main.taille){
				  	if(Main.random.nextInt(10)<7){
					 this.muraille = Mur.addMur(this.muraille, new Mur(x,y,taillex-Main.taille-1,Main.taille));
					 //taillex = Main.random.nextInt(this.largeur-x)/6 + 20;
				  	}
				  	
				  
					  	
				  
				  
			  }
		 }
		 // longueur des mrus verticaux
		 //création des murs verticaux
		 for (int y = tailley+Main.taille;y<this.longeur-tailley-Main.taille;y = y+2*tailley){
			  for (int x=3*Main.taille+Main.taille;x<this.longeur-Main.taille-Main.taille;x = x+2*taillex+4*Main.taille){
				  if (Main.random.nextInt(10)<7){
					 this.muraille = Mur.addMur(this.muraille, new Mur(x,y,Main.taille,tailley-Main.taille-1));
					 //tailley = Main.random.nextInt(this.largeur -y)/6 + 10;
				  }
					 
				  
			  }
		 } */
			  

		 /* Mur wall = this.muraille;
		  //Impression des murs sur  la carte
			  while(wall!=null){
			 
			  for (int a = wall.x-wall.large;a<=wall.x+wall.large;a++){
				  for (int b = wall.y-wall.longe;b<=wall.y+wall.longe;b++){
					  
					  this.coord[a][b] = 2;
				  }
				  
			  }
			 
				  wall =  wall.suivant;
		  }*/
		 
	 }
	 public void generatecookie(){
		 this.listcookie = new Cookie(this.xBSpawn,this.yBSpawn);
		 int x,y;
		 for(int k=0;k<this.nbcookies-1;k++){
			 x = Main.random.nextInt(Main.WIN_WIDTH-10)+5;
			 y = Main.random.nextInt(Main.WIN_WIDTH-10)+5;
			 while(this.coord[x][y]!=0){
				 x = Main.random.nextInt(Main.WIN_WIDTH-10)+5;
				 y = Main.random.nextInt(Main.WIN_WIDTH-10)+5;
			 }
			 this.listcookie.suivant = new Cookie(x,y);
			 this.coord[x][y] = 1;
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
			 perso.vie = perso.vie-1;
			 Main.init(map);		
			 
			 
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
	            		this.coord[i][j] =2;
	            	StdDraw.setPenColor(StdDraw.GRAY);
	       	    	 StdDraw.filledRectangle(Main.WIN_WIDTH/19 *i,Main.WIN_HEIGHT/19*j,Main.WIN_WIDTH/40,Main.WIN_WIDTH/40);
	            	}else{
	            		this.coord[i][j] =1;
	            	}
	            	
	            }
	            	
	            
	        }

	       
	    }
	  
	 
	 
}
