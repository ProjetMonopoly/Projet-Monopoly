package Data;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {

    public Monopoly monopoly;

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

    public void InfoAchat(Joueur aJ, CarreauPropriete aCp) {
        throw new UnsupportedOperationException();
    }

    public void InfoTerrain(Joueur j, Groupe gr) {

    }

    public void infoPropriete(ProprieteAConstruire p, Groupe groupe) {
        System.out.println("La propriété " + p.getNomCarreau() + " a pour groupe " + groupe.getCouleur() + "et possède " + p.getConstruction());
    }

    public boolean InfoAchatPAC(Joueur j, ProprieteAConstruire p) {
        System.out.println("La propriété à acheter est " + p.getNomCarreau() + ", son groupe est " + p.getGroupe().getCouleur() + ", et le prix est de " + p.getPrixAchat());
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez vous acheter? (oui/non)");
        String str = sc.nextLine();

        if (str == "oui") {
            return true;
        } else {
            return false;
        }
    }

    public boolean InfoAchatAutre(Joueur j, CarreauPropriete cp) {
        System.out.println("La propriété à acheter est " + cp.getNomCarreau() + ", et le prix est de " + cp.getPrixAchat());
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez vous acheter? (oui/non)");
        String str = sc.nextLine();

        if (str == "oui") {
            return true;
        } else {
            return false;
        }
    }

    public void InfoConstruire(Joueur j, ArrayList<ProprieteAConstruire> PossibleConstruction) {
        int i = 1;
        System.out.println("Joueur : " + j.getNomJoueur());
        System.out.println("Voici vos possibles constructions: ");
        for (ProprieteAConstruire pac : PossibleConstruction) {
            System.out.println("Propriété " + i + ": " + pac.getNomCarreau());

            if (pac.getNbMaisons() <= 4) {
                System.out.println("Vous pouvez contruire une maison.");
            } else {
                System.out.println("Vous pouvez contruire un hotel.");
            }

            i++;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le numéro de la propiété à construire: ");
        String res = sc.nextLine();
        if (res == "1") {
            monopoly.getReponse(j, PossibleConstruction.get(0));
        } else if (res == "2") {
            monopoly.getReponse(j, PossibleConstruction.get(1));
        } else {
            monopoly.getReponse(j, PossibleConstruction.get(2));
        }
    }

    public void InfoPasConstruire(Joueur j) {
        System.out.println("Joueur : " + j.getNomJoueur());
        System.out.println("Vous ne pouvez pas construire! ");

    }

    public void InfosLoyerJoueur(Joueur j, int L) {
        System.out.println("Le joueur " + j.getNomJoueur() + " a payé un loyer de " + L + ". Son cash est de " + j.getCash());
    }

    public void InfosLoyerPro(Joueur j, int L) {
        System.out.println("Le joueur " + j.getNomJoueur() + " a payé un loyer de " + L + ". Son cash est de " + j.getCash());
    }

}
