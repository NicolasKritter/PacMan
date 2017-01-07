
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
		 //TODO etendre la zone de recherche
		 if(map.coord[(int) this.x][(int) this.y]==1){
			 this.score = this.score+2;
			 map.coord[(int) this.x][(int) this.y]=0;
		 }
	 }

}
