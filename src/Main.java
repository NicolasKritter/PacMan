
import java.awt.event.KeyEvent;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;


public class Main {
		static Random random = new Random(System.currentTimeMillis());
		
	
		//Display
	 	static int WIN_WIDTH= 640;
	    static int WIN_HEIGHT= 640;
	    static int FPS= 1000;
	    static double STEP= 1.5;
	    static Joueur player;
	    static Ghost red;
	    static Ghost blue;
	    static Ghost pink;
	    static Ghost orange;
	    static Map map;
	    static int taille = 10;
	    
	    //TODO  Utiliser la fonction Init pour la première partie ?
	    public  static void init(Map map){
	    	 StdDraw.clear(StdDraw.BLACK);
	    	 StdDraw.setPenColor(StdDraw.WHITE);
	    	if (player.vie<1){
	    		player.vie = 3;
	    		map = new Map();
	    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/2,player.name+": "+player.vie+" vie(s)");
	    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/3,"PACMAN 2.0 \n Début dans 5 sec \n Nicolas Kritter Eliott Vanacker");
	    	}
	    	StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/2,player.name+": "+player.vie+" vie(s)");
        	 StdDraw.show();
        	 StdDraw.pause(3000);
             StdDraw.clear(StdDraw.BLACK);
           	
           	Mur courant = map.muraille;
            while(courant!=null){
           	 afficherMur(courant);
           	 courant = courant.suivant;
            }
	    	player.x = map.xStart;
	    	player.y = map.yStart;
	    	player.buffer = -1;
	    	player.dir = -1;
	    	red.x = map.xRSpawn;
	    	red.y = map.yRSpawn;
	    	blue.x = map.xBSpawn;
	    	blue.y = map.yBSpawn;
	    	pink.x = map.xPSpawn;
	    	pink.y = map.yPSpawn;
	    	orange.x = map.xOSpawn;
	    	orange.y = map.yOSpawn;
	    	
	    }
	    // Nommer le perso
	    public  void creerPerso(Perso perso,String nom){
	    	perso.name = nom;
	    }
	    
	    
	    
	    //TODO faire un clear que sur les persos (fonction dispblack)
	    
	    //TODO Display Score
	    // Afficher les perso
	    public static void afficherPerso(Perso perso){
	    	StdDraw.setPenColor(StdDraw.RED);
	    	StdDraw.filledCircle(perso.x,perso.y,perso.taille+STEP);
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
	    	StdDraw.filledCircle(perso.x,perso.y,perso.taille);
	    	
	    }
	    public static void effaceur(double x, double y, double taille){
	    	StdDraw.setPenColor(StdDraw.BLACK);
	    	StdDraw.filledCircle(x,y,taille+1);
	    }
	  //TODO afficher murs
	    public static void afficherMur(Mur mur){
	    	 StdDraw.setPenColor(StdDraw.GRAY);
	    	 StdDraw.filledRectangle(mur.x,mur.y,mur.large,mur.longe);
	    	 
	    }
	    public static void affichercookie(Cookie cookie){
	    	 StdDraw.setPenColor(StdDraw.WHITE);
	    	 StdDraw.filledCircle(cookie.x,cookie.y,cookie.taille);
	    	 
	    }
	   
	    //TODO afficher cookies
	public  static void main(String[] args) {
		//controle
		 boolean play = true;
	     int pause = 0;
	    //Jeux
		 Map map = new Map();
	     player = new Joueur(map.xStart,map.yStart,-1,"Joueur");
	     red = new Ghost(map.xRSpawn, map.yRSpawn, 1,"red");
	     blue = new Ghost(map.xBSpawn, map.yBSpawn, 3,"blue");
	     pink = new Ghost(map.xPSpawn, map.yPSpawn, 0,"pink");
	     orange = new Ghost(map.xOSpawn, map.yOSpawn, 2,"orange");
	     Ghost[] listGhost= {red,blue,pink,orange};

 		
		//TODO Ecran Menu
		//TODO Bouton Play
		//TODO Text field nom
	     
		
		//TODO generer cookie;

		//Génère la grille de la  fenètre
		StdDraw.setXscale(0, WIN_WIDTH);
        StdDraw.setYscale(0, WIN_HEIGHT);
        
        

        
        
        
        
        while(pause==12){
        	StdDraw.clear(StdDraw.BLACK);
       	 StdDraw.setPenColor(StdDraw.BLACK);
        	map.printLabyrinthe(map.carte);
        	StdDraw.show(10000/FPS);
        }
        

        
        /*
         * 
         * 
         * 
         * 
         */
     StdDraw.clear(StdDraw.BLACK);
   	 StdDraw.setPenColor(StdDraw.BLACK);
   	Mur courant = map.muraille;
    while(courant!=null){
   	 afficherMur(courant);
   	 courant = courant.suivant;
    }
   	 int buffer = 0;
        while(pause==0){
        	 //StdDraw.clear(StdDraw.BLACK);
        	 //StdDraw.setPenColor(StdDraw.BLACK);
        	
        	//gestion du jeux
	        if(play){
	        	
	        	if (pause>1){
		        	pause -= 1;
		        	}else{
		        		pause=0;
		        	}
	        	
	        	
	        	 
	        	 // Changement de direction avec les flèches
	        	 if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
	                 player.buffer = 0;
	             }
	             if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
	            	 player.buffer = 1;
	             }
	             if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
	            	 player.buffer = 2;
	             }
	             if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
	            	 player.buffer = 3;
	             }
	             
	             
	             //TODO supprimer les coockies sur la map et les effacer
	           //Afficher tous les cookies
	            /* Cookie courantcookie = map.listcookie;
	             while(courantcookie!=null){
	            	 
	            	 affichercookie(courantcookie);
	            	 
	            	 courantcookie = courantcookie.suivant;
	             }*/
	           //Afficher tous les murs
	            /*Mur courant = map.muraille;
	             while(courant!=null){
	            	 afficherMur(courant);
	            	 courant = courant.suivant;
	             }*/

	             
	            
	             for (Ghost ghost: listGhost){  
	            	
	            	 
	            	 if(random.nextInt(10)==5 &&  ghost.buffer ==  ghost.dir){
	            		 ghost.buffer = random.nextInt(4);
	            	 }
	            	 if(!ghost.checkhitwall(map, buffer)){
	            		 ghost.dir = buffer;
		             }
	            	 if(ghost.checkhitwall(map)){
	            		 ghost.bounchehitwall(map);
	            	 }
	            	 //map.checkhitghost(player, ghost,map);
	            		 Perso.move(ghost);
	            	 
	            	
	            	System.out.println("test: "+player.checkhitwall(map,  player.buffer)+" reel test: "+player.checkhitwall(map));
	            	 afficherPerso(ghost);
	            	  
	             }
	             

	             if(!player.checkhitwall(map,  player.buffer)){
	            	 
	            	 player.dir =  player.buffer;
	             }
	             Perso.move(player);
			        if(player.checkhitwall(map)){
		            	 //player.hitwall();
		             }
	            	 

	            	 
	             
	             
	             afficherPerso(player);
	             //Affichage du jeux
	             StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-30,"Vie: "+player.vie);
	        	 StdDraw.text(WIN_WIDTH/2, 30,"Score: "+player.score);
	             StdDraw.show(10000/FPS);
	             
	        }
	        else{
	        	if (pause>1){
	        	pause -= 1;
	        	}else{
	        		pause=0;
	        	}
	        	
	        	StdDraw.pause(10);
	        	
	        	
	        }
	        
	        if (StdDraw.isKeyPressed(KeyEvent.VK_P) && pause==0) {
	        	pause = 10;
	        	play = !play;
	       	 
	        }
	        	
        }

	}

}
