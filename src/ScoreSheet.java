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
	static File scoreSheet = new File("src/scoreSheet.csv");
	//créé le tableau de score
	static ArrayList<String[]> scorestable;
	//ligne des scores pour affichage top 10
	static List<String> scoresligne;
	static String separateur = ":";
	static String newline="\n";
	
	public ScoreSheet(){
		
	}
	
	public static void init(){
		 //détecte si le fichier est déjà créé
	     if (!scoreSheet.isFile()){
	    	 //Crée le fichier vide le cas échéant
	    	 try {
	    	 FileWriter fileWriter = new FileWriter(scoreSheet,true);
	    	 fileWriter.append("");
	    	
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	 
	     }
	}
	//Lire le fichier csv et en sortir le tableau
	public static  void readFile(File file) {
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
			reader.close();
			buffreader.close();
			//TODO garder seulement les ligne pour gagner de la mémoire
			//on garede le score en mode ligne par ligne
			scoresligne = temp;
			
			//On sépare les colonnes
			//tableau de string de la taille de temp
			ArrayList<String[]> data  = new ArrayList<String[] >(temp.size());
			 for (String line : temp) {
		            String[] oneData = line.split(separateur);
		            data.add(oneData);
		        }
			
			//On met a jour la liste des scores
			scorestable = data;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
		
	}
	
	public static void writeScore(String nom, int score){
		int k = 0;
		String res = nom+" : "+score;
		if(scoresligne!=null){
			while(Integer.parseInt(scoresligne.get(k)) >score && k<scoresligne.size()){
					k = k+1;
			}
		
			if(k<11){
				
				
				scoresligne.add(k, res);
				if(scoresligne.size()>10){
				scoresligne.set(11,null);
				}
			}
		}else{
			scoresligne = new ArrayList<String>();
			scoresligne.add(k, res);
		}
			try {
				FileWriter fileWriter = new FileWriter(scoreSheet);
				 for (String line:scoresligne){
					 //Ajoute chaque lignes du fichier et le délimiteur pour une nouvelle ligne
					 fileWriter.append(line);
					 fileWriter.append(newline);
				 }
				 fileWriter.flush();
				 fileWriter.close();

			} catch (IOException e) {
				
				e.printStackTrace();
			}
	       
	        
	}
		
		
	
	
	public static String getHighScore(){	
    	
    		if (scoresligne!=null){
    		return scoresligne.get(0) ;
    		}else{
    			return " ";
    		}
    	
    }
	
	

}
