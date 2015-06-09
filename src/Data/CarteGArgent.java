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

    public CarteGArgent(int montant, int numero, Monopoly monop) {
        super(numero, monop);
        this.montant = montant;
    }
    public void ActionCarteAnniversaire () {
        
    }
    public int DonneAnniversaire(){
        return(0);
    }
}
