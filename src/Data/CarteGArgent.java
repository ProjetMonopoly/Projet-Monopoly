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
public class CarteGArgent extends Carte {
    private int montant; 

    public CarteGArgent(int num, int montant, String des, Monopoly monop) {
        super(num, des, monop);
        this.montant = montant;
    }
    public void ActionCarteAnniversaire (Joueur j) {
        Monopoly m = getMonop();
        ArrayList<Joueur> joueurs = m.getJoueurs();
        joueurs.remove(j);
        for (Joueur jou : joueurs){
            DonneAnniversaire(j,jou);
        }
    }
    public void DonneAnniversaire(Joueur j, Joueur jAnniv){
        int cjAnniv = jAnniv.getCash();
        if (cjAnniv<10){
            j.setCash(cjAnniv);
            Monopoly m =super.getMonop();
            m.faillite(jAnniv);
 
        }else{
            jAnniv.setCash(jAnniv.getCash()-10);
            j.setCash(j.getCash() + 10);
        }
        
    }

    @Override
    public void action(Joueur j) {
        if (this.getNumero()!=25){
        j.setCash(j.getCash()+ this.montant);
        }else{
            ActionCarteAnniversaire(j);
            
        }
        
    }
}
