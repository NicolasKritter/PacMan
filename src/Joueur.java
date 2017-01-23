
public class Joueur extends Perso{
	int score;
	int vie;
	boolean bonus;
	public Joueur(int x0, int y0, int dir0, String nom, String pic) {
		super(x0, y0, dir0, nom,pic);
		score = 0;
		vie = 3;
		
	}
	//TODO a supprimer ?
	public void hitwall(){
		this.dir = -1;
		 }
	 
	//On regarde si le joueur est sur la même case qu'un cookie
	 public void checkhitcookie(Map map){
		 //On convertit la coordonnée du personnage en coordonnée du tableau de la carte
		 int nx = (int)(Math.round((this.x/Main.WIN_WIDTH)*map.lar));
		 int ny = (int)(Math.round((this.y/Main.WIN_WIDTH)*map.lon)); 

		
			 if (map.coord[nx][ny]==1){
				 
				 //identifie le cookie touché
				 Cookie supp = map.coordcookie[nx][ny];
				 
				 if (supp!=null){
					 
					//retire le cookie de la map
					 map.coord[nx][ny]=0;
					 
					 //décompte du nombre de cookie
					 map.nbcookie = map.nbcookie-1;
					 
					 //augmente le score
					 this.score = this.score+2;
					 
					 //rafraichit l'affichage du score
					 Main.refreshScore();
					 
					 //efface le cookie de l'affichage
					 supp.effacer();
					 
					 //efface le cookie dans la liste chaînée					 
					 map.deleteCookie(supp);
					 
					 //si il ne reste plus de cookie, on termine la partie
					 if(map.nbcookie<1){
							  Main.fin();
					  }
				 }
					
					 
			 }
		 } 

	 

}
