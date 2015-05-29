/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jeu;




import Data.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author chevillc
 */
public class Main {
    
    private static Monopoly monop; 
    
       public static void main(String[] args) {        
        monop = new Monopoly("/users/info/pub/1a/M2104/data.txt" );
         
        int compte=1;
        HashMap<Integer, Carreau> lesCarreaux = monop.getLesCarreaux();
        
        for(Carreau c : lesCarreaux.values()){
            compte=compte+1;
            
        }
        System.out.println(compte);
        
        
        ArrayList<Joueur> lesjoueurs = new ArrayList<>();
        Carreau carreauInit = monop.getCarreau(1);
        int nbJoueur;
        
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Combien de joueur: ");
        nbJoueur = Integer.parseInt(sc1.nextLine());
        
        for (int i=1; i<=nbJoueur; i++){
            System.out.println("Entrer le nom du joueur "+i+" :");
            Joueur j = new Joueur(sc1.nextLine(),monop,carreauInit);
            lesjoueurs.add(j);
        }
        
        for (Joueur j: lesjoueurs ){
            System.out.println(j.getNomJoueur());
            System.out.println(j.getCarreau());
            System.out.println("YESSS");
        }
                
       }
       
       
       
       
               
       
       
       
       
}
    
