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
public abstract class Carte {
    private int numero;
    private Monopoly monopoly; 
    public Carte (int numero,Monopoly monop) {
        numero = this.numero;
        monop = monopoly; 
    }
    
    public void action (Joueur j) {
        
    }

    public int getNumero() {
        return numero;
    }
}
