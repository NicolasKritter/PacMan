public class Ghost extends Perso{

public Ghost(int x0, int y0, int dir0, String nom,String pic) {
	super(x0, y0, dir0, nom,pic);
	
}
//0: bas 1: haut 2: gauche 3: droite
// fait "rebondir " un  fantôme touche un qui mur
public void bounchehitwall(Map map){
	int[] newdir = new int[3];
	 int oldir  =this.dir;
	 switch(oldir){
	 case 0:
		 //Si le fantôme touche un mur en se déplacçant dans une direction
		 //On définie les nouveles directions possibles
		
		newdir = new int[]{2,3,1};
		 break;
	 case 1:
		 newdir = new int[]{2,3,0};
		 break;
	 case 2:
		 newdir = new int[]{1,0,3};
		 break;
 	case 3:
 		newdir = new int[]{1,0,2};
	 break;
	 
	 }
	 //Le fantôme choisis une nouvelle direction au hasard
	 //ordre: en arrière au dernier recours
	 int k = 0;
	 while( k<3 && this.checkhitwall(map, newdir[k])){
		 k = k+1;
	 }
	 this.dir = newdir[k];
	 //évite de prendre comme prochaine direction un retour en arrière
	 while(Math.abs(this.buffer-this.dir)==1){
	 this.buffer = newdir[Main.random.nextInt(3)];
	 }
/*
	if(!this.checkhitwall(map, this.dir)){
		this.buffer = newdir[Main.random.nextInt(2)];
	}*/

	//On met cette direction en prochaine direction pour éviter les aller-retour sur place
	
	
	 }
}
