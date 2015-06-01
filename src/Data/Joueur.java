package Data;

import java.util.ArrayList;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	private Monopoly monopoly;
	private ArrayList<Compagnie> lescompagnies = new ArrayList<Compagnie>();
	private ArrayList<Gare> lesgares = new ArrayList<Gare>();
	private Carreau positionCourante;
	private ArrayList<ProprieteAConstruire> lesproprietesAConstruire = new ArrayList<ProprieteAConstruire>();
        private int numerodebut;//pour savoir qui va commencer

    public Joueur(String nomJoueur, Monopoly monopoly, Carreau positionCourante) {
        this.nomJoueur = nomJoueur;
        this.monopoly = monopoly;
        this.positionCourante = positionCourante;
    }

        
        
	public int getCash() {
		return this.cash;
	}


	public String getNomJoueur() {
		return this.nomJoueur;
	}
        
        public Carreau getCarreau() {
		return this.positionCourante;
	}

	public int getNbGares() {
            int j=0;
            for (int i=0; i<=lesgares.size(); i++ ){
                    j=i+1;
            }
            return j;
            
	}

	public void setCash(int aPrixA) {
		this.cash = aPrixA;
	}

	public void ModifPosition(int numero) {
            if (positionCourante.getNumcarreauCourant()+numero >40){
                int decalage;
                decalage=positionCourante.getNumcarreauCourant()+numero-40;
                positionCourante.setNumero(decalage);
            }else{positionCourante.setNumero(numero+positionCourante.getNumcarreauCourant());
            }
	}
        
        

	public ArrayList<ProprieteAConstruire> getLesPropio() {
		return lesproprietesAConstruire;
	}
        
        public int getNbPropriCouleur(CouleurPropriete aCoul) {
		throw new UnsupportedOperationException();
	}

	public int getNbCompagnies() {
            int j=0;
            for (int i=0; i<=lescompagnies.size(); i++ ){
                    j=i+1;
            }
            return j;
	}

	public void CashRestant(int aL) {
		throw new UnsupportedOperationException();
	}
        
        public void setNumeroDebut(){
            this.numerodebut=((int) (Math.random()*6) + 1);
        }
        
        public int getNumeroDebut(){
            return numerodebut;
        }

	//public Collection VerifConstruction(ProprieteAConstruire aP, Groupe aGr) {
	//	throw new UnsupportedOperationException();
	//}
}