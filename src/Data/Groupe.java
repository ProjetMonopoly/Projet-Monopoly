package Data;

import java.util.ArrayList;

public class Groupe {

    private int prixAchatMaison;

    private CouleurPropriete couleur;
    private ArrayList<ProprieteAConstruire> lesproprietes = new ArrayList<ProprieteAConstruire>();

    public Groupe(ArrayList<ProprieteAConstruire> lesproprietes, CouleurPropriete couleur) {
        this.lesproprietes = lesproprietes;
        this.couleur = couleur;
    }

    public void addPropriete(ProprieteAConstruire propriete) {
        lesproprietes.add(propriete);
    }

    public CouleurPropriete getCouleur() {
        return couleur;
    }

    public int getPrixAchatMaison() {
        return prixAchatMaison;
    }

    public ArrayList<ProprieteAConstruire> getLesproprietes() {
        return lesproprietes;
    }

    public void setPrixAchatMaison(int prixAchatMaison) {
        this.prixAchatMaison = prixAchatMaison;
    }

    public void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
    }

}
