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
    private String description; //Chaque carte possède une description
    private Monopoly monopoly; 
    public Carte (String des,Monopoly monop) {
        des = description;
        monop = monopoly; 
    }
    
    public abstract void action (Joueur j);

    public String getDescription() {
        return description;
    }
        
    

    
}
