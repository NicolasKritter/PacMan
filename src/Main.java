
import java.awt.event.KeyEvent;
import java.util.List;
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
	    static Button btnjouer;
	    static Button btncredit;
	    static Button btnscore;
	    static Button btnChnom;
	    static Button btnsaveScore;
	    static Button btnMenujouer;
	    static Button btnretour;
	    static ScoreSheet fscore;
	    
	    
	    public static void menuPrincipal(){
	    	boolean menu = true;
	    	StdDraw.clear(StdDraw.BLACK);
	    	 StdDraw.setPenColor(StdDraw.BLUE);
	    	 //titre
	    	 StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/(1.3), "PACMAN");
	    	 //Bouton play

	    	 btnjouer.dessiner();
	    	 //bouton scores
	    	 btnscore.dessiner();
	    	 
	    	//bouton changer de nom
	    	 btnChnom.dessiner();
	    	 
	    	 //bouton crédit
	    	 btncredit.dessiner();
	    	 
	    	 //bouton 2 joueurs ?
	    	 while(menu){
	    		 if(btnjouer.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;
		    		 }
	    		 }
	    		 
	    		 if(btnscore.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;
		    			 menuNom();
		    		 }
	    		 }
	    		 
	    		 if(btnChnom.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;
		    			 menuNom();
		    		 }
	    		 }
	    		 
	    		 if(btncredit.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;
		    			 credit();
		    		 }
	    		 }
	    	 
	    	 
	    	 
	    	 }
	    	
	    }
	    public static String getScore(boolean all){
	    	//liste de score
	    	
	    	if(all){
	    		return "a";
	    	}
	    	else{
	    		return "a" ;
	    	}
	    	
	    }
	    public static void sauverScore(){
	    	
	    }
	    public static void menuNom(){
	    	boolean menu = true;
	    	StdDraw.clear(StdDraw.BLACK);
	    	 StdDraw.setPenColor(StdDraw.BLUE);
	    	 btnretour.dessiner();
	    	 while(menu){
	    		 if(btnretour.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;	
		    			 menuPrincipal();
	    			 }
	    		 }
	    		 
	    	 }
	    	
	    }
	    public static void credit(){
	    	boolean menu = true;
	    	StdDraw.clear(StdDraw.BLACK);
	    	 StdDraw.setPenColor(StdDraw.BLUE);
	    	 btnretour.dessiner();
	    	 while(menu){
	    		 if(btnretour.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;	
		    			 menuPrincipal();
	    			 }
	    		 }
	    		 
	    	 }
	    }
	    public static void fin(){
	    	StdDraw.clear(StdDraw.BLACK);
	    	
	    	
	    	StdDraw.setPenColor(StdDraw.WHITE);
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/2,player.name+": "+player.vie+" vie(s) & Score: "+player.score);
    		btnsaveScore.dessiner();
    		btnMenujouer.dessiner();
    		btnretour.dessiner();
    		boolean menu = true;	
	    	while(menu){
	    		
	    		if(btnMenujouer.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;		    	    		
		    			 map = new Map();
		    	    		player.vie = 3;
		    	    		player.score = 0;
		    	    		init();
		    		 }
	    		 }
	    		
	    		if(btnsaveScore.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;
		    			 sauverScore();
		    		 }
	    		 }
	    		 if(btnretour.hoovered){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;	
		    			 menuPrincipal();
	    			 }
	    		 }
	    		
	    	}
	    		
	    	
	    }
	    //TODO  Utiliser la fonction Init pour la première partie ?
	    //TOD0 refaire le ini plus propre
	    public  static void init(){
	    	 StdDraw.clear(StdDraw.BLACK);
	    	 StdDraw.setPenColor(StdDraw.WHITE);
	    	
	    	//Affiche  le nombre de vie restante
	    	 StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/2,player.name+": "+player.vie+" vie(s)");
        	 StdDraw.show();
        	 StdDraw.pause(3000);
        	 //On affiche le bandeau vie et score (du haut)
             StdDraw.clear(StdDraw.BLACK);
             StdDraw.setPenColor(StdDraw.WHITE);
             StdDraw.text(WIN_WIDTH/3, WIN_HEIGHT-Main.taille,"Vie(s): "+player.vie);
           	 StdDraw.text(WIN_WIDTH/(1.5), WIN_HEIGHT-Main.taille,"Score: "+player.score);
           	//Réaffiche les murs
             afficherMur(map.listemur);
             //TODO récupperer les coockies restant et les afficher
            
             //On replace les personnages à leur endroit de spawn
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

	    

	    
	 // Afficher les perso selon leur coulerus
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
	    //effacer un personnage ou un cookie
	    public static void effaceur(double x, double y, double taille){
	    	StdDraw.setPenColor(StdDraw.BLACK);
	    	StdDraw.filledCircle(x,y,taille+1);
	    }
	  // afficher murs
	    public static void afficherMur(Mur listemur){
	    	
	    	Mur mur = listemur;
	    	//parcour la liste chaînée des murs et on les dessines
	        while(mur!=null){

	        	StdDraw.setPenColor(StdDraw.BLUE);
		    	StdDraw.rectangle(mur.x,mur.y,mur.large-1,mur.longe-1);
		    	mur = mur.suivant;
	        }
	    	
	    	 
	    	 
	    }
	    public static void afficherCookie(Cookie listecookie){
	    	Cookie cookie = listecookie;
	    	//System.out.println("--------------------");
	    	int k = 0;
	    	//parcour la liste chaînée des cookies
	        while(cookie!=null){
	        	//on les dessines que si ils ont l'attribut visible
	       	 if(cookie.visible==null){
		    	 StdDraw.setPenColor(StdDraw.WHITE);
		    	 StdDraw.filledCircle(cookie.x,cookie.y,cookie.taille);
	       	 }
	       	 k = k+1;
	      
	        	cookie = cookie.suivant;
	        }
	        //System.out.println("-------------------- " +k);

	    	 
	    }
	   
	    //TODO mettre des images
	    //TODO faire menu
	    //TODO stocker les scores
	    //TODO afficher pause ?
	    //TODO IA
	public  static void main(String[] args)  {
		//controle
		 boolean play = true;
	     int pause = 0;
	     ScoreSheet.init();
	     fscore = new ScoreSheet();
	     
	     
	    //Jeux
		  map = new Map();
	     player = new Joueur(map.xStart,map.yStart,-1,"Joueur");
	     red = new Ghost(map.xRSpawn, map.yRSpawn, 1,"red");
	     blue = new Ghost(map.xBSpawn, map.yBSpawn, 3,"blue");
	     pink = new Ghost(map.xPSpawn, map.yPSpawn, 0,"pink");
	     orange = new Ghost(map.xOSpawn, map.yOSpawn, 2,"orange");
	     
	     //Boutons
	     btnjouer = new Button(WIN_WIDTH/2,WIN_HEIGHT/2,80,20,"Play");
		 btnscore = new Button(btnjouer.x,btnjouer.y-2*btnjouer.height-30,80,20,"Score");
	     btnChnom = new Button(btnscore.x,btnscore.y-2*btnscore.height-30,80,20,"Changer de nom");
	     btncredit = new Button(btnChnom.x,btnChnom.y-2*btnChnom.height-30,80,20,"Credits");
	     
	     
 		 btnsaveScore = new Button(WIN_WIDTH/2,WIN_HEIGHT/3,80,20,"Sauver le Score");
 		 btnMenujouer = new Button(WIN_WIDTH/2,WIN_HEIGHT/4,80,20,"Re jouer");
 		 btnretour = new Button(100,50,80,20,"retour");
 		
	     Ghost[] listGhost= {red,blue,pink,orange};

 		
		//TODO Text field nom
	    

		//Génère la grille de la  fenètre
		StdDraw.setXscale(0, WIN_WIDTH);
        StdDraw.setYscale(0, WIN_HEIGHT);
        
        menuPrincipal();
      
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
   	 
   	 
    //TODO fonction jouer
   	 
        while(true){
        	
        	
        	//gestion du jeux
	        if(play){
	        	//affiche les cookies
	        	afficherCookie(map.listcookie);
	        	//éviter la répétition lorsque que la touche P est pressée
	        	if (pause>1){
		        	pause -= 1;
		        	}else{
		        		pause=0;
		        	}
	        	
	        	
	        	 
	        	 // Changement de direction avec les flèches
	        	 if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
	        		 //la prochaine direction sera vers le haut
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
	            	 //si la prochaine direction est libre, on la prend
	            	 
	            	 player.dir =  player.buffer;
	            	 
	             }
	            
	                        
	             for (Ghost ghost: listGhost){  
	            	//TODO chek hit wall fantome: fantome pas choisir trop souvent le retour en arriere ?
	            	 //Le fantome choisis sa prochaine direction si il suit l'ancienne 1 fois sur 200
	            	 if(random.nextInt(200)==5 &&  ghost.buffer ==  ghost.dir){
	            		 ghost.buffer = random.nextInt(4);
	            		/* while(Math.abs( ghost.buffer -  ghost.dir)==2){
	            			 ghost.buffer = random.nextInt(4);
	            		 }*/
	            	 }
	            	 if(!ghost.checkhitwall(map, ghost.buffer)){
	            		 //si sa prochaine direction est libre, le fantome la prend
	            		 ghost.dir = ghost.buffer;
	            		 //On change sa prochaine direction
	            		
	            		 while(ghost.buffer==ghost.dir ){
	            			 ghost.buffer = random.nextInt(4);
	            		 }
	            		
		             }
	            	 ghost.move();
	            	 
	            	 if(ghost.checkhitwall(map)){
	            		 //si il touche un mur, on le fait rebondir
	            		 ghost.bounchehitwall(map);
	            	 }
	            	 map.checkhitghost(player, ghost);
	            		 
	            	 
	            	
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
	        	//Pour éviter la répétition de l'inversion play pause on met un timer avant 
	        	//de pouvoir réactiver la touche P
	        	if (pause>1 ){
	        	pause -= 1;
	        	}else{
	        		pause=0;
	        	}
	        	
	        	StdDraw.pause(100);
	        	
	        	
	        }
	        
	        if (StdDraw.isKeyPressed(KeyEvent.VK_P) && pause==0) {
	        	
	        	pause = 10;
	        	play = !play;
	       	 
	        }
	        	
        }

	}

}
