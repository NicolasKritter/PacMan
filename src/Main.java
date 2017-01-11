
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
	    
	    
	    public static void menuPrincipal(){
	    	
	    }
	    public static void sauverScore(){
	    	
	    }
	    public static void menuNom(){
	    	
	    }
	    public static void credit(){
	    	
	    }
	    //TODO  Utiliser la fonction Init pour la première partie ?
	    public  static void init(Map map){
	    	 StdDraw.clear(StdDraw.BLACK);
	    	 StdDraw.setPenColor(StdDraw.WHITE);
	    	if (player.vie<1){
	    		player.vie = 3;
	    		map = new Map();
	    		StdDraw.setPenColor(StdDraw.WHITE);
	    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/2,player.name+": "+player.vie+" vie(s)");
	    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/3,"PACMAN 2.0 \n Début dans 5 sec \n Nicolas Kritter Eliott Vanacker");
	    	}
	    	
	    	 StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/2,player.name+": "+player.vie+" vie(s)");
        	 StdDraw.show();
        	 StdDraw.pause(3000);
             StdDraw.clear(StdDraw.BLACK);
             StdDraw.setPenColor(StdDraw.WHITE);
             StdDraw.text(WIN_WIDTH/3, WIN_HEIGHT-Main.taille,"Vie(s): "+player.vie);
           	 StdDraw.text(WIN_WIDTH/(1.5), WIN_HEIGHT-Main.taille,"Score: "+player.score);
           	
             afficherMur(map.listemur);
             //TODO récupperer les coockies restant et les afficher
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
	   public static void refreshScore(){
	   StdDraw.setPenColor(StdDraw.BLACK);
	    	 StdDraw.text(WIN_WIDTH/(1.5), WIN_HEIGHT-Main.taille,"Score: "+(player.score-2));
	    	 StdDraw.rectangle(WIN_WIDTH/(1.5), WIN_HEIGHT-Main.taille, Main.taille/2, Main.taille/2);
	    	 StdDraw.setPenColor(StdDraw.WHITE);
	    	 StdDraw.text(WIN_WIDTH/(1.5), WIN_HEIGHT-Main.taille,"Score: "+(player.score));
	    	 
	    	 
	    	
	    }

	    

	    
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
	    	StdDraw.filledCircle(perso.x,perso.y,perso.taille);
	    	
	    }
	    public static void effaceur(double x, double y, double taille){
	    	StdDraw.setPenColor(StdDraw.BLACK);
	    	StdDraw.filledCircle(x,y,taille+1);
	    }
	  // afficher murs
	    public static void afficherMur(Mur listemur){
	    	
	    	Mur mur = listemur;
	        while(mur!=null){

	        		StdDraw.setPenColor(StdDraw.BLUE);
		    	 StdDraw.rectangle(mur.x,mur.y,mur.large-1,mur.longe-1);
		    	 mur = mur.suivant;
	        }
	    	
	    	 
	    	 
	    }
	    public static void afficherCookie(Cookie listecookie){
	    	Cookie cookie = listecookie;
	    	System.out.println("--------------------");
	    	int k = 0;
	        while(cookie!=null){
	       	 if(cookie.visible==null){
		    	 StdDraw.setPenColor(StdDraw.WHITE);
		    	 StdDraw.filledCircle(cookie.x,cookie.y,cookie.taille);
	       	 }
	       	 k = k+1;
	      
	        	cookie = cookie.suivant;
	        }
	        System.out.println("-------------------- " +k);

	    	 
	    }
	   
	    //TODO mettre des images
	    //TODO faire menu
	    //TODO stocker les scores
	    //TODO afficher pause
	    //TODO IA
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
	     

		//Génère la grille de la  fenètre
		StdDraw.setXscale(0, WIN_WIDTH);
        StdDraw.setYscale(0, WIN_HEIGHT);
        
        

        
        
        
        
        
        
        
        
        /*
         * 
         * 
         * 
         * 
         */
     StdDraw.clear(StdDraw.BLACK);
     
    
	 
	 
	 //Afficher tous les murs
	 afficherMur(map.listemur);
   	 //Afficher tous les coockies
   	 afficherCookie(map.listcookie);
   	 StdDraw.setPenColor(StdDraw.WHITE);
   	 StdDraw.text(WIN_WIDTH/3, WIN_HEIGHT-Main.taille,"Vie(s): "+player.vie);
	 StdDraw.text(WIN_WIDTH/(1.5), WIN_HEIGHT-Main.taille,"Score: "+player.score);
   	 
   	 
    
   	 
        while(true){

        	
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
	             
	             if(!player.checkhitwall(map,  player.buffer)){
	            	 
	            	 player.dir =  player.buffer;
	            	 
	             }


	             afficherCookie(map.listcookie);
	             
	            
	             for (Ghost ghost: listGhost){  
	            	
	            	 
	            	 if(random.nextInt(200)==5 &&  ghost.buffer ==  ghost.dir){
	            		 ghost.buffer = random.nextInt(4);
	            	 }
	            	 if(!ghost.checkhitwall(map, ghost.buffer)){
	            		 ghost.dir = ghost.buffer;
	            		 ghost.buffer = random.nextInt(4);
		             }
	            	 ghost.move();
	            	 
	            	 if(ghost.checkhitwall(map)){
	            		 ghost.bounchehitwall(map);
	            	 }
	            	 map.checkhitghost(player, ghost,map);
	            		 
	            	 
	            	
	            	 afficherPerso(ghost);
	            	  
	             }
	             
	             //TODO mettre les coockie dans un tableau mettre fonction delete coockie avec this

	               player.move();
	             player.checkhitcookie(map);
	             if(!player.checkhitwall(map)){
	            	 //player.hitwall();
	            	
	             }  
	             
			        
	             	 
	             
	             //TODO combiner les check ?
	            
	             
	             afficherPerso(player);
	             //Affichage du jeux
	             
	             
	             
	             StdDraw.show(10000/FPS);
	             
	        }
	        else{
	        	
	        	if (pause>1 ){
	        	pause -= 1;
	        	}else{
	        		pause=0;
	        	}
	        	
	        	StdDraw.pause(100);
	        	
	        	
	        }
	        
	        if (StdDraw.isKeyPressed(KeyEvent.VK_P) && pause==0) {
	        	//
	        	//KeyEvent.KEY_RELEASED==KeyEvent.VK_P
	        	pause = 10;
	        	play = !play;
	       	 
	        }
	        	
        }

	}

}
