/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import java.util.ArrayList;

/**
 *
 * @author hoenc
 */
public class CartePArgent extends Carte {
    private int montant;

    public CartePArgent(int montant,int num, String des, Monopoly monop) {
        super(num, des, monop);
        this.montant = montant;
    }
    public int PayerReparationMaison (ProprieteAConstruire prop, int prixMaison, int prixHotel) {
        int nbm = prop.getNbMaisons();
        if (nbm == 5){
            return (prixHotel);
        }else{
            return (nbm*prixMaison);
        }
    }
    public void ActionCarteMaison (Joueur j) {
        ArrayList<ProprieteAConstruire> p = j.getLesPropio();
        int n = this.getNumero();
        int pMaison;
        int pHotel;
        int prix=0;
        if (n == 11){
            pMaison =40;
            pHotel =115;
        }else {
            pMaison =25;
            pHotel =100;
        }
        for (ProprieteAConstruire prop : p){
            prix =prix +PayerReparationMaison(prop, pMaison, pHotel);
        }
        j.setCash(j.getCash()-prix);
    }
  

    public int getMontant() {
        return montant;
    }

    @Override
    public void action(Joueur j) {
        if (this.getNumero()!=11 && this.getNumero()!=13){
            j.setCash(j.getCash()-this.getMontant());
        }else{
            ActionCarteMaison(j);
        }
        
    }

}
