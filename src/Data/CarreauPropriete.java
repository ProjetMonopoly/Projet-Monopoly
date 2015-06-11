package Data;

import java.util.ArrayList;

public abstract class CarreauPropriete extends Carreau {

    private int loyerBase;
    private int prixAchat;
    private Joueur proprietaire;

    public CarreauPropriete(int _loyerBase, int _prixAchat, int _numero, String _nomCarreau, Monopoly monop) {
        super(_numero, _nomCarreau, monop);
        this.loyerBase = _loyerBase;
        this.prixAchat = _prixAchat;
    }

    public int getPrixAchat() {
        return this.prixAchat;
    }

    @Override
    public abstract void action(Joueur j);

    public abstract void achatPropriete(Joueur j);

    public void Infos(String aNomCarreau, String aNomG) {
        ;
    }

    public String getNomC() {
        return super.getNomCarreau();
    }

    public void setProprio(Joueur aJ) {
        proprietaire = aJ;
    }

    public boolean estProprio() {
        if (proprietaire == null) {
            return false;
        } else {
            return true;
        }
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public abstract void calculLoyer(Joueur j);

    public int getLoyerBase() {
        return loyerBase;
    }

    public Monopoly getMonopoly() {
        return super.getMonopoly();
    }

    public boolean ConstruireRep(Joueur aJ, CouleurPropriete aCouleur, CarreauPropriete aCp) {
        return true;
    }

}
