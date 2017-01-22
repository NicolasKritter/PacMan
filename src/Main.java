
import java.awt.Font;
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
	    static double STEP= 1.6;
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
	    //chemin du dossieur feuille de score
	    static String cheminFeuilleDeScore = "GameData/Score/scoreSheet.csv";
	    //chemin du dossier image
	    static String dossierImage = "GameData/Images/";
	    
	    //font pour les titres et titre principal
	    static Font fontTitrePrincipal = new Font("Georgia", Font.BOLD, 60);
	    static Font fontTitre = new Font("Georgia", Font.BOLD, 30);
	    
	    //TODO class menu ?
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

	    //TODO score: prendre en compte le nombre max de cooie dispo
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
	    	 //TODO a changer
	    	 StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT/3.2, "VANACKER Eliott G7 ISEP");
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
    		StdDraw.text(WIN_WIDTH/2, WIN_HEIGHT-50,player.name+": "+player.vie+" vie(s) & Score: "+player.score);
    		btnsaveScore.dessiner();
    		btnMenujouer.dessiner();
    		btnretour.dessiner();
	    	AfficherScore(fscore.scoresligne);
    		boolean menu = true;	
	    	while(menu){
	    		
	    		if(btnMenujouer.hoover()){
	    			 if(StdDraw.mousePressed()){
		    			 menu = false;		    	    		
		    			 map = new Map();
		    	    		
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
	    		 if(btnretour.hoovered){
	    			 if(StdDraw.mousePressed()){
	    				 player.vie = 3;
		    	    	 player.score = 0;
		    			 menu = false;	
		    			 menuPrincipal();
	    			 }
	    		 }
	    		
	    	}
	    		//TODO changer la vitesse du jeux ?
	    	
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
	   		
	    }
	    //TOD0 refaire le ini plus propre
	    public  static void init(){
	    	
	    	if (player.vie<1){
	    		player.vie = 3;
	    		player.score = 0;
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
	    	//parcour la liste chaînée des murs et on les dessines
	        while(mur!=null){

	        	StdDraw.setPenColor(StdDraw.BLUE);
		    	StdDraw.rectangle(mur.x,mur.y,mur.large-1,mur.longe-1);
		    	mur = mur.suivant;
	        }
	    	
	    	 
	    	 
	    }
	    public static void afficherCookie(Cookie listecookie){
	    	Cookie cookie = listecookie;
	    	//parcour la liste chaînée des cookies et dessine les cookies
	        while(cookie!=null){
	        	
		    	 StdDraw.setPenColor(StdDraw.WHITE);
		    	 StdDraw.picture(cookie.x, cookie.y, Main.dossierImage+"cookie.png",cookie.taille,cookie.taille);
	       	 

	      
	        	cookie = cookie.suivant;
	        }


	    	 
	    }
	    

	    //TODO mettre des images ?

	    //TODO afficher pause ?

	public  static void main(String[] args)  {
		//controle
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
   	 
   	 
    //TODO fonction jouer
   	 
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
	             
	             System.out.println((player.x - (int)player.x )+ " "+ (player.y - (int)player.y));
	             
 	             if(!player.checkhitwall(map,  player.buffer) ){

	            	 //si la prochaine direction est libre, on la prend
	            	// if (player.x - (int)player.x<0.3 && player.y - (int)player.y<0.3 || player.dir==-1){
	            	 player.dir =  player.buffer;
	            	 //}
	            	 
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
	            		 //if(ghost.x - (int)ghost.x<0.3 && ghost.y - (int)ghost.y<0.3){
	            		 ghost.dir = ghost.buffer;
	            		 //}
	            		
	            		//TODO chrono
		             }
	            	 ghost.move();
	            	 
	            	 if(ghost.checkhitwall(map)){
	            		 //si il touche un mur, on le fait rebondir
	            		 ghost.bounchehitwall(map);
	            	 }
	            	 map.checkhitghost(player, ghost);
	            		 
	            	 
	            	
	            	 ghost.afficher();;
	            	  
	             }
	                          

	               player.move();
	             player.checkhitcookie(map);
	             player.checkhitwall(map);            	        
	             player.afficher();
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
