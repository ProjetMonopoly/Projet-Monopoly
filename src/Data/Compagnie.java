package Data;

public class Compagnie extends CarreauPropriete {

    public Compagnie(int _loyerBase, int _prixAchat, int _numero, String _nomCarreau, Monopoly monop) {
        super(_loyerBase, _prixAchat, _numero, _nomCarreau, monop);
    }

    public int calculLoyerCompagnie(int D, int Lb) {
        if (Lb == 1) {
            return D * 4;
        } else {
            return D * 10;
        }
    }

    @Override
    public void calculLoyer(Joueur j) {

        Joueur jproprio = super.getProprietaire();

        int nbg = jproprio.getNbCompagnies();// pour avoir le nombre de gare du joueur proprietaire
        int des = j.getDes(); //pour avoir le resultat du dés qu'il a fait

        int l = this.calculLoyerCompagnie(des, nbg);

        jproprio.setLoyer(l); // pour avoir le prix du loyer

    }

    @Override
    public void action(Joueur j) {
        Joueur jProprio = this.getProprietaire();

        if (jProprio == null) {
            this.achatPropriete(j);
        } else if (jProprio == j) {
            System.out.println("Vous etes les propriétaires, vous n'avez rien à payer");
        } else {
            this.calculLoyer(j); //du joueur pour avoir le dés

            int loyerPro = jProprio.getLoyer();

            jProprio.recevoirLoyer(loyerPro);
            j.PayerLoyer(loyerPro);

            Monopoly M = getMonopoly();

            M.InfosLoyerPro(jProprio, loyerPro);
            M.InfosLoyerJoueur(j, loyerPro);

        }
    }

    public Monopoly getMonopoly() {
        return super.getMonopoly();
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
                j.addCompanie(this);

                System.out.println("Tu as acheté la Companie");
                System.out.println("");
            }

        } else {
            System.out.println("Le joueur " + j.getNomJoueur() + " ne peut pas acheter la case " + super.getNomC());
        }

    }

}
