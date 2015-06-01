package Data;

import static Data.CouleurPropriete.*;
import java.util.ArrayList;

public class ProprieteAConstruire extends CarreauPropriete {
	private final int nbMaisons = 0;
	private ArrayList<Integer> lesloyerMaison;
        private Groupe groupePropriete;
        //bleuFonce, orange, mauve, violet, bleuCiel, jaune, vert, rouge

    public ProprieteAConstruire(ArrayList<Integer> lesloyerMaison, int loyerBase, int prixAchat, int numero, String nomCarreau) {
        super(loyerBase, prixAchat, numero, nomCarreau);
        this.lesloyerMaison = lesloyerMaison;
      
       
    }        
        
        
	public int getConstruction() {
		return nbMaisons;
	}

	public CouleurPropriete getcouleurProp() {
		return groupePropriete.getCouleur();
	}

        public String getNomMaison() {
		return super.getNomC();
	}

	public void calculLoyerPAC(CouleurPropriete aCoul, int aNbc) {
		//regarder les  couleurs;
	}

	public void construire() {
		throw new UnsupportedOperationException();
	}

	public void debutConstruction(Joueur aJ, ProprieteAConstruire aP) {
		throw new UnsupportedOperationException();
	}

	public Groupe getGroupe() {
		return groupePropriete;
	}
        
        public String getCouleurGroupe(){
            return groupePropriete.getCouleur().name();
        }
        
        
	
}