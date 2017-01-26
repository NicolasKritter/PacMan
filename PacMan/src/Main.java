
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;


public class Main {
		static Random random = new Random(System.currentTimeMillis());
		//TODO Score
		//TODO multi
		//TODO centrage
		//TODO uml
		//TODO livrable
		//TODO animation ?
		//Display
	 	static int WIN_WIDTH= 640;
	    static int WIN_HEIGHT= 640;
	    static int FPS= 1000;
	    static double STEP= 2;
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
	    static Button btnrename;
	    static EditText editnom;
	    static ScoreSheet fscore;
	    static int duree;
	    //chemin du dossieur feuille de score
	    static String cheminFeuilleDeScore = "GameData/Score/scoreSheet.csv";
	    //chemin du dossier image
	    static String dossierImage = "GameData/Images/";
	    
	    //font pour les titres et titre principal
	    static Font fontTitrePrincipal = new Font("Georgia", Font.BOLD, 60);
	    static Font fontTitre = new Font("Georgia", Font.BOLD, 30);
	    

	    public static void menuPrincipal(){
	    	boolean menu = true;
	    	StdDraw.clear(StdDraw.BLACK);
	    	 StdDraw.setPenColor(StdDraw.YELLOW);
	    	 //titre
	    	 StdDraw.setFont(fontTitrePrincipal);
	    	 StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/(1.3), "Pacman");
	    	 StdDraw.setFont();
	    	 
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
		    			 menuScore();
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
	    public static void AfficherScore(List<String> scorelist){
	    	//Position de départ d'affichage
	    	int y = WIN_WIDTH-200;
	    	int x = WIN_HEIGHT/2;
	    	int k = 0;
	    	
	    	StdDraw.setPenColor(StdDraw.WHITE);
	    	if (scorelist!=null){
	    		//parcoure la liste des scores ligne par ligne
		    	for (String txt: scorelist){
		    		StdDraw.text(x, y+k, txt);
		    		//crée l'écart entre les lignes
		    		k = k+30;
		    		
		    	}
	    	}
	    	//Ajout d'un cadre
	    	StdDraw.setPenColor(StdDraw.BLUE);
	    	StdDraw.rectangle(WIN_WIDTH/2, WIN_HEIGHT/2-40, 100, 200);
	    	StdDraw.show();
	    	
	    }


	    public static void menuScore(){
	    	boolean menu = true;
	    	
	    	StdDraw.clear(StdDraw.BLACK);
	    	StdDraw.setPenColor(StdDraw.YELLOW);
	    	//change la police
	    	StdDraw.setFont(fontTitre);
	    	StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-70, "TOP 10 scores:");
	    	StdDraw.setFont();
	    	
	    	AfficherScore(fscore.scoresligne);
	    	btnretour.dessiner();
	    	btnMenujouer.dessiner();

	    	 while(menu){
	    		 if(btnMenujouer.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;
		    			 
		    		 }
	    		 }
	    		 if(btnretour.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;	
		    			 menuPrincipal();
	    			 }
	    		 }
	    		 
	    	 }
	    	
	    }
	    public static void menuNom(){
	    	boolean menu = true;

	    	StdDraw.clear(StdDraw.BLACK);
	    	 StdDraw.setPenColor(StdDraw.BLUE);
	    	//change la police
		    StdDraw.setFont(fontTitre);
		    StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-70, "Nouveau Nom:");
		    StdDraw.setFont();
		    StdDraw.setPenColor(StdDraw.YELLOW);
		    editnom.dessiner();

	    	 btnrename.dessiner();
	    	 btnretour.dessiner();
	    	 while(menu){
	    		 if(btnretour.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;	
		    			 menuPrincipal();
	    			 }
	    		 }else
	    		 if(btnrename.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;	
		    			 menuPrincipal();
		    			 //change le nom du perso
		    			 player.name = editnom.text;
	    			 }
	    		 }
	    		//lance le mode edition
	    		 editnom.writing();
	    		
	    		 
	    	 }
	    	
	    }
	    public static void credit(){
	    	boolean menu = true;
	    	StdDraw.clear(StdDraw.BLACK);
	    	 StdDraw.setPenColor(StdDraw.BLUE);
	    	 StdDraw.setFont(fontTitre);
			 StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-70, "Crédits");
			 StdDraw.setFont();
	    	 StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/1.2, "Images: https://pixabay.com/");
	    	 StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/2.2, "KRITTER Nicolas G6C ISEP");
	    	 StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/3.2, "VANACKER Eliott G7B ISEP");
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
	    	//calcul le temps qu'à durée la partie
	    	duree = (int) ((System.currentTimeMillis()/1000) - duree);
	    	StdDraw.setPenColor(StdDraw.YELLOW);
	    	StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-20, player.name);
	    	StdDraw.setPenColor(StdDraw.WHITE);
	    	StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-50, "Temps:"+duree+"s  => Bonus:"+(int)(300/duree));

    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-100,player.vie+" vie(s) restantes");
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-140,player.score+" "+(int)(300/duree)+" x "+player.vie);
	    	player.score = player.score+(int)(300/duree)*player.vie;
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-175,"Score Final: "+player.score);
    		btnsaveScore.dessiner();
    		btnMenujouer.dessiner();
    		btnretour.dessiner();
	    	AfficherScore(fscore.scoresligne);
    		boolean menu = true;	
	    	while(menu){
	    		
	    		if(btnMenujouer.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;		    	    		
		    			 
		    	    		
		    	    		init();
		    		 }
	    		 }
	    		
	    		if(btnsaveScore.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;
		    			 fscore.writeScore(player.name,player.score);
		    			 StdDraw.text(WIN_WIDTH-50, 0, "Fait");
		    			 StdDraw.show();
		    			 StdDraw.pause(1000);
		    			 menuScore();
		    		 }
	    		 }
	    		 if(btnretour.hoover()){
	    			 if(StdDraw.mousePressed()){
	    				 player.vie = 3;
		    	    	 player.score = 0;
		    			 menu = false;	
		    			 menuPrincipal();
	    			 }
	    		 }
	    		
	    	}

	    	
	    }
	    public static void panelJeux(){
	    	
	     StdDraw.clear(StdDraw.BLACK);
	   	 //Afficher tous les murs
	   	 afficherMur(map.listemur);
	     //Afficher tous les coockies
	     afficherCookie(map.listcookie);
	     //affiche les éléments du tableau de bord
	     StdDraw.setPenColor(StdDraw.YELLOW);
	     StdDraw.text(220, -16,player.name+":");
	     StdDraw.setPenColor(StdDraw.WHITE);
	     StdDraw.text(320, -4,"Vie(s): ");
	   	 StdDraw.text(320 , -30,"Score: "+player.score);
	   	 StdDraw.text(500, -30,"High Score: "+ fscore.getHighScore());
	   	 
	   	 for(int k = 0; k<player.vie;k++){
	   		 StdDraw.picture(365+25*k, -4,dossierImage+"vie.png", 25, 25);
	   	 }
	   	 btnretour.dessiner();
	   	if(player.vie>2){
	    	duree = (int)(System.currentTimeMillis()/1000);
	    	}
	    }
/*	    public static void superCookie(){
			 for(int n= 0; n< 4; n++){
				 coordcookie[random.nextInt(lar)][random.nextInt(lar)] = superCookie;
			 }
	    }
*/	    
	    public  static void init(){
	    	// reinit a la mort
	    	if (player.vie<1){
	    		player.vie = 3;
	    		player.score = 0;
	    		map = new Map();
	    	}
	    	//Affiche  le nombre de vie restante
	    	 StdDraw.clear(StdDraw.BLACK);
	    	 StdDraw.setPenColor(StdDraw.WHITE);
	    	 StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/2,player.name+": "+player.vie+" vie(s)");
	    	 
	    	 //affiche et pause pendant 3 secondes
	    	 StdDraw.show(3000);
	    	 //nécessaire pour ne pas passer à l'affichage suivant 
	    	 //avant la fin de la pause
	    	 StdDraw.pause(0);
        	
	    	 //réaffiche le panel pour le jeu
	    	 panelJeux();
           
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
	    
	   public static void refreshScore(){
	   StdDraw.setPenColor(StdDraw.BLACK);
	    	 
	    	 StdDraw.filledRectangle(320 , -30, 50, 15);
	    	 StdDraw.setPenColor(StdDraw.WHITE);
	    	 StdDraw.text(320 , -30,"Score: "+player.score);
	    	 
	    	 
	    	
	    }
	    
	  // afficher murs
	    public static void afficherMur(Mur listemur){
	    	
	    	Mur mur = listemur;
	    	 StdDraw.setPenColor(StdDraw.BLUE);
	    	StdDraw.rectangle(WIN_WIDTH/2, WIN_HEIGHT/2, WIN_WIDTH/2-15, WIN_HEIGHT/2-15);
	    	//parcour la liste chaînée des murs et on les dessines
	        while(mur!=null){
	        		
	        	//StdDraw.setPenColor(StdDraw.BLUE);
	        	StdDraw.picture(mur.x, mur.y, Main.dossierImage+"mur.jpg",2*mur.large,2*mur.longe);
		    	mur = mur.suivant;
	        }
	    	
	    	 
	    	 
	    }
	    public static void afficherCookie(Cookie listecookie){
	    	Cookie cookie = listecookie;
	    	//parcour la liste chaînée des cookies et dessine les cookies
	        while(cookie!=null){
	        	if (!cookie.bonus){
	        		StdDraw.picture(cookie.x, cookie.y, Main.dossierImage+"cookie.png",cookie.taille,cookie.taille);
	        	}
	        	else{
	        		StdDraw.picture(cookie.x, cookie.y, Main.dossierImage+"bonus.png",cookie.taille,cookie.taille);

	        	}
	       	 

	      
	        	cookie = cookie.suivant;
	        }


	    	 
	    }
	    



	public  static void main(String[] args)  {
		
		 boolean play = true;
	     int pause = 0;
	     fscore = new ScoreSheet(cheminFeuilleDeScore);
	     fscore.init();
	     fscore.readFile();
	     

	    //Jeux
		  map = new Map();
	     player = new Joueur(map.xStart,map.yStart,-1,"Joueur","pac");
	     red = new Ghost(map.xRSpawn, map.yRSpawn, 1,"red","red");
	     blue = new Ghost(map.xBSpawn, map.yBSpawn, 3,"blue","blue");
	     pink = new Ghost(map.xPSpawn, map.yPSpawn, 0,"pink","pink");
	     orange = new Ghost(map.xOSpawn, map.yOSpawn, 2,"orange","orange");
	     
	     //Boutons
	     btnjouer = new Button(WIN_WIDTH/2,WIN_HEIGHT/2,80,20,"Play");
		 btnscore = new Button(btnjouer.x,btnjouer.y-2*btnjouer.height-30,80,20,"Score");
	     btnChnom = new Button(btnscore.x,btnscore.y-2*btnscore.height-30,80,20,"Changer de nom");
	     btncredit = new Button(btnChnom.x,btnChnom.y-2*btnChnom.height-30,80,20,"Credits");	     
 		 btnsaveScore = new Button(WIN_WIDTH/2,60,80,20,"Sauver le Score");
 		 btnMenujouer = new Button(WIN_WIDTH/2,20,80,20,"Jouer");
 		 btnretour = new Button(90,-20,80,20,"retour");
 		 btnrename = new Button(WIN_WIDTH/2,20,80,20,"Accepter");
 		editnom = new EditText(WIN_WIDTH/2,WIN_HEIGHT/2);
 		
	     Ghost[] listGhost= {red,blue,pink,orange};

	    

		//Génère la grille de la  fenètre
		StdDraw.setXscale(0, WIN_WIDTH);
        StdDraw.setYscale(-50, WIN_HEIGHT);
        
        menuPrincipal();
      
        /*
         * 
         * 
         * 
         * 
         */
     StdDraw.clear(StdDraw.BLACK);
     
    
	 
	 //affiche le panel du jeux
     panelJeux();
   	 
   	 

   	 
        while(true){
        	
        	//bouton retour au menu
        	if(btnretour.hoover()){
	   			if(StdDraw.mousePressed()){		    		
		    		 menuPrincipal();
	   			 }
        	}
        	
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
	        	
	        	 //TODO bonus
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
	            
	             player.move();
	             
		             
	            player.checkhitcookie(map);
	            if(player.checkhitwall(map)){
	            	player.hitwall();
	            }
	             player.afficher();   
	             
	             for (Ghost ghost: listGhost){  
	            	 //Le fantome choisis sa prochaine direction si il suit l'ancienne 1 fois sur 200
	            	 if(random.nextInt(100)<15 &&  ghost.buffer ==  ghost.dir){
	            		 ghost.buffer = random.nextInt(4);
	            		 while(Math.abs( ghost.buffer -  ghost.dir)==1){
	            			 ghost.buffer = random.nextInt(4);
	            		 }
	            	 }
	            	 if(!ghost.checkhitwall(map, ghost.buffer)){
	            		 //si sa prochaine direction est libre, le fantome la prend

	            		 ghost.dir = ghost.buffer;

	            		
		             }
	            	 ghost.move();
	            	 
	            	 if(ghost.checkhitwall(map)){
	            		 //si il touche un mur, on le fait rebondir
	            		 ghost.bounchehitwall(map);
	            	 }
	            	 map.checkhitghost(player, ghost);
	            		 
	            	 
	            	
	            	 ghost.afficher();;
	            	  
	             }
	                          
	             

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
	        	
	        	StdDraw.pause(50);
	        	
	        	
	        }
	        
	        if (StdDraw.isKeyPressed(KeyEvent.VK_P) && pause==0) {
	        	pause = 10;
	        	play = !play;
	       	 
	        }
	        	
        }

	}

}
