package Data;

import java.util.ArrayList;
import java.util.Random;

public class Joueur {

    private String nomJoueur;
    private int cash = 1500;
    private Monopoly monopoly;
    private ArrayList<Compagnie> lescompagnies = new ArrayList<Compagnie>();
    private ArrayList<Gare> lesgares = new ArrayList<Gare>();
    private Carreau positionCourante;
    private ArrayList<ProprieteAConstruire> lesproprietesAConstruire = new ArrayList<ProprieteAConstruire>();
    private int numerodebut;//pour savoir qui va commencer
    private int doubl = 0; //pour savoir les doubles
    private int des;//pour le resultat du lancé de des
    private int deplacement;// pour savoir ou est le joueur apres son lancé de dés
    private int loyer = 0; //pour avoir un variable loyer pour recevoirloyer, payerloyer

    public Joueur(String nomJoueur, Monopoly monopoly, Carreau positionCourante) {
        this.nomJoueur = nomJoueur;
        this.monopoly = monopoly;
        this.positionCourante = positionCourante;

    }

    public ArrayList<Compagnie> getLescompagnies() {
        return lescompagnies;
    }

    public ArrayList<Gare> getLesgares() {
        return lesgares;
    }

    public int getCash() {
        return this.cash;
    }

    public String getNomJoueur() {
        return this.nomJoueur;
    }

    public void setPositionCourante(Carreau c) {
        positionCourante = c;
    }

    public Carreau getCarreau() {
        return this.positionCourante;
    }

    public int getNumCarreau() {
        return this.positionCourante.getNumcarreauCourant();
    }

    public int getNbGares() {
        int j = 0;
        for (int i = 1; i <= lesgares.size(); i++) {
            j = j + 1;
        }
        return j;

    }

    public void setCash(int aPrixA) {
        this.cash = aPrixA;
    }

    public void ModifPosition(int numero) {
        if (positionCourante.getNumcarreauCourant() + numero > 40) { //si le numero du carreau + des > 40 alors il y a un decalage
            setDeplacement(positionCourante.getNumcarreauCourant() + numero - 40);
        } else {
            setDeplacement(numero + positionCourante.getNumcarreauCourant());
        }
    }

    public ArrayList<ProprieteAConstruire> getLesPropio() {
        return lesproprietesAConstruire;
    }

    public int getNbPropriCouleur(CouleurPropriete aCoul) {
        throw new UnsupportedOperationException();
    }

    public int getNbCompagnies() {
        int j = 0;
        for (int i = 0; i <= lescompagnies.size(); i++) {
            j = i + 1;
        }
        return j;
    }

    public void setNumeroDebut() { //pour savoir le numero qu'il a obtenu pour savoir qui commence
        this.numerodebut = ((int) (Math.random() * 6) + 1);
    }

    public int getNumeroDebut() {
        return numerodebut;
    }

    public int getDouble() { //pour savoir si il a fait des doubles
        return doubl;
    }

    public void setDouble(int doubl) {
        this.doubl = doubl;
    }

    //public Collection VerifConstruction(ProprieteAConstruire aP, Groupe aGr) {
    //	throw new UnsupportedOperationException();
    //}
    public int resultatDés() {
        Random rnd = new Random();
        int i = rnd.nextInt(6) + 1;

        return i;
    }

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
    }

    public int getDeplacement() {
        return deplacement;
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    public void addCompanie(Compagnie c) {
        lescompagnies.add(c);
    }

    public void addGare(Gare g) {
        lesgares.add(g);
    }

    public void addProprietes(ProprieteAConstruire p) {
        lesproprietesAConstruire.add(p);
    }

    public int getLoyer() {
        return loyer;
    }

    public void setLoyer(int loyer) {
        this.loyer = loyer;
    }

    public void recevoirLoyer(int l) {
        cash = cash + l;
    }

    public void PayerLoyer(int l) {
        cash = cash - l;
    }

    public boolean PossedeGroupe(Groupe gr){
        
        ArrayList<ProprieteAConstruire> propriGroupe;
        ArrayList<ProprieteAConstruire> propriJoueur;
        boolean estPresent;
        
        propriGroupe= gr.getLesproprietes();
        propriJoueur= this.getLesPropio();
        
        estPresent=false;
        
        for(ProprieteAConstruire pacGr: propriGroupe){
            for (ProprieteAConstruire pacJ: propriJoueur){
                if (pacGr.equals(pacJ)){
                    estPresent=true; break;
                }
                estPresent=false;
            }
            if (estPresent=false){
                break;
            }
        }
        return estPresent;
    }
}
