import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ScoreSheet {
	
	//créé l'objet document
	 File scoreSheet;
//liste qui recevera tous les scores
	List<String> scoresligne;
	//séparateurs pour différencer les lignes et les colonnes
	static String separateur = " : ";
	static String newline="\n";
	
	StringBuilder str  = new StringBuilder();
	
	public ScoreSheet(String nomfichier){
		scoreSheet = new File(nomfichier);
	}
	
	public void init(){
		 //détecte si le fichier est déjà créé
	     if (!scoreSheet.isFile()){
	    	 //Crée le fichier vide le cas échéant
	    	 try {//essaye de le faire si possible
	    		 //créé le dossier
	    		 scoreSheet.getParentFile().mkdirs(); 
	    		 //créé le fichier
	    		 scoreSheet.createNewFile();

			} catch (IOException e) {

				e.printStackTrace();
			}

	    	 
	     }
	}
	//Lire le fichier csv et en sortir le tableau
	public   void readFile() {
		//liste tempon
		List<String> temp = new ArrayList<String>();
		
		//Essaye d'ouvrir le fichier des scores et de le lire
    	try {
    		//Ouvre le fichier pour le lire
			FileReader reader = new FileReader(scoreSheet);
			//Permet de lire un fichier ligne par ligne avec readLine
			BufferedReader buffreader = new BufferedReader(reader);
			
			//On lit le fichier ligne par ligne pour séparer les colonnes
			for (String line = buffreader.readLine(); line != null; line = buffreader.readLine()) {
				//on rajoute chaque ligne dans le tableau
	    		temp.add(line);
	        }
			//close les readers
			reader.close();
			buffreader.close();
			
			//on garede le score en mode ligne par ligne
			scoresligne = temp;
			

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
		
	}
	
	public  void writeScore(String nom, int score){
		int k = 0;
		// réinitialise les stringbuilder
		str.setLength(0);
		//construit la nouvelle lignes (utilisation de string builder améliore les performances
		str.append(nom);
		str.append(separateur);
		str.append(score);
		
		//String res = nom+" : "+score;
		//Si il y a déjà des scores
		if(scoresligne!=null && scoresligne.size()>0){
			//tant que le score est inféreur aux scores enrgistrés, on avance
			while(Integer.parseInt(scoresligne.get(k).split(separateur)[1]) >score && k<scoresligne.size()-1){// Split avec le séparateur pour isoler le score du nom
				//ligne nom : score -> On récupère {nom,score} après le split, et on transforme en Int
					k = k+1;
			}
		//On garde que les 10 meilleurs scores
			if(k<10){
				//Ajout du score dans la liste à la bonne place
				scoresligne.add(k, str.toString());
				
				if(scoresligne.size()>10){
				scoresligne.set(11,null);
				}
			}
		}else{//si la liste des score est vide, on l'initialise
			scoresligne = new ArrayList<String>();
			scoresligne.add(k, str.toString());
		}
			try {
				//créé l'objet qui va écrire dans le fichier
				FileWriter fileWriter = new FileWriter(scoreSheet);
				 for (String line:scoresligne){
					 //Ajoute chaque lignes du fichier et le délimiteur pour une nouvelle ligne
					 fileWriter.append(line);
					 fileWriter.append(newline);
				 }
				 //lance l'écriture et ferme le writer
				 fileWriter.flush();
				 fileWriter.close();

			} catch (IOException e) {
				
				e.printStackTrace();
			}
	       
	        
	}
		
		
	
	//retournle score en haut du tableau
	public  String getHighScore(){	
    	
    		if (scoresligne!=null && scoresligne.size()>0){
    		return scoresligne.get(0) ;
    		}else{
    			return " ";
    		}
    	
    }
	
	

}
