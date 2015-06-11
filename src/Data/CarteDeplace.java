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
public class CarteDeplace extends Carte {

    private int CarreauOuAller;

    public CarteDeplace(int num, String des, Monopoly monop, int carreau) {
        super(num, des, monop);
        carreau = CarreauOuAller;

    }

    public int getCarreauOuAller() {
        return CarreauOuAller;
       
    }
    
    @Override
    public void action(Joueur j) {
        Monopoly m = super.getMonop();
        if (this.getNumero() != 3) { // si la carte n'est pas la carte "Reculer de 3 cases"
            Carreau c = m.getLesCarreaux().get(getCarreauOuAller()); //On regarde sur quel carreau le joueur doit se rendre
            
            if (j.getNumCarreau() < c.getNumcarreauCourant()) { // si le carreau est après le carreau où le joueur se trouve, on envoie directement le joueur au carreau 
                j.setPositionCourante(c);
            } else {
                j.setCash(j.getCash() + 200);       //si le carreau est avant alors on lui ajoute 200€ car il passe par la case depart
                j.setPositionCourante(c);           // puis on l'envoie sur le carreau
            }

        } else {                                    //cas de la carte qui demande de reculer de 3 cases
            j.ModifPosition(CarreauOuAller);
        }

    }

}
