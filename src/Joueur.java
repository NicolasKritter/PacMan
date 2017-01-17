
public class Joueur extends Perso{
	int score;
	int vie;
	public Joueur(int x0, int y0, int dir0, String nom) {
		super(x0, y0, dir0, nom);
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

		 int taille = (int)(Math.round(Main.taille/2));
		
		 //TODO add coockie number to delete
			 if (map.coord[nx][ny]==1){
				 Cookie supp = map.coordcookie[nx][ny];
				 if (supp!=null){
					 
				 map.coord[nx][ny]=0;
				 map.nbcookie = map.nbcookie-1;
					 this.score = this.score+2;
					 Main.refreshScore();
					 //TODO dessine cookie si c'est un fantome ?
					 Main.effaceur(supp.x, supp.y, taille);
					 
					 //TODo faire une liste qui récupère la nouvelle liste 
					  map.deleteCookie(supp);
					  if(map.nbcookie<1){
						  Main.fin();
					  }
				 }
					
					 
			 }
		 } 

	 

}
