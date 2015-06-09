package Data;

public class Interface {

    public Monopoly _monopoly;

    public void infoJoueur(int D, Carreau c, Joueur j) {
        System.out.println("Le joueur : " + j.getNomJoueur());
        System.out.println("Total des dés : " + D);
        System.out.println("Le nom du carreau : " + c.getNomCarreau());
    }

    public void infoJoueur2(Joueur j, Carreau c) { //a voir
        System.out.println("Le joueur " + j.getNomJoueur() + " est sur la case " + c.getNomCarreau() + " avec " + j.getCash() + "€ comme argent.");
        
        if ((j.getLesPropio().isEmpty()) && (j.getLescompagnies().isEmpty()) && (j.getLesgares().isEmpty())) {
            System.out.println("Il ne possede aucune propriete !");
        } else {
            System.out.print("Ces propriétés sont: ");
            for (ProprieteAConstruire p : j.getLesPropio()) {
                System.out.println(p.getNomMaison());
            }
            for (Gare g : j.getLesgares()) {
                System.out.println(g.getNomC());
            }
            for (Compagnie comp : j.getLescompagnies()) {
                System.out.println(comp.getNomC());
            }
        }
    }

    public void infoPropriete(ProprieteAConstruire p, Groupe groupe) {
        System.out.println("La propriété " + p.getNomCarreau() + " a pour groupe " + groupe.getCouleur() + "et possède " + p.getConstruction());
    }

    public void InfosLoyerGare(Joueur jproprio, int l) {
        System.out.println("Le proprietaire de cette case est " + jproprio.getNomJoueur() + ", le montant du loyer est " + l );
    }

    public void InfoAchat(Joueur aJ, CarreauPropriete aCp) {
        throw new UnsupportedOperationException();
    }

    public void InfoConstruire(Joueur aJ, Groupe aPossibleConstruction) {
        throw new UnsupportedOperationException();
    }

    public void InfosLoyerCompagnie(Joueur jproprio, int l) {
        System.out.println("Le proprietaire de cette case est " + jproprio.getNomJoueur() + ", le montant du loyer est " + l );
    }

    public void InfosLoyerPAC(Joueur aJProprio, int aL, int aCash) {
        throw new UnsupportedOperationException();
    }

    public void InfoTerrain(Joueur j, Groupe gr) {

    }
}
