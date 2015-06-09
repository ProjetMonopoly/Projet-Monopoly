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
public class CartePArgent extends Carte {
    private int montant;

    public CartePArgent(int montant, int numero, Monopoly monop) {
        super(numero, monop);
        this.montant = montant;
    }
    public void PayerReparationMaison () {
        
    }
    public void ActionCarteMaison (Joueur j) {
        
    }
    public int calculprix () {
        return 0;
        
    }

    public int getMontant() {
        return montant;
    }

}
