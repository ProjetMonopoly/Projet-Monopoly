package Data;

import java.util.ArrayList;
import java.util.HashMap;
import Data.Carreau;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Monopoly {
	private int _nbMaisons = 32;
	private int _nbHotels = 12;
        private int numero;
	private HashMap<Integer,Carreau> lescarreaux;
	private ArrayList<Joueur> _joueurs = new ArrayList<Joueur>();
	public Interface _interface_9;
        

	public int resultatDés() {
		return ((int) (Math.random()*6)+(int) (Math.random()*6)); 
	}

	public void PayerLoyerGare() {
		throw new UnsupportedOperationException();
	}

	public boolean getReponse() {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Joueur> getLesJoueurs() {
		throw new UnsupportedOperationException();
	}

	public void ProcedureAchat(Joueur aJ, CarreauPropriete aCp) {
		throw new UnsupportedOperationException();
	}

	public void InfoProprio(String aNomP) {
		throw new UnsupportedOperationException();
	}
        
        public Carreau getCarreau(int numero){
            if (numero == this.numero){
                return lescarreaux.get(numero);
            }
            return null;
        }

	/**
	 * @param aCash 
	 *  
	 */
	public void InfosLoyerGare(int aL, int aCash) {
		throw new UnsupportedOperationException();
	}
        
        public Monopoly(String dataFilename){
		buildGamePlateau(dataFilename);
	}
	
        @SuppressWarnings("empty-statement")
	private void buildGamePlateau(String dataFilename)
	{
		try{    
                        lescarreaux= new HashMap<Integer,Carreau>();
                        Carreau carreau;
                        Carreau carreauAConstruire;
                        ArrayList<Integer> loyer ;
                        ArrayList<ProprieteAConstruire> pro;
                        Groupe groupe;
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
                        loyer = new ArrayList<>();
                        pro = new ArrayList<>();
                        
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        for (int j=5; 10>=j; j++){
                                               loyer.add(Integer.parseInt(data.get(i)[j]));
                                            }
                                        
                                        //Groupe(int _prixAchatMaison, CouleurPropriete _couleur)
                                        
                                        
                                        
                                        
                                        
                                        //ProprieteAConstruire(ArrayList<Integer> _loyerMaison, Groupe _groupePropriete, int _loyerBase, int _prixAchat, int _numero, String _nomCarreau)
                                        
                                        
                                        carreauAConstruire = new ProprieteAConstruire(loyer, Integer.parseInt(data.get(i)[5]),Integer.parseInt(data.get(i)[4]),Integer.parseInt(data.get(i)[1]),data.get(i)[2]);
                                        
                                        carreau= getCarreau(Integer.parseInt(data.get(i)[1]));
                                        
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreau);
                                        
                                        System.out.println("ajouté propriété fait");
                                        
                                     }  
                                
                               
                                        
                                        
				
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        carreauAConstruire = new Gare(Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[3]),Integer.parseInt(data.get(i)[1]), data.get(i)[2]);
                                        
                                        carreau= getCarreau(Integer.parseInt(data.get(i)[1]));
                                        
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreau);
                                        
                                        System.out.println("ajouté gare fait");
                                        
                                        
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        carreauAConstruire = new Compagnie(Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[3]),Integer.parseInt(data.get(i)[1]), data.get(i)[2]);
                                        
                                        carreau= getCarreau(Integer.parseInt(data.get(i)[1]));
                                        
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreau);
                                        
                                        System.out.println("ajouté Companie fait");
                                        
				}
				else if(caseType.compareTo("CT") == 0){
					System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        carreauAConstruire = new CarreauTirage(Integer.parseInt(data.get(i)[1]), data.get(i)[2]);
                                        
                                        carreau= getCarreau(Integer.parseInt(data.get(i)[1]));
                                        
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreau);
                                        
                                        System.out.println("ajouté carte tirage fait");
                                        
				}
				else if(caseType.compareTo("CA") == 0){
					System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        carreauAConstruire = new CarreauArgent(Integer.parseInt(data.get(i)[3]),Integer.parseInt(data.get(i)[1]), data.get(i)[2]);
                                        
                                        carreau= getCarreau(Integer.parseInt(data.get(i)[1]));
                                        
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreau);
                                        
                                        System.out.println("ajouté case argent fait");
				}
				else if(caseType.compareTo("CM") == 0){
					System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        carreauAConstruire = new CarreauMouvement(Integer.parseInt(data.get(i)[1]), data.get(i)[2]);
                                        
                                        carreau= getCarreau(Integer.parseInt(data.get(i)[1]));
                                        
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreau);
                                        
                                        System.out.println("ajouté case mouvement fait");
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
	}
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}
}