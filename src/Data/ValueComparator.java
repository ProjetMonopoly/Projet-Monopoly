/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author curtyl
 */
class ValueComparator implements Comparator<Joueur> {

    Map<Joueur, Integer> map;

    public ValueComparator(Map<Joueur, Integer> base) {
        this.map = base;
    }

    public int compare(Joueur a, Joueur b) {
        if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}
