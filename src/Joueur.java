
public class Joueur extends Perso{
	int score;
	int vie;
	public Joueur(int x0, int y0, int dir0, String nom) {
		super(x0, y0, dir0, nom);
		score = 0;
		vie = 3;
		
	}
	
	public void hitwall(){
		this.dir = -1;
		 }
	 
	 public void checkhitcookie(Map map){
		 //TODO trouver le cookie touché et le retirer
		 int nx = (int)(Math.round((this.x/Main.WIN_WIDTH)*map.lar));
		 int ny = (int)(Math.round((this.y/Main.WIN_WIDTH)*map.lon)); 
		 //TODO étendre la liste de recherche (comme mur)
		 int taille = (int)(Math.round(Main.taille/2));
		
		 //TODO add coockie number to delete
			 if (map.coord[nx][ny]==1){
				 Cookie supp = map.coordcookie[nx][ny];
				 if (supp!=null){
				 System.out.println(map.coord[nx][ny] +" "+nx+" "+ny);
				 map.coord[nx][ny]=0;
				 
					 this.score = this.score+2;
					 Main.refreshScore();
					 //TODO dessine cookie si c'est un fantome ?
					 Main.effaceur(supp.x, supp.y, taille);
					 
					 
					 map.deleteCookie(supp);
				 }
					
					 
			 }
		 } 

	 

}
