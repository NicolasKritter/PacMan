import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class EditText extends Component{

	String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

	StringBuilder str = new StringBuilder();
	public EditText(int x0, int y0){
		super(x0,y0,250,50,"Joueur");
		
	}
	//TODO new font ?
	public void updatetxt(){
		//efface le contenu et on réaffiche
		StdDraw.setPenColor();
		StdDraw.filledRectangle(x, y, width-2, height-1);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.text(x, y, text);
	}

	
	public void writing(){
		//si un touche a été tappée
		if (StdDraw.hasNextKeyTyped()){
			// on lit le numéro de la touche
			int lettre = StdDraw.nextKeyTyped();
			
			
			if(lettre ==  KeyEvent.VK_BACK_SPACE){
				//supprime la dernière lettre si str n'est pas vide
				
				if(str.length()>0){
					str.deleteCharAt(str.length()-1);	
					
				}
			}else if(lettre<123 && lettre>96 && str.length()<20){
				//limite la taille du nom à 20 char
				//On va chercher la lettre coresspondante
				//CODE A: 97 Z:122
				str.append(alphabet[lettre-97]);
				
				
			}
			text = str.toString();
			updatetxt();
		}
		
	}

	

}
