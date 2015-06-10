/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

/**
 *
 * @author hoenc
 */
public class CarteGArgent extends Carte {
    private int montant; 

    public CarteGArgent(int montant, String des, Monopoly monop) {
        super(des, monop);
        this.montant = montant;
    }
    public void ActionCarteAnniversaire () {
        
    }
    public int DonneAnniversaire(){
        return(0);
    }

    @Override
    public void action(Joueur j) {
        
    }
}
