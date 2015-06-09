package Data;

import static Data.CouleurPropriete.*;
import java.util.ArrayList;

public class ProprieteAConstruire extends CarreauPropriete {

    private final int nbMaisons = 0;
    private ArrayList<Integer> lesloyerMaison;
    private Groupe groupePropriete;
    //bleuFonce, orange, mauve, violet, bleuCiel, jaune, vert, rouge

    public ProprieteAConstruire(ArrayList<Integer> lesloyerMaison, int loyerBase, int prixAchat, int numero, String nomCarreau, Monopoly monop) {
        super(loyerBase, prixAchat, numero, nomCarreau, monop);
        this.lesloyerMaison = lesloyerMaison;

    }

    public String getConstruction() {
        if (nbMaisons == 5) {
            return "1 hotel";
        } else if (nbMaisons == 1) {
            return "1 maison";
        } else if (nbMaisons == 0) {
            return "0 maison";
        }
        return (String.valueOf(nbMaisons) + " maisons");

    }

    public CouleurPropriete getcouleurProp() {
        return groupePropriete.getCouleur();
    }

    public String getNomMaison() {
        return super.getNomC();
    }

    public int calculLoyerPAC(CouleurPropriete Coul, int Nbc, Joueur j) {
        if (Coul == CouleurPropriete.valueOf("Bleufoncé")) {
            if ((j.getNbPropriCouleur(Coul) == 2) && (this.getNbMaisons() == 0)) {
                return 1;
        }
            return 1;
        } return 1;   
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

    public String getCouleurGroupe() {
        return groupePropriete.getCouleur().name();
    }

    public Joueur getPropriétaire() {
        return super.getProprietaire();
    }

    public Monopoly getMonopoly() {
        return super.getMonopoly();
    }

    @Override
    public void calculLoyer(Joueur j) { //rien avoir uml

        CouleurPropriete coul = getGroupe().getCouleur();
        
        int nbc = j.getNbPropriCouleur(coul);

        
        
        
        
        

    }

    @Override
    public void action(Joueur j) {
        Joueur jProprio = this.getProprietaire();

        if (jProprio == null) {
            this.achatPropriete(j);
        } else if (jProprio == j) {
            System.out.println("Vous etes les propriétaires, vous n'avez rien à payer");
        } else {
            this.calculLoyer(jProprio);

            int loyerPro = jProprio.getLoyer();

            jProprio.recevoirLoyer(loyerPro);
            j.PayerLoyer(loyerPro);

            Monopoly M = getMonopoly();
            M.InfosLoyer(jProprio, jProprio.getLoyer());
            M.infoJoueur3(j);

        }
    }

    @Override
    public void achatPropriete(Joueur j) {
        int prixA = this.getPrixAchat();  //pour avoir le prix du carreau               

        int cashJ = j.getCash();

        if (cashJ >= prixA) {

            Monopoly m = this.getMonopoly();  // Pour obtenir le monop

            m.ProcedureAchat(j, this);  //envoi un message

            boolean confirmer = false;
            confirmer = m.AchatProp();

            if (confirmer == true) {
                super.setProprio(j);
                j.setCash(cashJ - prixA);
                j.addProprietes(this);

                System.out.println("Tu as acheté la gare");
                System.out.println("");
            }

        } else {
            System.out.println("Le joueur " + j.getNomJoueur() + " ne peut pas acheter la case " + super.getNomC());
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
