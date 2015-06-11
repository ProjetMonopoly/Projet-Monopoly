package Data;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {

    public Monopoly monopoly;
    
    public void Interface(Monopoly monopoly){
        this.monopoly=monopoly;
    }

    public void infoJoueur(int D, Carreau c, Joueur j) {
        System.out.println("Le joueur : " + j.getNomJoueur());
        System.out.println("Total des dés : " + D);
        System.out.println("Le nom du carreau : " + c.getNomCarreau());
        System.out.println("Le carreau numero : " + c.getNumcarreauCourant());
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

    public void InfoConstruire(Joueur j, ArrayList<ProprieteAConstruire> PossibleConstruction, Monopoly monopoly) {
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
        
        int res = sc.nextInt();
        
        if (res ==1 ) {
            monopoly.getReponse(j, PossibleConstruction.get(0));
        } else if (res ==2 ) {
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
        System.out.println("Le joueur " + j.getNomJoueur() + " a gagné " + L + ". Son cash est de " + j.getCash());
    }
    public boolean InfosAchatOuiNon(){
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Voulez-vous l'acheter (oui/non) ? ");
        String reponse = sc1.nextLine();
        if(reponse.equalsIgnoreCase("oui")){
            return true;
        }
        return false;
    }
    
    public void InfosPossibilitéAchat(Joueur aJ, CarreauPropriete aCp){
        System.out.println("Le joueur " + aJ.getNomJoueur() + " a la possibilité d'acheter la case " + aCp.getNomC());

    }
    public void InfosNombreJoueur(){
        System.out.println("Combien de joueur ? (entre 2 et 6): ");
    }
    
    public void InfosNomJoueur(int i){
        System.out.println("Entrer le nom du joueur " + i + " :");

    }
    public void FinPartie(Monopoly monop){
        Joueur gagnant = null;
        
        for(Joueur j:monop.getJoueurs()){
            if(j.getCash()>0){
                gagnant=j;
            }
        }
        System.out.println("Votre partie est terminé!");
        System.out.println("Le joueur qui a gagné est "+gagnant.getNomJoueur()+"!");
    }
    
    public void InfoPrison(){
    
        System.out.println("Vous allez en prison!!!");
    }
    public void InfoDepart(){
        System.out.println("Départ: vous recevez 200€!!!");
    }
    public void InfoImpot(){
        System.out.println("Impôts sur le revenu, vous perdez 200€");
    }
    public void InfoVisitePrison(){
    
        System.out.println("Case Prison: Simple visite!!");
    }
    public void InfoParc(){
    
        System.out.println("Parc gratuit: reposez-vous!");
    }
    public void InfoLuxe(){
        System.out.println("Taxe de luxe, vous perdez 100€");
    }
    public void InfoCarte(Carte ca, Joueur j){
        System.out.println("le joueur " + j.getNomJoueur()+ " a pioché la carte : " + ca.getDescription());
    }
    
    public void InfoDebPartie(Joueur j, Integer i, int cpt){
        System.out.println("Le joueur "+ j.getNomJoueur()+ " a fait un " + i + " et est le numéro " + cpt);
    }

}
