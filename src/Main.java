
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
	    static Button btn2joueur;
	    static EditText editnom;
	    static ScoreSheet fscore;
	    static boolean mode2joueur;
	    
	    //sert pour le timer du jeux
	    static int duree;
	    //chemin du dossieur feuille de score
	    static String cheminFeuilleDeScore = "GameData/Score/scoreSheet.csv";
	    //chemin du dossier image
	    static String dossierImage = "GameData/Images/";
	    
	    //font pour les titres et titre principal
	    static Font fontTitrePrincipal = new Font("Georgia", Font.BOLD, 60);
	    static Font fontTitre = new Font("Georgia", Font.BOLD, 30);
	    

	    
	  //############################################## MENUS ####################################################### 
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
	    	 
	    	//bouton 2 joueurs
	    	 btn2joueur.dessiner();
	    	 
	    	 //bouton crédit
	    	 btncredit.dessiner();
	    	 
	    	 //bouton 2 joueurs ?
	    	
	    	 while(menu){
	    		 //supprime le 2ème joueur
	    		
	    		 if(btnjouer.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;
		    			 //initialise le mode 1 joueur
		    			 player.alive = true;
		    	    	 player.suivant = null;
		    			 mode2joueur = false;
		    			 init();
	
		    			 
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
	    		 if(btn2joueur.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;
		    			 mode2joueur = true;
		    			 player.suivant = new Joueur(map.xStart,map.yStart,-1,"Invité","pac2");
		    			 //on ajoute un joueur
		    			 
		    			 init2joueurs();
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
		    			 init();
		    			 
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

    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-80,player.vie+" vie(s) restantes");
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-110,player.score+" + "+(int)(300/duree)+" x "+player.vie);
	    	player.score = player.score+(int)(300/duree)*player.vie;
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-140,"Score Final: "+player.score);
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
	    //############################################## Mode 1 joueur ####################################################### 
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
	   	 //dessine les vies
	   	 for(int k = 0; k<player.vie;k++){
	   		 StdDraw.picture(365+25*k, -4,dossierImage+"vie.png", 25, 25);
	   	 }
	   	 
	   	 btnretour.dessiner();
	   	 
	   	 //intitialise le timer
	   	if(player.vie>2){
	    	duree = (int)(System.currentTimeMillis()/1000);
	    	}
	   	
	    }
	    
	    //mode 1 joueur (init servira à recommencer la partie ou faire la pause après la mort d'un joueur
		//initialise le jeux (pour débuter une nouvelle partie ou pour afficher la perte d'une vie)
	   
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
	    	 
	    	 //affiche et pause pendant 2 secondes
	    	 StdDraw.show(2000);
	    	 //nécessaire pour ne pas passer à l'affichage suivant 
	    	 //avant la fin de la pause
	    	 StdDraw.pause(2);
        	
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
	  //############################################## Affichage Dans le Jeux #######################################################    
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
	        		

	        	StdDraw.picture(mur.x, mur.y, Main.dossierImage+"mur.jpg",2*mur.large,2*mur.longe);
		    	mur = mur.suivant;
	        }
	    	
	    	 
	    	 
	    }
	    public static void afficherCookie(Cookie listecookie){
	    	Cookie cookie = listecookie;
	    	//parcour la liste chaînée des cookies et dessine les cookies
	        while(cookie!=null){
	        	
	        	if(cookie.bonus){
	        		StdDraw.picture(cookie.x, cookie.y,  Main.dossierImage+"bonus.png",cookie.taille,cookie.taille);
	        	}else{
	        	
		    	 StdDraw.picture(cookie.x, cookie.y, Main.dossierImage+"cookie.png",cookie.taille,cookie.taille);
	        	}

	      
	        	cookie = cookie.suivant;
	        }


	    	 
	    }
	    //####################### MODE 2 JOUEURS###############################
	    public static void panelJeux2(){
		     StdDraw.clear(StdDraw.BLACK);
		   	 //Afficher tous les murs
		   	 afficherMur(map.listemur);
		     //Afficher tous les coockies
		     afficherCookie(map.listcookie);
		     
		     //affiche les éléments du tableau de bord pour le Joueur 1
		     StdDraw.setPenColor(StdDraw.YELLOW);
		     StdDraw.text(300, -4,"Joueur 1: Flèches");
		     StdDraw.setPenColor(StdDraw.PINK);
		   	 StdDraw.text(300 , -30,"Invité: Z,Q,S,D");

		   	 
		   	 //affiche les éléments du tableau de bord pour le Joueur 2
		     StdDraw.setPenColor(StdDraw.WHITE);
		     StdDraw.text(500, -4,"Vies de départ: ");
		     for(int k = 0; k<player.vie;k++){
		   		 StdDraw.picture(500+25*k, -30,dossierImage+"vie.png", 25, 25);
		   	 }


		   	
		   	
		   	 btnretour.dessiner();
		   	 
		   	 //initialise le timer
		    	duree = (int)(System.currentTimeMillis()/1000);
		     
	    }
	    
	  //initialize lemode 2 joueur
	    public static void init2joueurs(){
	    	StdDraw.clear(StdDraw.BLACK);
	    	
	    	red.x = map.xRSpawn;
	    	red.y = map.yRSpawn;
	    	blue.x = map.xBSpawn;
	    	blue.y = map.yBSpawn;
	    	pink.x = map.xPSpawn;
	    	pink.y = map.yPSpawn;
	    	orange.x = map.xOSpawn;
	    	orange.y = map.yOSpawn;
	    	Joueur courant = player;
	    	//initialise les joueurs
	    	while(courant!=null){
	    		courant.x = map.xStart;
	    		courant.y = map.yStart;
	    		courant.buffer = -1;
	    		courant.dir = -1;
	    		courant.alive = true;
	    		courant.score = 0;
	    		courant.vie = 3;
	    		courant = courant.suivant;

	    	}
   		map = new Map();
   		
   		panelJeux2();
   		
	    }
	    
	    public static void menuFin2joueurs(){
	    	StdDraw.clear(StdDraw.BLACK);
	    	//calcul le temps qu'à durée la partie
	    	duree = (int) ((System.currentTimeMillis()/1000) - duree);
	    	
	    	//affichage pour le joueur 1
	    	StdDraw.setPenColor(StdDraw.YELLOW);
	    	StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-20, player.name);
	    	StdDraw.setPenColor(StdDraw.WHITE);
	    	StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-50, "Temps:"+duree+"s  => Bonus:"+(int)(300/duree));
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-100,player.vie+" vie(s) restantes");
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-140,player.score+" + "+(int)(300/duree)+" x "+player.vie);
	    	player.score = player.score+(int)(300/duree)*player.vie;
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-175,"Score Final: "+player.score);
    		
    		//affichage pour le joueur 2
	    	StdDraw.setPenColor(StdDraw.YELLOW);
	    	StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-300-20, player.suivant.name);
	    	StdDraw.setPenColor(StdDraw.WHITE);
	    	StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-300-50, "Temps:"+duree+"s  => Bonus:"+(int)(300/duree));
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-300-100,player.suivant.vie+" vie(s) restantes");
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-300-140,player.suivant.score+" + "+(int)(300/duree)+" x "+player.vie);
	    	player.score = player.score+(int)(300/duree)*player.suivant.vie;
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-300-175,"Score Final: "+player.suivant.score);
    		if(player.score>player.suivant.score){
    			StdDraw.setPenColor(StdDraw.YELLOW);
    			StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-300-250,"Vainqueur: "+player.name);
    		}else{
    			StdDraw.setPenColor(StdDraw.YELLOW);
    			StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-300-250,"Vainqueur: "+player.suivant.name);
    		}
    		btnMenujouer.dessiner();
    		btnretour.dessiner();
    		boolean menu = true;
	    	while(menu){
	    		
	    		if(btnMenujouer.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;		    	    		
		    			 
		    	    		
		    	    		init2joueurs();
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
	    
//###########################################################################################################

	public  static void main(String[] args)  {
		
		 boolean play = true;
	     fscore = new ScoreSheet(cheminFeuilleDeScore);
	     fscore.init();
	     fscore.readFile();
	     

	    //Jeux
		  map = new Map();
	     player = new Joueur(map.xStart,map.yStart,-1,"Joueur1","pac");
	    
	     red = new Ghost(map.xRSpawn, map.yRSpawn, 1,"red","red");
	     blue = new Ghost(map.xBSpawn, map.yBSpawn, 3,"blue","blue");
	     pink = new Ghost(map.xPSpawn, map.yPSpawn, 0,"pink","pink");
	     orange = new Ghost(map.xOSpawn, map.yOSpawn, 2,"orange","orange");
	     
	     //Boutons
	     //Boutons du menu Principal (créé les un en dssous des autres)
	     btnjouer = new Button(WIN_WIDTH/2,WIN_HEIGHT/2,80,20,"Play");
		 btnscore = new Button(btnjouer.x,btnjouer.y-2*btnjouer.height-30,80,20,"Score");
	     btnChnom = new Button(btnscore.x,btnscore.y-2*btnscore.height-30,80,20,"Changer de nom");
	     btn2joueur = new Button(btnChnom.x,btnChnom.y-2*btnChnom.height-30,80,20,"2 joueurs");	
	     btncredit = new Button(btnChnom.x,btn2joueur.y-2*btnChnom.height-30,80,20,"Credits");	
	     
	   //Boutons du menu de fin 1 joueur
 		 btnsaveScore = new Button(WIN_WIDTH/2,60,80,20,"Sauver le Score");
 		 btnMenujouer = new Button(WIN_WIDTH/2,20,80,20,"Jouer");
 		//Boutons du menu edition du pseudo
 		 btnrename = new Button(WIN_WIDTH/2,150,80,20,"Accepter");
 		editnom = new EditText(WIN_WIDTH/2,WIN_HEIGHT/2);
 		 //bouton de retour au menu Principal
 		 btnretour = new Button(90,-20,80,20,"Menu");
 		
 		
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
 	 
        while(true){
        	
        	//bouton retour au menu
        	if(btnretour.hoover()){
	   			if(StdDraw.mousePressed()){		    		
		    		 menuPrincipal();
	    			 //réinitialiste le jeux
	    			 player.vie = -1;
	   			 }
        	}
        	
        	//gestion du jeux
	        if(play){
	        	//affiche les cookies
	        	afficherCookie(map.listcookie);
	        	
	        	//sert pour parcourir a liste chainée des joueurs
	        	 Joueur joueurcourant = player;
	        	 //servira à identifier le numéro du joueur (pas un booléen pour faciliter l'ajout de N joueur en plus
	        	 int numeroJoueur = 1;
	        	 while(joueurcourant!=null){
	        		 //détecte quel joueur est entrain de joueur
	        		 if(joueurcourant.alive){
	        			 if(numeroJoueur==1){
		        		//Si le joueur est vivant, il peu se déplacer
		        		
		        		
		        			// Changement de direction avec les flèches
				        	 if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
				        		 //la prochaine direction sera vers le haut
				        		 joueurcourant.buffer = 0;
				                 
				             }
				             if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
				            	
				            	 joueurcourant.buffer = 1;
				             }
				             if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
				            	
				            	 joueurcourant.buffer = 2;
				             }
				             if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
				            	 
				            	 joueurcourant.buffer = 3;
				             }
		        		}
	        			 //Pour le joueur 2 seuleent
				        	if(numeroJoueur==2){
				        		if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
					        		 //la prochaine direction sera vers le haut
					        		 joueurcourant.buffer = 0;
					                 
					             }
					             if (StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
					            	
					            	 joueurcourant.buffer = 1;
					             }
					             if (StdDraw.isKeyPressed(KeyEvent.VK_Q)) {
					            	
					            	 joueurcourant.buffer = 2;
					             }
					             if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
					            	 
					            	 joueurcourant.buffer = 3;
					             }
			        		
				        	}
				        	
				        	//Détecte si la direction enregistrée dans le bugger est libre
				        	if(!joueurcourant.checkhitwall(map,  joueurcourant.buffer)){				 	            	
				            	 //si la prochaine direction est libre, on la prend
			 	            	joueurcourant.dir =  joueurcourant.buffer;
			 	            	    	 
				             }
				        	
				           //déplace le joueur
			 	           joueurcourant.move();				            
			 	           //détecte si le joueur touche un cookie
			 	           joueurcourant.checkhitcookie(map);
			 	           
			 	           //détecte si le joueur touche un mur et on agit en conséquence
				           if(joueurcourant.checkhitwall(map)){
				            	joueurcourant.hitwall();
				           }
				           //affiche le joueur
				           joueurcourant.afficher();  
		        		}
        		 
		             
	 	            
		            //on regarde si le joueur as un bonus
		            
		            if(joueurcourant.bonus){
		            	
		            	//si ça fait plus de 1 secondes qu'il a eu le bonus, on lui retire
		            	if((int) ((System.currentTimeMillis()/1000) - joueurcourant.timer)>1){
		            		joueurcourant.bonus = false;
		            		joueurcourant.bonustVit = 1;
		            	}
		            }
		             
		             joueurcourant  = joueurcourant.suivant;
		             numeroJoueur = numeroJoueur+1;
        	 
	        	 }
	        		 
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
	            	 //parcour la liste chaînée des joueurs pour savoir si l'un d'eux touche un fantome
	            	 Joueur courant = player;
	            	 while(courant!=null){
	            	 map.checkhitghost(courant, ghost);
	            	 courant = courant.suivant;
	            	 }
	            	 
	            		 
	            	 
	            	
	            	 ghost.afficher();
	            	  
	             }
	             if(mode2joueur){
		           //si les 2 joueurs sont mort
					 if(!player.alive && !player.suivant.alive){
						 menuFin2joueurs();
					 }   
	             }
	             

	             //Affichage du jeux
	             
	             
	             
	             StdDraw.show(10000/FPS);
	            
	             
	        }
	       //détecte si un touche à été pressé
	        if (StdDraw.hasNextKeyTyped()){
	        	//Si la touche qui à été pressé est P
	        	if(StdDraw.nextKeyTyped() ==  112){
	        		play = !play;
	        	}
	        }
	      
	        	
        }

	}

}
