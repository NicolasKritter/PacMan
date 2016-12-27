
import java.awt.event.KeyEvent;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;


public class Main {
		static Random random = new Random(System.currentTimeMillis());
		
	
		//Display
	 	public final static int WIN_WIDTH= 640;
	    public final static int WIN_HEIGHT= 640;
	    public final static int FPS= 1000;
	    static double STEP= 1.5;
	    static Joueur player;
	    static Ghost red;
	    static Ghost blue;
	    static Ghost pink;
	    static Ghost orange;
	    static Map map;
	    static int taille = 10;
	    
	    //TODO Init fonction	
	    public  static void init(){
	    	player.x = map.xStart;
	    	player.y = map.yStart;
	    	red.x = map.xRSpawn;
	    	red.y = map.yRSpawn;
	    	blue.x = map.xBSpawn;
	    	blue.y = map.yBSpawn;
	    	pink.x = map.xPSpawn;
	    	pink.y = map.yPSpawn;
	    	orange.x = map.xOSpawn;
	    	orange.y = map.yOSpawn;
	    	map.generateCoockie(map);
	    }
	    // Nommer le perso
	    public  void creerPerso(Perso perso,String nom){
	    	perso.name = nom;
	    }
	    //TODO Display Score
	    // Afficher les perso
	    public static void afficherPerso(Perso perso){
	    	switch (perso.name){
	    	case "blue":
	    		 StdDraw.setPenColor(StdDraw.BLUE);
	    		 break;
	    	case "red":
	    		 StdDraw.setPenColor(StdDraw.RED);
	    		 break;
	    	case "pink":
	    		 StdDraw.setPenColor(StdDraw.PINK);
	    		 break;
	    	case "orange":
	    		 StdDraw.setPenColor(StdDraw.ORANGE);
	    		 break;
	    	default:
	    		 StdDraw.setPenColor(StdDraw.YELLOW);
	    		 break;
	    	}
	    	StdDraw.filledCircle(perso.x,perso.y,taille);
	    }
	  //TODO afficher murs
	    public static void afficherMur(Mur mur){
	    	 StdDraw.setPenColor(StdDraw.GRAY);
	    	 StdDraw.filledRectangle(mur.x,mur.y,mur.large,mur.longe);
	    	 
	    }
	   
	    //TODO afficher coockies
	public  static void main(String[] args) {
		//controle
		 boolean play = true;
	     int pause = 0;
	    //Jeux
		 Map map = new Map();
	     player = new Joueur(map.xStart,map.yStart,-1,"Joueur");
	     red = new Ghost(map.xRSpawn, map.yRSpawn, random.nextInt(3),"red");
	     blue = new Ghost(map.xBSpawn, map.yBSpawn, random.nextInt(3),"blue");
	     pink = new Ghost(map.xPSpawn, map.yPSpawn, random.nextInt(4),"pink");
	     orange = new Ghost(map.xOSpawn, map.yOSpawn, random.nextInt(3),"orange");
	     Ghost[] listGhost= {red,blue,pink,orange};
	     
	    
		//TODO Ecran Menu
		//TODO Bouton Play
		//TODO Text field nom
	     
		//TODO generer labyrinthe
		//TODO generer coockie;

		//Génère la grille de la  fenètre
		StdDraw.setXscale(0, WIN_WIDTH);
        StdDraw.setYscale(0, WIN_HEIGHT);
        while(true){
        	
        	
        	//gestion du jeux
	        if(play){
	        	
	        	pause = 0;
	        	 //StdDraw.clear(StdDraw.BLACK);
	        	 StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/8,"(x,y): "+player.vie);
	        	 
	        	 // Changement de direction avec les flèches
	        	 if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
	                 player.dir = 0;
	             }
	             if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
	            	 player.dir = 1;
	             }
	             if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
	            	 player.dir = 2;
	             }
	             if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
	            	 player.dir = 3;
	             }
	             //Afficher tous les murs
	             for (Mur mur: map.listmur){
	            	 afficherMur(mur);
	             }
	             
	            
	             for (Ghost ghost: listGhost){  
	            	//TODO check collision wall
	            	 map.checkhitghost(player, ghost);
	            	 map.checkhitwall(ghost,map);
	            	 Perso.move(ghost);
	            	 afficherPerso(ghost);
	            	  
	             }
	             Perso.move(player);
	             map.checkhitwall(player,map);
	             
	             afficherPerso(player);
	             //Affichage du jeux
	            
	             StdDraw.show(10000/FPS);
	             
	        }
	        else{
	        	StdDraw.pause(1);
	        	pause = 0;
	        	
	        }
	        
	        if (StdDraw.isKeyPressed(KeyEvent.VK_P) && pause==0) {
	        	pause = 1;
	        	play = !play;
	       	 
	        }
	        	
        }

	}

}
