/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeu;

import Data.*;
import java.util.ArrayList;
import java.util.Collections;
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
        monop = new Monopoly("./src/Data/src");
        
        monop.InitialiserPartie();
        } 
    
}

