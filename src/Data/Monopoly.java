package Data;

import Data.Carreau;
import static Data.CouleurPropriete.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Monopoly {
	private int _nbMaisons = 32;
	private int _nbHotels = 12;
//        private int des;//pour le resultat du lancé de des
        private int numero; //pour le numero de la case en cour
	private HashMap<Integer,Carreau> lescarreaux;
	private ArrayList<Joueur> lesjoueurs = new ArrayList<Joueur>();
	public Interface _interface_9;
        private ArrayList<Groupe> groupe = new ArrayList<>();
        
        public HashMap<Integer,Carreau> getLesCarreaux() {
            return lescarreaux;
        }
        
	public int resultatDés(Joueur j) {
            Random rnd = new Random();
            int i = rnd.nextInt(6)+1;
            
            return i;
//            int des1 = ((int) (Math.random()*6) + 1);
//            int des2 = ((int) (Math.random()*6) + 1);
//            
//            if (des1==des2){ //si le joueur a un double alors se compteur de double augmente
//                j.setDouble(j.getDouble()+1);
//                
//                if(j.getDouble()==3)
//                
//                return (((int) (Math.random()*6) + 1) + ((int) (Math.random()*6)+1)); //a voir si il refait encore un double
//            }else {return (((int) (Math.random()*6) + 1) + ((int) (Math.random()*6)+1));}
	}
        
        
	
        public boolean AchatProp(Joueur aJ, CarreauPropriete aCp) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Joueur> getLesJoueurs() {
		return lesjoueurs;
	}
        
        public void setLesJoueurs(Joueur j) {
		lesjoueurs.add(j);
	}

	public void ProcedureAchat(Joueur aJ, CarreauPropriete aCp) {
		throw new UnsupportedOperationException();
	}

        public void InfosLoyerGare(Joueur aJProprio, int aL, int aCash) {
		throw new UnsupportedOperationException();
	}

	public void ProcedureConstruire(Joueur aJ, Groupe aGr) {
		throw new UnsupportedOperationException();
	}

	public void InfosLoyerCompagnie(Joueur aJProprio, int aL, int aCash) {
		throw new UnsupportedOperationException();
	}

	public void InfosLoyerPAC(Joueur aJProprio, int aL, int aCash) {
		throw new UnsupportedOperationException();
	}

	public boolean getReponse(Joueur aJ, ProprieteAConstruire aP) {
		throw new UnsupportedOperationException();
	}

	public void choixTerrain(Joueur aJ, Groupe aGr) {
		throw new UnsupportedOperationException();
	}
        
        public Carreau getCarreau(int numero){
            return lescarreaux.get(numero); //returne le carreau avec un numero
        }
  
        public void CréerGroupe(){
            //bleuFonce, orange, mauve, violet, bleuCiel, jaune, vert, rouge
            Groupe Bleufonce = new Groupe(null,bleuFonce);
            Groupe Orange = new Groupe(null,orange);
            Groupe Mauve = new Groupe(null,mauve);
            Groupe Violet = new Groupe(null,violet);
            Groupe Bleuciel = new Groupe(null,bleuCiel);
            Groupe Jaune = new Groupe(null,jaune);
            Groupe Vert = new Groupe(null,vert);
            Groupe Rouge = new Groupe(null,rouge);
            
            groupe.add(Bleufonce);
            groupe.add(Orange);
            groupe.add(Mauve);
            groupe.add(Violet);
            groupe.add(Bleuciel);
            groupe.add(Jaune);
            groupe.add(Vert);
            groupe.add(Rouge);
            
        }
        
        public void LancerDésEtAvancer(Joueur j){
            boolean verif = true;
            
            System.out.println("");
            int des1=0;
            int des2=0;
            
            des1=resultatDés(j);
            des2=resultatDés(j);
            
            j.setDouble(0);
            if (des2 == des1){
                
                while (verif==true){
                    des1=resultatDés(j);
                    des2=resultatDés(j);

                    j.setDouble(j.getDouble()+1);

                    if (j.getDouble()==3){
                        j.setDouble(0);
                        Carreau carreauPrison = lescarreaux.get(11);
                        j.setCarreau(carreauPrison);
                        
                        System.out.println("Le joueur " + j.getNomJoueur() + " à fait 3 double à la suite ce qui l'amene sur la case " + lescarreaux.get(11).getNomCarreauMaison());
                        
                        verif = false;
                    }
                    

                }
            }
            
            else if (verif == true) {
                int des = 0;
                des = des1+des2;
                j.ModifPosition(des);
                
                
                Carreau carreauCourant = lescarreaux.get(j.getDeplacement()); //le nouveaux carreau avec le deplacement
                j.setCarreau(carreauCourant); //j'associe le carreaux ou le joueur est avec le joueur

                String nomCarreau;
                nomCarreau=j.getCarreau().getNomCarreauMaison();  //Nom carreau 

                String nomJoueur;
                nomJoueur= j.getNomJoueur();

                System.out.println("Le joueur " + nomJoueur + " à fait un " + des + " ce qui l'amene sur la case " + nomCarreau);

                //premiere étape ok 

                ArrayList<Joueur> collectionJoueur = new ArrayList<>();
                collectionJoueur=lesjoueurs;

                System.out.println("");
                
                for (Joueur i: collectionJoueur){
                    int cash;
                    cash=i.getCash(); // l'argent que possede le joueur

                    nomJoueur = i.getNomJoueur();//nom joueur

                    int numero;
                    numero = i.getNumCarreau();

                    System.out.println("Le joueur " + nomJoueur + " à " + cash + "€ et est sur la case numero " +numero);

                    ArrayList<ProprieteAConstruire> collectProprio = i.getLesPropio();
                    

                    for ( ProprieteAConstruire p : collectProprio){
                        int construction;
                        construction = p.getConstruction();

                        CouleurPropriete couleur;
                        couleur = p.getcouleurProp();

                        String NomCase;
                        NomCase = p.getNomMaison();

                        System.out.println("Ce joueur possede la case " + NomCase + " de couleur " + couleur.name() + " avec un niveau de construction egal à " + construction);
                    }
                }

            }
        }    
        
        
        public void JouerUnCoup(Joueur j){
            LancerDésEtAvancer(j);
            
            
        } 
        
	
	/**
	 * @param aCash 
	 *  
	 */
        
        public Monopoly(String dataFilename){
		buildGamePlateau(dataFilename);
	}
	
        @SuppressWarnings("empty-statement")
	private void buildGamePlateau(String dataFilename)
	{ ///message 
		try{    
                    
                        // mettre des commentaires 
                        lescarreaux= new HashMap<Integer,Carreau>();
                        Carreau carreau;
                        Carreau carreauAConstruire;
                        ArrayList<Integer> loyer ;
                        ArrayList<ProprieteAConstruire> pro;
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
                                        
                                        for (Groupe g: groupe){
                                            
                                            if ((CouleurPropriete.valueOf(data.get(i)[3])) == g.getCouleur()){
                                                g.addPropriete((ProprieteAConstruire) carreauAConstruire);
                                                
                                            }
                                        }
                                        
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreauAConstruire);
                                        
                                       
                                        System.out.println("ajouté propriété fait");
                                        
                                     }  
                                
                               
                                        
                                        
				
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        carreauAConstruire = new Gare(Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[3]),Integer.parseInt(data.get(i)[1]), data.get(i)[2]);
                                        
                                        
                                        
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreauAConstruire);
                                        
                                        System.out.println("ajouté gare fait");
                                        
                                        
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        carreauAConstruire = new Compagnie(Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[3]),Integer.parseInt(data.get(i)[1]), data.get(i)[2]);
                                        
                                        
                                        
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreauAConstruire);
                                        
                                        System.out.println("ajouté Companie fait");
                                        
				}
				else if(caseType.compareTo("CT") == 0){
					System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        carreauAConstruire = new CarreauTirage(Integer.parseInt(data.get(i)[1]), data.get(i)[2]);
                                        
                                       
                                        
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreauAConstruire);
                                        
                                        System.out.println("ajouté carte tirage fait");
                                        
				}
				else if(caseType.compareTo("CA") == 0){
					System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        carreauAConstruire = new CarreauArgent(Integer.parseInt(data.get(i)[3]),Integer.parseInt(data.get(i)[1]), data.get(i)[2]);
                                        
                                       
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreauAConstruire);
                                        
                                        System.out.println("ajouté case argent fait");
				}
				else if(caseType.compareTo("CM") == 0){
					System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        carreauAConstruire = new CarreauMouvement(Integer.parseInt(data.get(i)[1]), data.get(i)[2]);
                                        
                                        
                                        
                                        lescarreaux.put(Integer.parseInt(data.get(i)[1]),carreauAConstruire );
                                        
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
        
        
        private void buildGameJoueur(ArrayList<Joueur> lesjoueurs)
	{
            this.lesjoueurs=lesjoueurs;
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
