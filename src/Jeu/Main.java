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
import java.util.TreeSet;

/**
 *
 * @author chevillc
 */
public class Main {

    private static Monopoly monop;

    public static void main(String[] args) {
        monop = new Monopoly("/users/info/etu-s2/riaudl/M2103-Java/Projet/Projet-Monopoly/src/Data/src");
//        TreeSet<Joueur> ordre = new TreeSet<>();

        int compte = 0;
        HashMap<Integer, Carreau> lesCarreaux = monop.getLesCarreaux();

        for (Carreau c : lesCarreaux.values()) {
            compte = compte + 1;

        }
        System.out.println(compte);

        Carreau carreauInit = lesCarreaux.get(1);

        int nbJoueur;

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Combien de joueur: ");
        nbJoueur = Integer.parseInt(sc1.nextLine());

        for (int i = 1; i <= nbJoueur; i++) {
            System.out.println("Entrer le nom du joueur " + i + " :");
            Joueur j = new Joueur(sc1.nextLine(), monop, carreauInit);
            int des = j.resultatDés();
            monop.setLesJoueurs(j);

        }

        for (Joueur j : monop.getLesJoueurs()) {//pour tester si l'inscription des joueurs a bien été effectué
            System.out.println(j.getNomJoueur());
            System.out.println(j.getCarreau().getNomCarreau());

            System.out.println("");

            monop.JouerUnCoup(j);
        }

    }

}
