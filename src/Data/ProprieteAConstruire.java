package Data;

import static Data.CouleurPropriete.*;
import java.util.ArrayList;

public class ProprieteAConstruire extends CarreauPropriete {
	private final int nbMaisons = 0;
	private ArrayList<Integer> lesloyerMaison;
        private Groupe groupePropriete;
        private Joueur j;
        private Joueur jProprio;
        //bleuFonce, orange, mauve, violet, bleuCiel, jaune, vert, rouge

    public ProprieteAConstruire(ArrayList<Integer> lesloyerMaison, int loyerBase, int prixAchat, int numero, String nomCarreau, Monopoly monop) {
        super(loyerBase, prixAchat, numero, nomCarreau,monop);
        this.lesloyerMaison = lesloyerMaison;
      
       
    }        
    public String getConstruction() {
		if (nbMaisons==5){
                    return "1 hotel";
                }
                else if(nbMaisons==1){
                    return "1 maison";
                }
                else if(nbMaisons==0){
                    return "0 maison";
                }
                return (String.valueOf(nbMaisons)+" maisons");
                    
	}

	public CouleurPropriete getcouleurProp() {
		return groupePropriete.getCouleur();
	}

        public String getNomMaison() {
		return super.getNomC();
	}

	public void calculLoyerPAC(CouleurPropriete aCoul, int aNbc) {
		//regarder les  couleurs;
             {
                
            }
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
        
        public Joueur getPropriétaire(){
            return super.getProprietaire();
        }

        @Override
        public void calculLoyer(Joueur j) {
        }

        @Override
        public void action(Joueur j) {
            Joueur jProprio = getProprietaire();

            if (jProprio == null){
                this.achatPropriete(j);
            }
        }
        
    

    public Monopoly getMonopoly() {
            return super.getMonopoly();
        }
        
    @Override
    public void achatPropriete(Joueur j){
		int prixA=getPrixAchat();  //pour avoir le prix du carreau
                
                Monopoly m = this.getMonopoly();  // Pour obtenir le monop
              
                
                Joueur joueurActuel = j; //variable pour le joueur actuel
                
                
                int cashJ = joueurActuel.getCash();
                
                
                
                if (cashJ > prixA){
                    m.ProcedureAchat(joueurActuel, this);
                    System.out.println("Le joueur " + joueurActuel.getNomJoueur() + " veut acheté " + this.getNomC() + " ?");
                    
                    Boolean confirmer = false;
                    confirmer = m.AchatProp();
                    
                    if (confirmer == true){
                        this.setProprio(joueurActuel);
                        joueurActuel.setCash(cashJ-prixA);
                        joueurActuel.addProprietes(this);
                        
                        
                    }
                                     
                }
    }
    public int getNbMaisons() {
        return nbMaisons;
    }

    public ArrayList<Integer> getLesloyerMaison() {
        return lesloyerMaison;
    }

    public Groupe getGroupePropriete() {
        return groupePropriete;
    }
    
 
        
        
	
}